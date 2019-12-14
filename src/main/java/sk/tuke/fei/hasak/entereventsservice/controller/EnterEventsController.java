/*
 * Copyright (c) 2019 Šimon Hašák.
 * All rights reserved.
 */

package sk.tuke.fei.hasak.entereventsservice.controller;

import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import sk.tuke.fei.hasak.entereventsservice.model.Event;
import sk.tuke.fei.hasak.entereventsservice.service.EnterEventsService;

/**
 * @author Šimon Hašák
 */
@RestController
@RequestMapping("/enter-events")
@Slf4j
@RequiredArgsConstructor
public class EnterEventsController {


    private final EnterEventsService eventsService;


    @GetMapping()
    public Iterable<Event> findAll() {
        return eventsService.findAll();
    }

    @SneakyThrows
    @GetMapping("/{id}")
    public Event findById(@PathVariable Long id) {
        return eventsService.findById(id);
    }

    @PostMapping()
    public Event save(@RequestBody Event event) { return eventsService.save(event); }

    @SneakyThrows
    @PutMapping("/{id}")
    public void update(@RequestBody Event event, @PathVariable Long id) { eventsService.update(event, id); }

    @SneakyThrows
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) { eventsService.deleteById(id); }

}
