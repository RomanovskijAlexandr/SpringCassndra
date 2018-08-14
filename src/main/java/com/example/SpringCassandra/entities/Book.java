package com.example.SpringCassandra.entities;

import com.datastax.driver.core.DataType;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.cassandra.core.mapping.CassandraType;
import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

import javax.persistence.Id;
import java.util.UUID;

/**
 * Entity class Book for Cassandra DB.
 */
@Table
@Setter
@Getter
@ToString
public class Book {
    @Id
    @PrimaryKey
    @CassandraType(type = DataType.Name.UUID)
    private UUID id;
    @Column
    private String value;

    public Book() {
        this.id = UUID.randomUUID();
    }
}