package org.msk.orient.domain.repositories;

import org.msk.orient.domain.entities.SystemUser;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * @author nivanov
 * on 21.09.17.
 */

@Repository
public interface UserRepository extends CrudRepository<SystemUser, Long>{
    Optional<SystemUser> findByEmail(String email);
}
