package org.msk.orient.domain.entities;

import lombok.AccessLevel;
import lombok.Data;
import lombok.NonNull;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;
import java.util.List;

/**
 * @author nivanov
 *         on 31.08.17.
 */

@Entity
@Table(name = "albums")
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

    @NonNull
    @ManyToOne
    private Competition competition;

    @NonNull
    @Setter(AccessLevel.NONE)
    @Column(columnDefinition = "TIMESTAMP")
    private LocalDateTime creationTime;
}
