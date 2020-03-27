/*
 * Copyright (c) 2019 Šimon Hašák.
 * All rights reserved.
 */

package sk.tuke.fei.hasak.entereventsservice.controller;

import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.web.bind.annotation.*;
import sk.tuke.fei.hasak.entereventsservice.model.Event;
import sk.tuke.fei.hasak.entereventsservice.service.EnterEventsService;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;


/**
 * The type Enter events controller.
 *
 * @author Šimon Hašák
 */
@RestController
@RequestMapping("/enter-events")
@RequiredArgsConstructor
public class EnterEventsController {


    private final EnterEventsService eventsService;


    /**
     * Find all iterable events.
     *
     * @return the iterable events.
     */
    @GetMapping()
    public CollectionModel<EntityModel<Event>> findAll() {
        List<EntityModel<Event>> events = StreamSupport.stream(eventsService.findAll().spliterator(), false)
                .map(event -> new EntityModel<>(event,
                        linkTo(methodOn(EnterEventsController.class).findById(event.getMessageId())).withSelfRel(),
                        linkTo(EnterEventsController.class).withSelfRel()))
                .collect(Collectors.toList());

        return new CollectionModel<>(events);
    }

    /**
     * Find event by id.
     *
     * @param id the id of event
     * @return the event.
     */
    @SneakyThrows
    @GetMapping("/{id}")
    public Event findById(@PathVariable long id) {

        Event event = eventsService.findById(id);

        event.add(linkTo(methodOn(EnterEventsController.class).findById(event.getMessageId())).withSelfRel(),
                linkTo(EnterEventsController.class).withSelfRel());

        return event;
    }

    /**
     * Save event.
     *
     * @param event the event to be save.
     * @return the event
     */
    @PostMapping()
    public EntityModel<Event> save(@RequestBody Event event) {
        Event savedEvent = eventsService.save(event);

        savedEvent.add(linkTo(methodOn(EnterEventsController.class).findById(event.getMessageId())).withSelfRel(),
                linkTo(EnterEventsController.class).withSelfRel());

        return new EntityModel<>(savedEvent);
    }

    /**
     * Update event.
     *
     * @param event the new event
     * @param id    the id of old event to be updated by new one.
     */
    @SneakyThrows
    @PutMapping("/{id}")
    public EntityModel<Event> update(@RequestBody Event event, @PathVariable long id) {
        Event updatedEvent = eventsService.update(event, id);

        updatedEvent.add(linkTo(methodOn(EnterEventsController.class).findById(updatedEvent.getMessageId())).withSelfRel(),
                linkTo(EnterEventsController.class).withSelfRel());

        return new EntityModel<>(updatedEvent);
    }

    /**
     * Delete event by its id.
     *
     * @param id the id.
     */
    @SneakyThrows
    @DeleteMapping("/{id}")
    public void delete(@PathVariable long id) { eventsService.deleteById(id); }

}
