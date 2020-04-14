/*
 * Copyright (c) 2019 Šimon Hašák.
 * All rights reserved.
 */

package sk.tuke.fei.hasak.entereventsservice.model;

import lombok.*;
import org.springframework.hateoas.RepresentationModel;

import javax.persistence.*;


/**
 * The type Event.
 *
 * @author Šimon Hašák
 */
@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
@Table(name = "enter_events_tb")
public class Event extends RepresentationModel<Event> {

    @Id
    @Column(name = "message_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long messageId;

    @Column(name = "text", nullable = false)
    private String text;

    public Event(String text) {
        this.text = text;
    }
}
