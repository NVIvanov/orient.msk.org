package org.msk.orient.domain.entities;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;

/**
 * @author nivanov
 *         on 31.08.17.
 */

@Entity
@Table(name = "attachments")
@Data
public class Attachment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NonNull
    @ManyToOne
    private AttachmentType type;

    @NonNull
    @Size(min = 1, max = 300)
    private String title;

    @Size(max = 3000)
    private String description;

    @NonNull
    @Size(min = 1, max = 300)
    @Column(name = "file_url")
    private String fileURL;

    @NonNull
    @Setter(AccessLevel.NONE)
    @Column(columnDefinition = "TIMESTAMP")
    private LocalDateTime creationTime = LocalDateTime.now();
}
