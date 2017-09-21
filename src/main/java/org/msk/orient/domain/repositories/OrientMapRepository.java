package org.msk.orient.domain.repositories;

import org.msk.orient.domain.entities.OrientMap;
import org.msk.orient.domain.entities.SystemUser;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author nivanov
 * on 21.09.17.
 */

@Repository
public interface OrientMapRepository extends CrudRepository<OrientMap, Long>{
    List<OrientMap> findByAuthor(SystemUser author);
}
