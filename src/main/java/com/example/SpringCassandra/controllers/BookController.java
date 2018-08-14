package com.example.SpringCassandra.controllers;

import com.example.SpringCassandra.entities.Book;
import com.example.SpringCassandra.services.BookServiceImpl;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

/**
 * Controller class for CRUD operations.
 */
@RestController
public class BookController {
    private final BookServiceImpl bookService;

    public BookController(BookServiceImpl bookService) {
        this.bookService = bookService;
    }

    @RequestMapping(value = "/book/addBook/{value}", method = RequestMethod.POST)
    public void addBook(
            @PathVariable("value") String value) {
        Book book = new Book();
        book.setValue(value);
        bookService.saveOrUpdate(book);
    }

    @RequestMapping(value = "/book/getBook/{id}", method = RequestMethod.GET)
    public String getBook(
            @PathVariable("id") UUID id) {
        return bookService.getById(id).toString();
    }

    @RequestMapping(value = "/book/deleteBook/{id}", method = RequestMethod.DELETE)
    public void deleteBook(
            @PathVariable("id") UUID id) {
        bookService.delete(id);
    }

    @RequestMapping(value = "/book/updateBook/{id}/{value}", method = RequestMethod.PUT)
    public void updateBook(
            @PathVariable("id") UUID id,
            @PathVariable("value") String value) {
        Book book = new Book();
        book.setValue(value);
        book.setId(id);
        bookService.saveOrUpdate(book);
    }
}
