package com.example.database.dao;

import com.example.database.domain.Book;

import java.util.Optional;

public interface BookDao {
    void creates(Book book);
    Optional<Book> findOne(String isbn);
}
