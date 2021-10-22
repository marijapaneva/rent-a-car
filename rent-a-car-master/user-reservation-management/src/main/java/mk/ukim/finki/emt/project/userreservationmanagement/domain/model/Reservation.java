package mk.ukim.finki.emt.project.userreservationmanagement.domain.model;

import lombok.Getter;
import mk.ukim.finki.emt.project.sharedkernel.domain.base.AbstractEntity;
import mk.ukim.finki.emt.project.userreservationmanagement.domain.valueobjects.CarId;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Entity
@Table(name = "reservation")
public class Reservation extends AbstractEntity<ReservationId> {
    @ManyToOne
    private User user;
    private LocalDateTime dateFrom;
    private LocalDateTime dateUntil;
    @AttributeOverride(name = "id", column = @Column(name = "car_id", nullable = false))
    private CarId carId;


    protected Reservation() {
        super(ReservationId.randomId(ReservationId.class));
    }

    public static Reservation build(User user, LocalDateTime dateFrom, LocalDateTime dateUntil, CarId carId) {
        Reservation reservation = new Reservation();
        reservation.user = user;
        reservation.dateFrom = dateFrom;
        reservation.dateUntil = dateUntil;
        reservation.carId = carId;
        return reservation;
    }
}
