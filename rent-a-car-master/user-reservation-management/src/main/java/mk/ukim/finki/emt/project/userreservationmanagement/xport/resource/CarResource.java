package mk.ukim.finki.emt.project.userreservationmanagement.xport.resource;

import lombok.AllArgsConstructor;
import mk.ukim.finki.emt.project.userreservationmanagement.domain.model.Reservation;
import mk.ukim.finki.emt.project.userreservationmanagement.domain.model.UserId;
import mk.ukim.finki.emt.project.userreservationmanagement.domain.valueobjects.Car;
import mk.ukim.finki.emt.project.userreservationmanagement.domain.valueobjects.Email;
import mk.ukim.finki.emt.project.userreservationmanagement.services.UserService;
import mk.ukim.finki.emt.project.userreservationmanagement.xport.client.CarClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/cars")
@CrossOrigin(origins = "http://localhost:3000")
public class CarResource {
     private final CarClient carClient;
     private final UserService reservationService;

    @GetMapping
    public List<Car> getAll() {
        return carClient.findAll();
    }


    @GetMapping("/{id}")
    public ResponseEntity<?> reserveById(@PathVariable String id) {
        UserId userId = this.reservationService.findByEmail(new Email("girl1_girl@gmail.com")).getId();
        try {
           Reservation reservation = this.reservationService.createReservation(userId, this.carClient.findCarById(id)).get();
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
        return ResponseEntity.ok().body(this.carClient.changeCarStatus(id));
    }
}
