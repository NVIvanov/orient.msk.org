package org.msk.orient.domain.repositories;

import org.msk.orient.domain.entities.Competition;
import org.msk.orient.domain.entities.PhotoAlbum;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author nivanov
 * on 21.09.17.
 */

@Repository
public interface PhotoAlbumRepository extends CrudRepository<PhotoAlbum, Long>{
    List<PhotoAlbum> findByCompetitionOrderByCreationTime(Competition competition);
}
