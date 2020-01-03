/*
 * Copyright (c) 2019 Šimon Hašák.
 * All rights reserved.
 */

package sk.tuke.fei.hasak.entereventsservice.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import sk.tuke.fei.hasak.entereventsservice.model.Event;

/**
 * The interface Enter events repository.
 *
 * @author Šimon Hašák
 */
@Repository
public interface EnterEventsRepository extends CrudRepository<Event, Long> {
}
