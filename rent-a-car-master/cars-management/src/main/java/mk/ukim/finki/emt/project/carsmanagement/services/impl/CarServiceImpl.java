package mk.ukim.finki.emt.project.carsmanagement.services.impl;

import lombok.AllArgsConstructor;
import mk.ukim.finki.emt.project.carsmanagement.domain.exceptions.CarNotFoundException;
import mk.ukim.finki.emt.project.carsmanagement.domain.model.Car;
import mk.ukim.finki.emt.project.carsmanagement.domain.model.CarId;
import mk.ukim.finki.emt.project.carsmanagement.domain.repository.CarRepository;
import mk.ukim.finki.emt.project.carsmanagement.services.CarService;
import mk.ukim.finki.emt.project.carsmanagement.services.form.CarForm;
import mk.ukim.finki.emt.project.sharedkernel.infra.DomainEventPublisher;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
@AllArgsConstructor
public class CarServiceImpl implements CarService {
    private final CarRepository carRepository;
    private final DomainEventPublisher domainEventPublisher;


    @Override
    public List<Car> findAllCars() {
        return this.carRepository.findAll();
    }

    @Override
    public Optional<Car> findById(CarId carId) {
        return this.carRepository.findById(carId);
    }

    @Override
    public Car findByIdWithoutOptional(CarId carId) {
        return this.carRepository.findById(carId).orElseThrow(CarNotFoundException::new);
    }

    @Override
    public Optional<Car> createCarEntity(CarForm carForm) {
        Car car = Car.build(carForm.getCarmodel(), carForm.getPrice(), carForm.getYear(), carForm.getColor(), carForm.getAvailableStatus());
        return Optional.of(this.carRepository.save(car));
    }

    @Override
    public Optional<Car> editCarEntity(CarId carId, CarForm form) {
        Car car = this.findByIdWithoutOptional(carId);
        return Optional.of(this.carRepository.save(car.editCarInfo(form.getCarmodel(), form.getPrice(), form.getYear(), form.getColor(), form.getAvailableStatus())));
    }

    @Override
    public void deleteCarEntity(CarId id) {
        this.carRepository.deleteById(id);
    }

    @Override
    public Car changeStatus(CarId carId, Boolean status) {
        Car car = this.findByIdWithoutOptional(carId);
        car.changeCarStatus(status);
        this.carRepository.save(car);
        return car;
    }
}
