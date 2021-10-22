package mk.ukim.finki.emt.project.carsmanagement.services.form;

import lombok.Data;
import mk.ukim.finki.emt.project.carsmanagement.domain.valueobjects.Carmodel;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
public class CarForm {
    @NotBlank(message = "Car name must not be blank")
    private Carmodel carmodel;
    @NotNull
    private Float price;
    @NotBlank(message = "Car price must not be blank")
    private Integer year;
    @NotBlank(message = "Car year must not be blank")
    private String color;
    @NotBlank(message = "Car color must not be blank")
    private Boolean availableStatus;
}
