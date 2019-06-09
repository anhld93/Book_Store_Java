package com.book.dao;

public interface GenericDao<T> {
    void save(T t);
}
