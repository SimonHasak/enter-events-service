package sk.tuke.fei.entereventsservice.model;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Data
@Table(name = "events")
public class Event {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "message", nullable = false)
    private String message;

    @Column(name = "email", nullable = false)
    private String email;

    @Column(name = "event_time", nullable = false)
    private LocalDateTime eventTime;

}
