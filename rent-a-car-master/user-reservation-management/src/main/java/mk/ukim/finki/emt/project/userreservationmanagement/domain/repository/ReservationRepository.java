package mk.ukim.finki.emt.project.userreservationmanagement.domain.repository;

import mk.ukim.finki.emt.project.userreservationmanagement.domain.model.Reservation;
import mk.ukim.finki.emt.project.userreservationmanagement.domain.model.ReservationId;
import mk.ukim.finki.emt.project.userreservationmanagement.domain.model.User;
import mk.ukim.finki.emt.project.userreservationmanagement.domain.valueobjects.CarId;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ReservationRepository extends JpaRepository<Reservation, ReservationId> {
    Reservation findReservationByUserAndCarId(User user, CarId carId);
    List<Reservation> findAllByCarId(CarId carId);
}
