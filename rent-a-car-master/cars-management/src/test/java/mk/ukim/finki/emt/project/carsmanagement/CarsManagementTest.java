package mk.ukim.finki.emt.project.carsmanagement;

import mk.ukim.finki.emt.project.carsmanagement.domain.model.Car;
import mk.ukim.finki.emt.project.carsmanagement.domain.repository.CarRepository;
import mk.ukim.finki.emt.project.carsmanagement.domain.valueobjects.Carmodel;
import mk.ukim.finki.emt.project.carsmanagement.services.CarService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;



@SpringBootTest
public class CarsManagementTest {
    @Autowired
    private CarService carService;
    @Autowired CarRepository carRepository;


    private static Car newCar() {
        return Car.build(Carmodel.MERCEDEZ, 10500.2F, 2008, "crna", true);
    }

    @Test
    public void testCarStatusChanged() {
        Car car = CarsManagementTest.newCar();
        carRepository.save(car);
        carService.changeStatus(car.getId(),false);
        Assertions.assertEquals(car.getAvailableStatus(), false);

    }
}

