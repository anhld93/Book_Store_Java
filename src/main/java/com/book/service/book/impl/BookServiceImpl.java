package com.book.service.book.impl;

import com.book.dao.BookDao;
import com.book.model.Book;
import com.book.service.book.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImpl implements BookService {
    @Autowired
    BookDao bookDao;

    @Override
    public List<Book> getAll() {
        return bookDao.getAll();
    }
}
