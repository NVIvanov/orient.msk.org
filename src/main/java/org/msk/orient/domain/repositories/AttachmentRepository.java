package org.msk.orient.domain.repositories;

import org.msk.orient.domain.entities.Attachment;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * @author nivanov
 * on 21.09.17.
 */

@Repository
public interface AttachmentRepository extends CrudRepository<Attachment, Long>{
}
