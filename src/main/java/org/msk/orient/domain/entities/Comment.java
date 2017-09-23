package org.msk.orient.domain.entities;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

/**
 * @author nivanov
 *         on 31.08.17.
 */

@Entity
@Table(name = "comments")
@Data
@NoArgsConstructor
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String text;

    @NonNull
    @Setter(AccessLevel.NONE)
    @Column(columnDefinition = "TIMESTAMP")
    private LocalDateTime creationTime = LocalDateTime.now();

    @NonNull
    @ManyToOne
    private SystemUser author;

    @NonNull
    @ManyToOne
    private Event event;
}
