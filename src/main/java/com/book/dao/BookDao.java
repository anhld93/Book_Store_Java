package com.book.dao;

import com.book.model.Book;

import java.util.List;

public interface BookDao  extends GenericDao<Book> {

    List<Book> getAll();
}
