package com.example.database.dao.impl;

import com.example.database.domain.Book;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.jdbc.core.JdbcTemplate;

import static com.example.database.TestDataUtil.CreateTestBook;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
public class BookDaoImplTests {
    @Mock
    private JdbcTemplate jdbcTemplate;
    @InjectMocks
    private BookDaoImpl underTest;

    @Test
    public void testThatCreateBookGeneratesCorrectSql(){
        Book book = CreateTestBook();
        underTest.creates(book);
        verify(jdbcTemplate).update(eq("INSERT INTO books(isbn, title, author_id) VALUES(?, ?, ?)"),
                eq("1234-5678-9111-1"), eq("The shadow in the attic"), eq(1L)
        );
    }

    @Test
    public void testThatFindOneGeneratesCorrectSql(){
        underTest.findOne("1234-5678-9111-1");
        verify(jdbcTemplate).query(
                eq("SELECT isbn, title, author_id FROM books WHERE isbn=? limit 1"),
                ArgumentMatchers.<BookDaoImpl.BookRowMapper>any(),
                eq("1234-5678-9111-1"));
    }
}
