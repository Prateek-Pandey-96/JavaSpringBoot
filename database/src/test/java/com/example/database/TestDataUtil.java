package com.example.database;

import com.example.database.domain.Author;
import com.example.database.domain.Book;

public final class TestDataUtil {
    private TestDataUtil(){}

    public static Author CreateTestAuthor() {
        return Author.builder()
                .id(1L)
                .age(25)
                .name("Abigail Rose")
                .build();
    }

    public static Book CreateTestBook() {
        return Book.builder()
                .isbn("1234-5678-9111-1")
                .title("The shadow in the attic")
                .authorId(1L)
                .build();
    }
}
