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
public class ModerationTrigger {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NonNull
    @OneToOne
    private SystemUser user;

    @NonNull
    @Getter(AccessLevel.NONE)
    private LocalDateTime creationTime = LocalDateTime.now();
}
