package org.msk.orient.services.impl;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;
import org.msk.orient.domain.entities.SystemUser;
import org.msk.orient.domain.repositories.AttachmentRepository;
import org.msk.orient.domain.repositories.AttachmentTypeRepository;
import org.msk.orient.domain.repositories.UserRepository;
import org.msk.orient.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.JdbcTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author nivanov
 * on 22.09.17.
 */

@RunWith(JUnitPlatform.class)
@SpringBootTest
@Transactional
@ExtendWith(SpringExtension.class)
public class UserServiceImplTest {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserService userService;

    @Autowired
    private AttachmentRepository attachmentRepository;

    @Test
    @Rollback
    public void createUser() {
        SystemUser user = new SystemUser();
        user.setImage(attachmentRepository.findById(1L).orElseThrow(IllegalStateException::new));
        user.setEmail("new_user@email.ru");
        user.setPassword("password");
        user.setName("Иванов Иван Иваныч");
        user.setPhone("1234");
        user.setEnabled(false);
        user.setLastLogin(LocalDateTime.now());
        userService.createUser(user);
        Optional<SystemUser> userOpt = userRepository.findByEmail("new_user@email.ru");
        assertTrue(userOpt.isPresent());
    }

    @Test
    @Rollback
    public void updateUser() {
        SystemUser user = new SystemUser();
        user.setImage(attachmentRepository.findById(1L).orElseThrow(IllegalStateException::new));
        user.setEmail("user@email.ru");
        user.setPassword("password3");
        userService.updateUser(user);
        Optional<SystemUser> userOpt = userRepository.findByEmail("user@email.ru");
        assertTrue(userOpt.isPresent());
        assertEquals("password3", userOpt.get().getPassword());
    }

    @Test
    @Rollback
    public void getUserByEmail() {
        Optional<SystemUser> userOpt = userRepository.findByEmail("user@email.ru");
        assertTrue(userOpt.isPresent());
    }

    @Test
    @Rollback
    public void removeUser() {
        assertTrue(userService.removeUser("user@email.ru"));
        Optional<SystemUser> userOpt = userRepository.findByEmail("user@email.ru");
        assertFalse(userOpt.isPresent());
    }

}