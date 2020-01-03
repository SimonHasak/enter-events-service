/*
 * Copyright (c) 2019 Šimon Hašák.
 * All rights reserved.
 */

package sk.tuke.fei.hasak.entereventsservice.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import sk.tuke.fei.hasak.entereventsservice.exception.EventNotFoundException;
import sk.tuke.fei.hasak.entereventsservice.model.Event;
import sk.tuke.fei.hasak.entereventsservice.repository.EnterEventsRepository;

import java.util.Optional;

/**
 * The type Enter events service.
 *
 * @author Šimon Hašák
 */
@Slf4j
@RequiredArgsConstructor
@Service
public class EnterEventsService {

    private final EnterEventsRepository eventsRepository;


    /**
     * Find all iterable events.
     *
     * @return the iterable events.
     */
    public Iterable<Event> findAll() { return eventsRepository.findAll(); }

    /**
     * Find event by its id.
     *
     * @param id the id of wanted event.
     * @return the event
     * @throws EventNotFoundException the event not found exception
     */
    public Event findById(Long id) throws EventNotFoundException {
        Optional<Event> eventOptional = eventsRepository.findById(id);

        if (eventOptional.isEmpty()) {
            throw new EventNotFoundException("Event with id: " + id + " was not found.");
        }

        return eventOptional.get();
    }

    /**
     * Save event.
     *
     * @param event the event to be saved.
     * @return the event
     */
    public Event save(Event event) {
        Event savedEvent = eventsRepository.save(event);

        log.info("[Enter-event-service] Event with id: {} saved", savedEvent.getId());

        return savedEvent;
    }

    /**
     * Update.
     *
     * @param event the new event
     * @param id    the id of old event to be updated by new one
     * @throws EventNotFoundException the event not found exception
     */
    public Event update(Event event, Long id) throws EventNotFoundException{
        Optional<Event> eventOptional = eventsRepository.findById(id);

        if (eventOptional.isEmpty()) {
            throw new EventNotFoundException("Event with id: " + id + " was not found.");
        }

        log.info("[Enter-event-service] Event with id: {} updated", id);

        event.setId(id);
        eventsRepository.save(event);

        return event;
    }

    /**
     * Delete event by its id.
     *
     * @param id the id
     */
    public void deleteById(Long id) {
        log.info("[Enter-event-service] Event with id: {} deleted", id);
        eventsRepository.deleteById(id);
    }
}
