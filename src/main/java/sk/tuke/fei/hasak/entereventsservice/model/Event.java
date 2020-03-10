/*
 * Copyright (c) 2019 Šimon Hašák.
 * All rights reserved.
 */

package sk.tuke.fei.hasak.entereventsservice.model;

import lombok.Data;
import org.springframework.hateoas.RepresentationModel;

import javax.persistence.*;
import javax.validation.constraints.Email;
import java.time.LocalDateTime;

/**
 * The type Event.
 *
 * @author Šimon Hašák
 */
@Entity
@Data
@Table(name = "enter_events_tb")
public class Event extends RepresentationModel<Event> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "message", nullable = false)
    private String message;

    @Email
    @Column(name = "email", nullable = false)
    private String email;

    @Transient
    private LocalDateTime time;
}
