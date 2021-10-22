package mk.ukim.finki.emt.project.carsmanagement.config;

import lombok.AllArgsConstructor;
import mk.ukim.finki.emt.project.carsmanagement.domain.model.Car;
import mk.ukim.finki.emt.project.carsmanagement.domain.repository.CarRepository;
import mk.ukim.finki.emt.project.carsmanagement.domain.valueobjects.Carmodel;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.Arrays;

@Component
@AllArgsConstructor
public class DataInitializer {
    private final CarRepository carRepository;

    @PostConstruct
    public void initData() {
        Car car1 = Car.build(Carmodel.MERCEDEZ, 10500.43F, 2008, "crna", true);
        Car car2 = Car.build(Carmodel.AUDI, 9000.3F, 2005, "siva", true);
        if (carRepository.findAll().isEmpty()) {
            carRepository.saveAll(Arrays.asList(car1, car2));
        }
    }
}