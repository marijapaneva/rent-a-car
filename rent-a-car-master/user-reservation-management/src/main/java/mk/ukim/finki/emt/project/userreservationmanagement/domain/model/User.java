package mk.ukim.finki.emt.project.userreservationmanagement.domain.model;

import lombok.Getter;
import mk.ukim.finki.emt.project.sharedkernel.domain.base.AbstractEntity;
import mk.ukim.finki.emt.project.userreservationmanagement.domain.valueobjects.Email;

import javax.persistence.*;

@Getter
@Entity
@Table(name="[USER]")
public class User extends AbstractEntity<UserId> {
    private Email email;
    private String name;
    private String gender;
    private Integer age;
    private Boolean jobStatus;

    protected User() {
        super(UserId.randomId(UserId.class));
    }

    public static User build(Email email, String name, String gender, Integer age, Boolean jobStatus) {
        User user = new User();
        user.email = email;
        user.name = name;
        user.gender = gender;
        user.age = age;
        user.jobStatus = jobStatus;
        return user;
    }
    public User editUserInfo(Email email, String name, String gender, Integer age, Boolean jobStatus) {
        this.email = email;
        this.name = name;
        this.gender = gender;
        this.age = age;
        this.jobStatus = jobStatus;
        return this;
    }
}
