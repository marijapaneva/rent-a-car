package mk.ukim.finki.emt.project.userreservationmanagement.xport.events;

import lombok.AllArgsConstructor;
import mk.ukim.finki.emt.project.sharedkernel.domain.config.TopicHolder;
import mk.ukim.finki.emt.project.sharedkernel.domain.events.DomainEvent;
import mk.ukim.finki.emt.project.sharedkernel.domain.events.carstatus.OnStatusChangedEvent;
import mk.ukim.finki.emt.project.userreservationmanagement.domain.valueobjects.CarId;
import mk.ukim.finki.emt.project.userreservationmanagement.services.UserService;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CarEventListener {
    private final UserService userService;

    @KafkaListener(topics= TopicHolder.TOPIC_AVAILABLE_STATUS_CHANGED, groupId = "carList")
    public void consumeOrderItemCreatedEvent(String jsonMessage) {
        try {
            OnStatusChangedEvent event = DomainEvent.fromJson(jsonMessage,OnStatusChangedEvent.class);
            userService.removeReservationForStatusChanged(CarId.of(event.getCarId()));
        } catch (Exception e){

        }

    }

}
