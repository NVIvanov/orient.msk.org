package org.msk.orient.domain.repositories;

import org.msk.orient.domain.entities.EventType;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * @author nivanov
 * on 21.09.17.
 */

@Repository
public interface EventTypeRepository extends CrudRepository<EventType, Long>{
}
