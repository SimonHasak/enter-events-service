package sk.tuke.fei.hasak.entereventsservice.kafka;

import org.springframework.kafka.support.serializer.JsonDeserializer;

public class ReachedTimeMessageDeserializer extends JsonDeserializer<ReachedTimeMessage> {

    public ReachedTimeMessageDeserializer() {
        super(ReachedTimeMessage.class);
    }
}
