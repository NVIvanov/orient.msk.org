package org.msk.orient.domain.entities;

import lombok.Data;
import lombok.NonNull;
import org.springframework.data.geo.Point;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.time.LocalDate;

/**
 * @author nivanov
 *         on 31.08.17.
 */

@Entity
@Data
public class CompetitionDay {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NonNull
    @ManyToOne
    private Competition competition;

    @Size(max = 2000)
    private String description;

    @NonNull
    private LocalDate date;
    private Point location;
    private String howToWay;
}
