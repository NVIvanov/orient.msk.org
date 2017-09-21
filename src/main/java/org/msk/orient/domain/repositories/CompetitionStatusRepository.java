package org.msk.orient.domain.repositories;

import org.msk.orient.domain.entities.CompetitionStatus;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * @author nivanov
 * on 21.09.17.
 */

@Repository
public interface CompetitionStatusRepository extends CrudRepository<CompetitionStatus, Long>{
    Optional<CompetitionStatus> findByTitle(String title);
}
