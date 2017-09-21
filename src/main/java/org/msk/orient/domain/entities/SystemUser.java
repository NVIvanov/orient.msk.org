package org.msk.orient.domain.entities;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;

/**
 * @author nivanov
 *         on 31.08.17.
 */
@Entity
@Table(name = "users")
@Data
public class SystemUser {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NonNull
    @Size(min = 1, max = 300)
    private String email;

    @NonNull
    private String password;

    private String name;
    private String phone;
    private Boolean enabled;

    @Column(columnDefinition = "TIMESTAMP")
    private LocalDateTime lastLogin;

    @NonNull
    @Setter(AccessLevel.NONE)
    @Column(columnDefinition = "TIMESTAMP")
    private LocalDateTime memberSince = LocalDateTime.now();

    private Boolean autoModerated;

    @NonNull
    @OneToOne
    private Attachment image;
}
