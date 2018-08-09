package com.example.SpringCassandra.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.cassandra.config.AbstractCassandraConfiguration;
import org.springframework.data.cassandra.config.SchemaAction;
import org.springframework.data.cassandra.core.cql.keyspace.DropKeyspaceSpecification;

import java.util.Arrays;
import java.util.List;

/**
 * Class config for Cassandra.
 */
@Configuration
public class CassandraConfig extends AbstractCassandraConfiguration {
    public static final String KEYSPACE = "books_keyspace";

    @Override
    public SchemaAction getSchemaAction() {
        return SchemaAction.CREATE_IF_NOT_EXISTS;
    }

    @Override
    protected List<DropKeyspaceSpecification> getKeyspaceDrops() {
        return Arrays.asList(DropKeyspaceSpecification.dropKeyspace(KEYSPACE));
    }

    @Override
    protected String getKeyspaceName() {
        return KEYSPACE;
    }

    @Override
    public String[] getEntityBasePackages() {
        return new String[]{"com.example.SpringCassandra.entities"};
    }
}
