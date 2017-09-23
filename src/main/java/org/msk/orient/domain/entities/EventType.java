package org.msk.orient.domain.entities;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import javax.persistence.*;
import javax.validation.constraints.Size;

/**
 * @author nivanov
 *         on 31.08.17.
 */

@Entity
@Table(name = "event_types")
@Data
@NoArgsConstructor
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
