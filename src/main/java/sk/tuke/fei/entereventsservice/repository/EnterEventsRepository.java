package sk.tuke.fei.entereventsservice.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import sk.tuke.fei.entereventsservice.model.Event;

@Repository
public interface EnterEventsRepository extends CrudRepository<Event, Long> {
}
