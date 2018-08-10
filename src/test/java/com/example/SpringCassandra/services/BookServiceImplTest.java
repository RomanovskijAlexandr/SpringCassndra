package com.example.SpringCassandra.services;

import com.example.SpringCassandra.entities.Book;
import com.example.SpringCassandra.repositories.BookRepository;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import static org.mockito.Mockito.*;


@RunWith(MockitoJUnitRunner.class)
public class BookServiceImplTest {
    @Mock
    public BookRepository bookRepository;
    @InjectMocks
    public BookServiceImpl bookService;
    private Book book = new Book();
    private List<Book> books = new ArrayList<>();

    @Before
    public void setUp() throws Exception {
        book.setId(UUID.randomUUID());
        book.setTitle("value");
        books.add(book);
    }

    @Test
    public void getAll() {
        Mockito.when(bookRepository.findAll()).thenReturn(books);
        Assert.assertEquals(bookService.getAll(), books);
    }

    @Test
    public void getById() {
        Mockito.when(bookRepository.findById(book.getId())).thenReturn(Optional.ofNullable(book));
        Book bookGetById = bookService.getById(book.getId());
        Assert.assertEquals(bookGetById, book);
        Assert.assertEquals(bookGetById.getId(), book.getId());
    }

    @Test
    public void saveOrUpdate() {
        Mockito.when(bookRepository.save(book)).thenReturn(book);
        Assert.assertEquals(bookService.saveOrUpdate(book), book);
    }

    @Test
    public void delete() {
        bookService.delete(book.getId());
        verify(bookRepository, times(1)).deleteById(any(UUID.class));
    }
}