package org.msk.orient.domain.entities;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

/**
 * @author nivanov
 *         on 31.08.17.
 */

@Entity
@Table(name = "competitions")
@Data
public class Competition {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NonNull
    @Size(min = 1, max = 500)
    private String title;

    @Size(max = 10000)
    private String description;
    private String site;
    private String registrationLink;

    @NonNull
    @Column(columnDefinition = "DATE")

    private LocalDate startDate;

    @NonNull
    @Column(columnDefinition = "DATE")
    private LocalDate finishDate;

    @NonNull
    @Size(min = 1, max = 2000)
    private String location;

    @Column(columnDefinition = "DATE")
    private LocalDate startRegistrationDate;

    @Column(columnDefinition = "DATE")
    private LocalDate endRegistrationDate;

    @NonNull
    @Setter(AccessLevel.NONE)
    @Column(columnDefinition = "TIMESTAMP")
    private LocalDateTime creationTime = LocalDateTime.now();

    @NonNull
    @OneToOne
    private Attachment logo;

    @NonNull
    @ManyToOne
    private CompetitionStatus status;
}
