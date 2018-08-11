package com.example.SpringCassandra.controllers;

import com.example.SpringCassandra.entities.Book;
import com.example.SpringCassandra.services.BookServiceImpl;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.UUID;

import static org.mockito.Matchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class BookControllerTest {
    @Mock
    private BookServiceImpl bookService;
    @InjectMocks
    private BookController bookController;
    private Book book = new Book();

    @Before
    public void setUp() throws Exception {
        book.setId(UUID.randomUUID());
        book.setTitle("value");
    }

    @Test
    public void addBook() {
        bookController.addBook(book.getTitle());
        verify(bookService, times(1)).saveOrUpdate(any(Book.class));
    }

    @Test
    public void getBook() {
        Mockito.when(bookService.getById(book.getId())).thenReturn(book);
        Assert.assertEquals(bookController.getBook(book.getId()), book.toString());
    }

    @Test
    public void deleteBook() {
        bookController.deleteBook(book.getId());
        verify(bookService, times(1)).delete(any(UUID.class));
    }

    @Test
    public void updateBook() {
        bookController.updateBook(book.getId(), book.getTitle());
        verify(bookService, times(1)).saveOrUpdate(any(Book.class));
    }
}