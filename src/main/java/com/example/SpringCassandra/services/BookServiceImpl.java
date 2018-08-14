package com.example.SpringCassandra.services;

import com.example.SpringCassandra.entities.Book;
import com.example.SpringCassandra.repositories.BookRepository;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;


/**
 * Service which implements CRUD operations.
 */
@Service
public class BookServiceImpl implements BookService {
    private static Logger logger = Logger.getLogger(BookServiceImpl.class);

    private BookRepository bookRepository;

    //todo ломбук
    public BookServiceImpl(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public List<Book> getAll() {
        List<Book> books = new ArrayList<>();
        bookRepository.findAll().forEach(books::add);
        logger.info("do getAll() in BookServiceImpl");
        logger.error("do error getAll() in BookServiceImpl");
        return books;
    }

    @Override
    public Book getById(UUID id) {
        //todo: почитать про оптионал
        logger.info("do getById(UUID id) in BookServiceImpl");
        logger.error("do error getById() in BookServiceImpl");
        return bookRepository.findById(id).orElse(null);
    }

    @Override
    public Book saveOrUpdate(Book book) {
        logger.info("do saveOrUpdate(Book book) in BookServiceImpl");
        logger.error("do error saveOrUpdate() in BookServiceImpl");
        return bookRepository.save(book);
    }

    @Override
    public void delete(UUID id) {
        logger.info("do delete(UUID id) in BookServiceImpl");
        logger.error("do error delete() in BookServiceImpl");
        bookRepository.deleteById(id);
    }
}
