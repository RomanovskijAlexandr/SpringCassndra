package com.example.SpringCassandra.services;

import com.example.SpringCassandra.entities.Book;
import com.example.SpringCassandra.repositories.BookRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;


/**
 * Service which implements CRUD operations.
 */
@Service
public class BookServiceImpl implements BookService {
    private BookRepository bookRepository;

    //todo ломбук
    public BookServiceImpl(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public List<Book> getAll() {
        List<Book> books = new ArrayList<>();
        bookRepository.findAll().forEach(books::add);
        return books;
    }

    @Override
    public Book getById(UUID id) {
        //todo: почитать про оптионал
        return bookRepository.findById(id).orElse(null);
    }

    @Override
    public Book saveOrUpdate(Book book) {
        return bookRepository.save(book);
    }

    @Override
    public void delete(UUID id) {
        bookRepository.deleteById(id);
    }
}
