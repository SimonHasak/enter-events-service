package sk.tuke.fei.hasak.entereventsservice.kafka;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class Consumer {

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    @Value("${send.mssg.to.notify.service}")
    private String topic;

    @KafkaListener(topics = "${saved.event.topic}")
    public void processMessage(String message) {
        log.info("[Enter events service] message was received");
        kafkaTemplate.send(topic, "peso");
        log.info("[Enter events service] message was sent to notify-service");
    }

}
