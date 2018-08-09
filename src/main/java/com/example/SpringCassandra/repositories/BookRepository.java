package com.example.SpringCassandra.repositories;

import com.example.SpringCassandra.entities.Book;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

/**
 * Repository for CRUD operations.
 */
@Repository
public interface BookRepository extends CrudRepository<Book, UUID> {

}
