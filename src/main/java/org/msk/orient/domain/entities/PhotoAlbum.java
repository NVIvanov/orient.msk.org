package org.msk.orient.domain.entities;

import lombok.Data;
import lombok.NonNull;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.List;

/**
 * @author nivanov
 *         on 31.08.17.
 */

@Entity
@Data
public class PhotoAlbum {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NonNull
    @Size(min = 1, max = 300)
    private String title;

    @Size(max = 2000)
    private String description;

    @NonNull
    @OneToMany
    private List<Attachment> photos;
}
