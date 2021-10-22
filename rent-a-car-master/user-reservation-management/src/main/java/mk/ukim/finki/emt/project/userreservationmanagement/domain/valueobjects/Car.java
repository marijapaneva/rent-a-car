package mk.ukim.finki.emt.project.userreservationmanagement.domain.valueobjects;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import mk.ukim.finki.emt.project.sharedkernel.domain.base.ValueObject;

@Getter
public class Car implements ValueObject {
    private final CarId id;
    private final Carmodel carmodel;
    private final float price;
    private final Integer year;
    private final String color;
    private final Boolean availableStatus;

    private Car() {
        this.id = CarId.randomId(CarId.class);
        this.carmodel = Carmodel.valueOf("OTHER");
        this.price = 0;
        this.year = 0;
        this.color = "unknown";
        this.availableStatus = false;
    }

    @JsonCreator
    public Car(@JsonProperty("id") CarId id,
               @JsonProperty("race") Carmodel carmodel,
               @JsonProperty("age") float price,
               @JsonProperty("age") Integer year,
               @JsonProperty("gender") String color,
               @JsonProperty("availableStatus") Boolean availableStatus) {
        this.id = id;
        this.carmodel = carmodel;
        this.price = price;
        this.year = year;
        this.color = color;
        this.availableStatus = availableStatus;
    }

}
