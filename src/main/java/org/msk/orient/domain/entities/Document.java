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
@Table(name = "documents")
@Data
public class Document {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NonNull
    @ManyToOne
    private Attachment attachment;

    @NonNull
    @ManyToOne
    private Competition competition;
}
