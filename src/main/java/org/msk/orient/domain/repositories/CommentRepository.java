package org.msk.orient.domain.repositories;

import org.msk.orient.domain.entities.Comment;
import org.msk.orient.domain.entities.Event;
import org.msk.orient.domain.entities.SystemUser;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author nivanov
 * on 21.09.17.
 */

@Repository
public interface CommentRepository extends CrudRepository<Comment, Long>{
    List<Comment> findByAuthorOrderByCreationTime(SystemUser author);
    List<Comment> findByEventOrderByCreationTime(Event event);
}
