package org.msk.orient.services;

import org.msk.orient.domain.entities.SystemUser;

import javax.validation.constraints.NotNull;
import java.util.Optional;

/**
 * @author nivanov
 * on 21.09.17.
 */
public interface UserService {

    /**
     * Creates user in system.
     * @param user - user entity
     * @return {@code true} if user was created
     */
    boolean createUser(@NotNull SystemUser user);

    /**
     * Updates user data
     * @param user - user entity
     * @return updated user
     * @throws IllegalArgumentException if user does not contain email or id to identify
     */
    @NotNull SystemUser updateUser(@NotNull SystemUser user);

    /**
     * Finds user by specified email
     * @param email - user email
     * @return {@link Optional} of search result
     */
    Optional<SystemUser> getUserByEmail(@NotNull String email);

    /**
     * Removes user from system
     * @param email - user email
     * @return {@code true} if user was found and deleted
     */
    boolean removeUser(@NotNull String email);
}
