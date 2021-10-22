package mk.ukim.finki.emt.project.userreservationmanagement.domain.valueobjects;

import mk.ukim.finki.emt.project.sharedkernel.domain.base.DomainObjectId;

import javax.persistence.Embeddable;

@Embeddable
public class CarId extends DomainObjectId {
    private CarId() {
        super(CarId.randomId(CarId.class).getId());
    }

    public CarId(String id) {
        super(id);
    }
    public static CarId of(String uuid) {
        CarId d = new CarId(uuid);
        return d;
    }

}
