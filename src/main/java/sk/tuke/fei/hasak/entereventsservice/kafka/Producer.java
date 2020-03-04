package sk.tuke.fei.hasak.entereventsservice.kafka;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class Producer {

    private final KafkaTemplate<String, String> kafkaTemplate;

    @Value("${saved.event.topic}")
    private String topic;

    @Autowired
    public Producer(KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendSavedEventMssg(String message) {
        this.kafkaTemplate.send(topic, message);
        log.info("[Enter events service] message was sent.");
    }

}
