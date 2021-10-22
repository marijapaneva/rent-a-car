package mk.ukim.finki.emt.project.userreservationmanagement.config;

import lombok.AllArgsConstructor;

import mk.ukim.finki.emt.project.userreservationmanagement.domain.model.User;
import mk.ukim.finki.emt.project.userreservationmanagement.domain.repository.UserRepository;
import mk.ukim.finki.emt.project.userreservationmanagement.domain.valueobjects.Email;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.Arrays;

@Component
@AllArgsConstructor
public class DataInitializer {
    private final UserRepository userRepository;

    @PostConstruct
    public void initData() {
        User user1 = User.build(new Email("girl1_girl@gmail.com"), "Maci", "female",20,true);
        User user2 = User.build(new Email("daci_23@gmail.com"), "Daci", "male",14,true);
        if (userRepository.findAll().isEmpty()) {
            userRepository.saveAll(Arrays.asList(user1, user2));
        }
    }
}