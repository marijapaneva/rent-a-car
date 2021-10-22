package mk.ukim.finki.emt.project.carsmanagement.domain.model;

import lombok.NonNull;
import mk.ukim.finki.emt.project.sharedkernel.domain.base.DomainObjectId;

public class CarId extends DomainObjectId {

    private CarId() {
        super(CarId.randomId(CarId.class).getId());
    }

    public CarId(@NonNull String id) {
        super(id);
    }

    public static CarId of(String id) {
        return new CarId(id);
    }
}
