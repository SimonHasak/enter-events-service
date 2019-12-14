/*
 * Copyright (c) 2019 Šimon Hašák.
 * All rights reserved.
 */

package sk.tuke.fei.hasak.entereventsservice.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import sk.tuke.fei.hasak.entereventsservice.exception.EventNotFoundException;
import sk.tuke.fei.hasak.entereventsservice.model.Event;
import sk.tuke.fei.hasak.entereventsservice.repository.EnterEventsRepository;

import java.util.Optional;

/**
 * @author Šimon Hašák
 */
@Service
@RequiredArgsConstructor
public class EnterEventsService {

    private final EnterEventsRepository eventsRepository;


    public Iterable<Event> findAll() { return eventsRepository.findAll(); }

    public Event findById(Long id) throws EventNotFoundException {
        Optional<Event> eventOptional = eventsRepository.findById(id);

        if (eventOptional.isEmpty()) {
            throw new EventNotFoundException("Event with id: " + id + " was not found.");
        }

        return eventOptional.get();
    }

    public Event save(Event event) {
        return eventsRepository.save(event);
    }

    public void update(Event event, Long id) throws EventNotFoundException{
        Optional<Event> eventOptional = eventsRepository.findById(id);

        if (eventOptional.isEmpty()) {
            throw new EventNotFoundException("Event with id: " + id + " was not found.");
        }

        event.setId(id);
        eventsRepository.save(event);
    }

    public void deleteById(Long id) {
        eventsRepository.deleteById(id);
    }
}
