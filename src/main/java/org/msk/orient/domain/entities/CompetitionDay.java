package org.msk.orient.domain.entities;

import lombok.Data;
import lombok.NoArgsConstructor;
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
@Table(name = "competition_days")
@Data
@NoArgsConstructor
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
    @Column(columnDefinition = "DATE")
    private LocalDate date;

    @NonNull
    @Column(columnDefinition = "POINT")
    private Point location;
    private String howToWay;
    private String howToWayScheme;
}
