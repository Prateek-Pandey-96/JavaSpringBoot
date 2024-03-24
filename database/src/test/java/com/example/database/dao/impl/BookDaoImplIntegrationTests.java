package com.example.database.dao.impl;

import com.example.database.TestDataUtil;
import com.example.database.domain.Author;
import com.example.database.domain.Book;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@ExtendWith(SpringExtension.class)
public class BookDaoImplIntegrationTests {

    private AuthorDaoImpl authorDao;
    private BookDaoImpl underTest;

    @Autowired
    public BookDaoImplIntegrationTests(AuthorDaoImpl authorDao, BookDaoImpl underTest) {
        this.authorDao = authorDao;
        this.underTest = underTest;
    }

    @Test
    public void testThatBookCanBeCreatedAndRevoked(){
        Author author = TestDataUtil.CreateTestAuthor();
        authorDao.creates(author);

        Book book = TestDataUtil.CreateTestBook();
        book.setAuthorId(author.getId());
        underTest.creates(book);

        Optional<Book> result = underTest.findOne(book.getIsbn());
        assertThat(result.isPresent());
        assertThat(result.get()).isEqualTo(book);
    }
}
