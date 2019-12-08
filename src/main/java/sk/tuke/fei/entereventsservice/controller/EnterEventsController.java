package sk.tuke.fei.entereventsservice.controller;

import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import sk.tuke.fei.entereventsservice.model.Event;
import sk.tuke.fei.entereventsservice.service.EnterEventsService;


@RestController
@RequestMapping("/")
@Slf4j
@RequiredArgsConstructor
public class EnterEventsController {

    private final EnterEventsService eventsService;



    @GetMapping("/findAll")
    public Iterable<Event> findAll() {
        return eventsService.findAll();
    }

    @SneakyThrows
    @GetMapping("/findById/{id}")
    public Event findById(@PathVariable Long id) {
        return eventsService.findById(id);
    }

    @PostMapping("/save")
    public Event save(@RequestBody Event event) { return eventsService.save(event); }

    @SneakyThrows
    @PutMapping("/update/{id}")
    public void update(@RequestBody Event event, @PathVariable Long id) { eventsService.update(event, id); }

    @SneakyThrows
    @DeleteMapping("delete/{id}")
    public void delete(@PathVariable Long id) { eventsService.deleteById(id); }

}
