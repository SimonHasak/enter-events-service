package sk.tuke.fei.hasak.entereventsservice.kafka;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class SavedEventMessageProducer {

    private final KafkaTemplate<String, SavedEventMessage> kafkaTemplate;

    @Value("${kafka.topic.saved.event.message}")
    private String topic;

    @Autowired
    public SavedEventMessageProducer(KafkaTemplate<String, SavedEventMessage> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendSavedEventMessage(SavedEventMessage event) {
        log.info("[Enter events service] sending='{}'.", event);
        this.kafkaTemplate.send(topic, event);
    }

}
