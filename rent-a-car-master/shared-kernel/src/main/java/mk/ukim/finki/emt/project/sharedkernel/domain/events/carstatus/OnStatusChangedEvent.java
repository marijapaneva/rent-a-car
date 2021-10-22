package mk.ukim.finki.emt.project.sharedkernel.domain.events.carstatus;

import lombok.Getter;
import mk.ukim.finki.emt.project.sharedkernel.domain.config.TopicHolder;
import mk.ukim.finki.emt.project.sharedkernel.domain.events.DomainEvent;


@Getter
public class OnStatusChangedEvent extends DomainEvent {

    private String carId;
    private String message;

    public OnStatusChangedEvent(String topic) {
        super(TopicHolder.TOPIC_AVAILABLE_STATUS_CHANGED);
    }

    public OnStatusChangedEvent(String carId, String message) {
        super(TopicHolder.TOPIC_AVAILABLE_STATUS_CHANGED);
        this.carId = carId;
        this.message = message;
    }

}
