package org.msk.orient.services.impl;

import org.msk.orient.domain.entities.SystemUser;
import org.msk.orient.domain.repositories.UserRepository;
import org.msk.orient.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * @author nivanov
 * on 21.09.17.
 */

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public boolean createUser(SystemUser user) {
        if (userRepository.findByEmail(user.getEmail()).isPresent()) {
            return false;
        }
        userRepository.save(user);
        return true;
    }

    @Override
    public SystemUser updateUser(SystemUser user) {
        Optional<SystemUser> existingUserOpt = userRepository.findByEmail(user.getEmail());
        SystemUser existingUser = existingUserOpt.orElseThrow(IllegalArgumentException::new);
        if (user.getAutoModerated() != null) {
            existingUser.setAutoModerated(user.getAutoModerated());
        }
        if (user.getEnabled() != null) {
            existingUser.setEnabled(user.getEnabled());
        }
        if (user.getImage() != null) {
            existingUser.setImage(user.getImage());
        }
        if (user.getName() != null) {
            existingUser.setName(user.getName());
        }
        if (user.getPassword() != null) {
            existingUser.setPassword(user.getPassword());
        }
        if (user.getPhone() != null) {
            existingUser.setPhone(user.getPhone());
        }
        userRepository.save(existingUser);
        return existingUser;
    }

    @Override
    public Optional<SystemUser> getUserByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    @Override
    public boolean removeUser(String email) {
        Optional<SystemUser> userOpt = userRepository.findByEmail(email);
        if (userOpt.isPresent()) {
            userRepository.delete(userOpt.get());
            return true;
        }
        return false;
    }
}
