package sk.tuke.fei.hasak.entereventsservice.kafka;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class Producer {

    private final KafkaTemplate<String, Foo> kafkaTemplate;

    @Value("${send.mssg.to.notify.service}")
    private String topic;

    @Autowired
    public Producer(KafkaTemplate<String, Foo> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendSavedEventMssg(Foo foo) {
        log.info("[Enter events service] sending='{}'.", foo);
        this.kafkaTemplate.send(topic, foo);
    }

}
