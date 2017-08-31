package org.msk.orient.domain.entities;

import lombok.Data;
import lombok.NonNull;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Size;

/**
 * @author nivanov
 *         on 31.08.17.
 */

@Entity
@Data
public class EventType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NonNull
    @Size(min = 1, max = 2000)
    private String description;

    @NonNull
    @Size(min = 1, max = 2000)
    private String eventPatternText;
}
