package mk.ukim.finki.emt.project.carsmanagement.services;

import mk.ukim.finki.emt.project.carsmanagement.domain.model.Car;
import mk.ukim.finki.emt.project.carsmanagement.domain.model.CarId;
import mk.ukim.finki.emt.project.carsmanagement.services.form.CarForm;
import java.util.List;
import java.util.Optional;

public interface CarService {
    List<Car> findAllCars();
    Optional<Car> findById(CarId carId);
    Car findByIdWithoutOptional(CarId carId);
    Optional<Car> createCarEntity(CarForm carForm);
    Optional<Car> editCarEntity(CarId carId, CarForm form);
    void deleteCarEntity(CarId id);
    Car changeStatus(CarId carId, Boolean status);
}
