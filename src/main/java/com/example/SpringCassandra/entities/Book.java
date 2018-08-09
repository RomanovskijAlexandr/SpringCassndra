package com.example.SpringCassandra.entities;

import com.datastax.driver.core.DataType;
import org.springframework.data.cassandra.core.mapping.CassandraType;
import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;
import org.springframework.stereotype.Component;

import java.util.UUID;

/**
 * Entity class Book for Cassandra DB.
 */
@Table
@Component
public class Book {
    @PrimaryKey
    @CassandraType(type = DataType.Name.UUID)
    private UUID id;
    @Column
    private String value;

    public Book() {
        this.id = UUID.randomUUID();
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getTitle() {
        return value;
    }

    public void setTitle(String title) {
        this.value = title;
    }

    @Override
    public String toString() {
        return "id: " + id + " value: " + value;
    }
}