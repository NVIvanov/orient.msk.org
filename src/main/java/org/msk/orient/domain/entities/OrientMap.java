package org.msk.orient.domain.entities;

import lombok.Data;
import lombok.NonNull;
import org.springframework.data.geo.Point;

import javax.persistence.*;
import javax.validation.constraints.Size;

/**
 * @author nivanov
 *         on 31.08.17.
 */

@Entity
@Table(name = "maps")
@Data
public class OrientMap {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NonNull
    @Size(min = 1, max = 300)
    private String title;

    @Size(max = 2000)
    private String description;

    @NonNull
    @Column(columnDefinition = "POINT")
    private Point location;

    @NonNull
    @OneToOne
    private Attachment preview;

    @NonNull
    @OneToOne
    private Attachment lowQuality;

    @NonNull
    @OneToOne
    private Attachment highQuality;

    @NonNull
    @ManyToOne
    private SystemUser author;
}
