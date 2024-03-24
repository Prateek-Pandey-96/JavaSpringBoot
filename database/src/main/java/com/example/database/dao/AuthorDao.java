package com.example.database.dao;

import com.example.database.domain.Author;

import java.util.Optional;

public interface AuthorDao {
    void creates(Author author);
    Optional<Author> findOne(long l);
}
