package com.example.SpringCassandra.services;

import com.example.SpringCassandra.entities.Book;

import java.util.List;
import java.util.UUID;

/**
 * Service with CRUD operations.
 */
public interface BookService {
    List<Book> getAll();

    Book getById(UUID id);

    Book saveOrUpdate(Book product);

    void delete(UUID id);
}
