package com.book.dao.impl;

import com.book.dao.BookDao;
import com.book.model.Book;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional(rollbackFor = Exception.class)
public class BookDaoImpl implements BookDao {
    @Autowired
    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public List<Book> getAll() {
        Session session = this.sessionFactory.openSession();
        Query query = session.createQuery("from Book");
        return query.list();
    }

    @Override
    public void save(Book book) {

    }
}
