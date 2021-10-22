package mk.ukim.finki.emt.project.carsmanagement.domain.model;

import lombok.Getter;
import mk.ukim.finki.emt.project.carsmanagement.domain.valueobjects.Carmodel;
import mk.ukim.finki.emt.project.sharedkernel.domain.base.AbstractEntity;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;

@Getter
@Entity
@Table(name="car")
public class Car extends AbstractEntity<CarId> {

    @Enumerated(value = EnumType.STRING)
    private Carmodel carmodel;
    private Float price;
    private Integer year;
    private String color;
    private Boolean availableStatus;

    protected Car() {
        super(CarId.randomId(CarId.class));
    }

    public static Car build(Carmodel carmodel, Float price, Integer year, String color, Boolean availableStatus) {
        Car car = new Car();
        car.carmodel = carmodel;
        car.price = price;
        car.year = year;
        car.color = color;
        car.availableStatus = availableStatus;
        return car;
    }

    public Car editCarInfo(Carmodel carmodel, float price, Integer year, String color, Boolean availableStatus) {
        this.carmodel = carmodel;
        this.price  = price;
        this.year = year;
        this.color = color;
        this.availableStatus = availableStatus;
        return this;
    }

    public Car changeCarStatus(Boolean availableStatus) {
        this.availableStatus = availableStatus;
        return this;
    }

}
