package com.book.service.user.impl;

import com.book.dao.UserDao;
import com.book.model.User;
import com.book.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserDao userDao;

    @Override
    public void save(User user) {
        userDao.save(user);
    }

    @Override
    public void update(User user) {

    }

    @Override
    public void delete(User user) {

    }

    @Override
    public User findUserById(int userId) {
        return null;
    }

    @Override
    public Optional<User> findUserByUserNameAndPassword(String userName, String password) {
        return userDao.findUserByUserNameAndPassword(userName, password);
    }

    @Override
    public User findUserByUserName(String userName){
        return userDao.findByUserName(userName);
    }
}
