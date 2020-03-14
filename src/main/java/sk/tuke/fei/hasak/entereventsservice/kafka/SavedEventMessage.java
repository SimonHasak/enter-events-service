package sk.tuke.fei.hasak.entereventsservice.kafka;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;
import lombok.Getter;
import lombok.ToString;

import javax.persistence.Id;
import java.time.LocalDateTime;

@Getter
@ToString
public class Foo {

    @Id
    private long id;

    @JsonSerialize(using = LocalDateTimeSerializer.class)
    private LocalDateTime time = LocalDateTime.now();

    public Foo() { }

    public Foo(long id, LocalDateTime time) {
        this.id = id;
        this.time = time;
    }
}