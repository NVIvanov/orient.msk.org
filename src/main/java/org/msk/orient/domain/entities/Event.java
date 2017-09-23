package org.msk.orient.domain.entities;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static java.lang.String.format;

/**
 * @author nivanov
 *         on 31.08.17.
 */

@Entity
@Table(name = "events")
@Data
@NoArgsConstructor
public class Event {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(columnDefinition = "TIMESTAMP")
    private LocalDateTime time;

    @Getter(AccessLevel.NONE)
    private String arguments;

    @NonNull
    @ManyToOne
    private EventType type;

    @NonNull
    @ManyToOne
    private Competition competition;

    public String getMessage() {
        return format(type.getEventPatternText(), arguments);
    }
}
