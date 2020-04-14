package sk.tuke.fei.hasak.entereventsservice.kafka;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class MessageDeletedProducer {

    private final KafkaTemplate<String, MessageDeleted> kafkaTemplate;

    @Value("${kafka.topic.message.deleted}")
    private String topic;

    @Autowired
    public MessageDeletedProducer(KafkaTemplate<String, MessageDeleted> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendMessageDeleted(MessageDeleted event) {
        log.info("[Enter events service] sending='{}'.", event);
        this.kafkaTemplate.send(topic, event);
    }

}
