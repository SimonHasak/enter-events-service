package sk.tuke.fei.hasak.entereventsservice.kafka;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalDateTime;

@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class SavedEventMessage {

    private long id;

    @JsonSerialize(using = LocalDateTimeSerializer.class)
    private LocalDateTime time = LocalDateTime.now();

}