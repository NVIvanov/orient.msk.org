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
public class Attachment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NonNull
    @ManyToOne
    private AttachmentType type;

    @NonNull
    private String title;
    private String description;

    @NonNull
    private String fileURL;

    @NonNull
    @Getter(AccessLevel.NONE)
    private LocalDateTime creationTime = LocalDateTime.now();
}
