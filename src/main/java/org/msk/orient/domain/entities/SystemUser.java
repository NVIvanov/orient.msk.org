package org.msk.orient.domain.entities;

import lombok.AccessLevel;
import lombok.Data;
import lombok.Getter;
import lombok.NonNull;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;

/**
 * @author nivanov
 *         on 31.08.17.
 */
@Entity
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
    private LocalDateTime lastLogin;

    @NonNull
    @Getter(AccessLevel.NONE)
    private LocalDateTime memberSince = LocalDateTime.now();
    private Boolean autoModerated;

    @OneToOne
    private Attachment avatar;
}
