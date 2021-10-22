package mk.ukim.finki.emt.project.carsmanagement.domain.repository;

import mk.ukim.finki.emt.project.carsmanagement.domain.model.Car;
import mk.ukim.finki.emt.project.carsmanagement.domain.model.CarId;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CarRepository extends JpaRepository<Car, CarId> {
    Optional<Car> findById(CarId carId);
}
