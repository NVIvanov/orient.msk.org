package org.msk.orient.domain.entities;

import lombok.AccessLevel;
import lombok.Data;
import lombok.Getter;
import lombok.NonNull;

import javax.persistence.*;
import java.time.LocalDateTime;

/**
 * @author nivanov
 *         on 31.08.17.
 */

@Entity
@Data
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String text;

    @NonNull
    @Getter(AccessLevel.NONE)
    private LocalDateTime creationTime = LocalDateTime.now();

    @NonNull
    @ManyToOne
    private SystemUser author;
}
