package com.book.dao.impl;

import com.book.dao.GenericDao;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

@Repository
@Transactional(rollbackFor = Exception.class)
public class GenericDaoImpl<T> implements GenericDao<T> {

    @Autowired
    private SessionFactory sessionFactory;

    protected Class<? extends T> daoType;

    /**
     * By defining this class as abstract, we prevent Spring from creating
     * instance of this class If not defined as abstract,
     * getClass().getGenericSuperClass() would return Object. There would be
     * exception because Object class does not hava constructor with parameters.
     */
//    public GenericDaoImpl() {
//        Type t = getClass().getGenericSuperclass();
//        ParameterizedType pt = (ParameterizedType) t;
//        daoType = (Class) pt.getActualTypeArguments()[0];
//    }

    protected Session currentSession() {
        return sessionFactory.getCurrentSession();
    }

    @Override
    public void save(T entity) {
        currentSession().save(entity);
    }
}
