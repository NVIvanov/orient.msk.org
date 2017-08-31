package org.msk.orient.domain.entities;

import lombok.Data;
import lombok.NonNull;

import javax.persistence.*;
import java.util.List;

/**
 * @author nivanov
 *         on 31.08.17.
 */

@Entity
@Data
public class Document {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NonNull
    @OneToMany
    private List<Attachment> attachments;
}
