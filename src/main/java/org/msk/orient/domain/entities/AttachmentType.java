package org.msk.orient.domain.entities;

import lombok.Data;
import lombok.NonNull;

import javax.persistence.*;
import javax.validation.constraints.Size;

/**
 * @author nivanov
 *         on 31.08.17.
 */

@Entity
@Table(name = "attachment_types")
@Data
public class AttachmentType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NonNull
    @Size(min = 1, max = 300)
    private String title;

    @NonNull
    @Size(min = 1, max = 300)
    private String uploadFileMask;
}
