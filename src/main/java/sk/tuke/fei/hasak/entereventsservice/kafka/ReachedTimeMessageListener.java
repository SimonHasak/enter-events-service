package sk.tuke.fei.hasak.entereventsservice.kafka;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;
import sk.tuke.fei.hasak.entereventsservice.model.Event;
import sk.tuke.fei.hasak.entereventsservice.service.EnterEventsService;

@Slf4j
@Component
public class ReachedTimeMessageListener {

    private final KafkaTemplate<String, NotifyServiceMessage> kafkaTemplate;

    private EnterEventsService eventsService;

    @Value("${kafka.notify.service.event}")
    private String topic;

    @Autowired
    public ReachedTimeMessageListener(KafkaTemplate<String, NotifyServiceMessage> kafkaTemplate, EnterEventsService eventsService) {
        this.kafkaTemplate = kafkaTemplate;
        this.eventsService = eventsService;
    }

    @SneakyThrows
    @KafkaListener(topics = "${kafka.reached.time.event}", groupId = "${kafka.group.reached.time.receiver}")
    public void processMessage(ReachedTimeMessage message) {
        log.info("[Enter events service] received:{}", message);

        Event event = eventsService.findById(message.getId());

        NotifyServiceMessage notifyMessage = new NotifyServiceMessage(event.getMessage(), event.getEmail());

        kafkaTemplate.send(topic, notifyMessage);

        log.info("[Enter events service] send:{}", notifyMessage);
    }

}
