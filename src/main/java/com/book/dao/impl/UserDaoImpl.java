package com.book.dao.impl;

import com.book.dao.UserDao;
import com.book.model.User;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Repository
@Transactional(rollbackFor = Exception.class)
public class UserDaoImpl extends GenericDaoImpl<User> implements UserDao {

    @Autowired
    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void update(User user) {

    }

    @Override
    public void delete(User user) {

    }

    @Override
    public User findUserById(int userId) {
        Session session = this.sessionFactory.openSession();
        Query query = session.createQuery("from User where userId = :userId");
        query.setParameter("userId", userId);
        return (User)query.uniqueResult();
    }

    @Override
    public Optional<User> findUserByUserNameAndPassword(String userName, String password) {
        Session session = this.sessionFactory.openSession();

        Query query = session.createQuery(" FROM User WHERE userName = :userName AND password = :password");
        query.setParameter("userName", userName);
        query.setParameter("password", password);

        return Optional.ofNullable((User) query.list().get(0));
    }

    @Override
    public User findByUserName(String userName) {
        Session session = this.sessionFactory.openSession();

        Query query = session.createQuery(" FROM User WHERE userName = :userName ");
        query.setParameter("userName", userName);

        if(query.list().size() == 0) return null;

        return  (User)query.list().get(0);
    }
}
