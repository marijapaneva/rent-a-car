package mk.ukim.finki.emt.project.userreservationmanagement.services.forms;

import lombok.Data;
import mk.ukim.finki.emt.project.userreservationmanagement.domain.valueobjects.Email;

import javax.validation.constraints.NotBlank;

@Data
public class UserForm {
    @NotBlank(message = "User email must not be blank")
    private Email email;
    @NotBlank(message = "User name must not be blank")
    private String name;
    private String gender;
    private Integer age;
    @NotBlank(message = "User job status must not be blank")
    private Boolean jobStatus;
}
