package com.book.service.user;

import com.book.model.User;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Optional;

public interface UserService {
    void save(User user);
    void update(User user);
    void delete(User user);
    User findUserById(int userId);

    Optional<User> findUserByUserNameAndPassword(String userName, String password);

    User findUserByUserName(String userName);
}
