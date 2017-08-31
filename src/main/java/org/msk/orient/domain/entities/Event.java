package org.msk.orient.domain.entities;

import lombok.AccessLevel;
import lombok.Data;
import lombok.Getter;
import lombok.NonNull;

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
@Data
public class Event {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDateTime time;

    @Getter(AccessLevel.NONE)
    private List<String> arguments;

    @NonNull
    @ManyToOne
    private EventType type;

    @NonNull
    private List<Comment> comments = new ArrayList<>();

    public String getMessage() {
        return format(type.getEventPatternText(), arguments);
    }
}
