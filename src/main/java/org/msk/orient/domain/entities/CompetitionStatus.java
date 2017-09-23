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
@Table(name = "competition_statuses")
@Data
@NoArgsConstructor
public class CompetitionStatus {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NonNull
    @Size(min = 1, max = 200)
    private String title;
}
