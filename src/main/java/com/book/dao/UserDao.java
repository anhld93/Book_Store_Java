package com.book.dao;

import com.book.model.User;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Optional;

public interface UserDao extends GenericDao<User>{

    void update(User user);

    void delete(User user);

    User findUserById(int userId);

    Optional<User> findUserByUserNameAndPassword(String userName, String password);

    User findByUserName(String userName);
}
