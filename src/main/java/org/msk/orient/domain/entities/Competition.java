package org.msk.orient.domain.entities;

import lombok.AccessLevel;
import lombok.Data;
import lombok.Getter;
import lombok.NonNull;

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
@Data
public class Competition {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NonNull
    @Size(min = 1, max = 300)
    private String title;

    @Size(max = 2000)
    private String description;
    private String site;
    private String registrationLink;

    @NonNull
    private LocalDate startDate;

    @NonNull
    private LocalDate finishDate;

    @NonNull
    @Size(min = 1, max = 2000)
    private String location;

    private LocalDate startRegistrationDate;
    private LocalDate finishRegistrationDate;

    @NonNull
    @Getter(AccessLevel.NONE)
    private LocalDateTime creationTime = LocalDateTime.now();

    @NonNull
    @OneToMany
    private List<Event> events;

    @NonNull
    @OneToOne
    private Attachment logo;

    @NonNull
    @ManyToOne
    private CompetitionStatus status;

    @NonNull
    @ManyToOne
    private List<Comment> comments;

    @NonNull
    @OneToMany
    private List<Document> documents;

    @NonNull
    @OneToMany
    private List<PhotoAlbum> photoAlbums;

    @NonNull
    @OneToMany
    private List<CompetitionDay> competitionDays;
}
