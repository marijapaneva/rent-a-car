package mk.ukim.finki.emt.project.carsmanagement.xport.rest;

import lombok.AllArgsConstructor;
import mk.ukim.finki.emt.project.carsmanagement.domain.model.Car;
import mk.ukim.finki.emt.project.carsmanagement.domain.model.CarId;
import mk.ukim.finki.emt.project.carsmanagement.services.CarService;
import mk.ukim.finki.emt.project.carsmanagement.services.form.CarForm;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/cars")
@CrossOrigin(origins = "http://localhost:3000")
public class CarRestController {
     private final CarService carService;

    @GetMapping
    public List<Car> getAll() {
        return carService.findAllCars();
    }

    @PostMapping("/add")
    public ResponseEntity<Car> create(@RequestBody CarForm carForm) {
        return this.carService.createCarEntity(carForm).map(car -> ResponseEntity.ok().body(car))
                .orElseGet(() -> ResponseEntity.badRequest().build());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Car> findById(@PathVariable String id) {
        CarId carId = new CarId(id);
        return this.carService.findById(carId)
                .map(car -> ResponseEntity.ok().body(car))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PutMapping("/edit/{id}")
    public ResponseEntity<Car> edit(@PathVariable String id, @RequestBody CarForm carForm) {
        CarId carId = new CarId(id);
        return this.carService.editCarEntity(carId,carForm)
                .map(attraction -> ResponseEntity.ok().body(attraction))
                .orElseGet(() -> ResponseEntity.badRequest().build());
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteById(@PathVariable String id) {
        CarId carId = new CarId(id);
        this.carService.deleteCarEntity(carId);
        if (this.carService.findById(carId).isEmpty()) return ResponseEntity.ok().build();
        return ResponseEntity.badRequest().build();
    }

    @GetMapping("/reserved/{id}")
    public ResponseEntity<Car> reserveCarChangeStatus(@PathVariable String id) {
        CarId carId = new CarId(id);
        Car car = carService.changeStatus(carId, false);
        return ResponseEntity.ok().body(car);
    }
}
