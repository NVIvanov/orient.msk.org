package org.msk.orient.domain.repositories;

import org.msk.orient.domain.entities.Competition;
import org.msk.orient.domain.entities.Event;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author nivanov
 * on 21.09.17.
 */

@Repository
public interface EventRepository extends CrudRepository<Event, Long> {
    List<Event> findByCompetitionOrderByTime(Competition competition);
}
