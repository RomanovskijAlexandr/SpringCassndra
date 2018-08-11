package com.example.SpringCassandra.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.cassandra.config.AbstractCassandraConfiguration;
import org.springframework.data.cassandra.config.SchemaAction;
import org.springframework.data.cassandra.core.cql.keyspace.CreateKeyspaceSpecification;

import java.util.Collections;
import java.util.List;

import static org.springframework.data.cassandra.config.SchemaAction.CREATE_IF_NOT_EXISTS;

/**
 * Class config for Cassandra.
 */
@Configuration
public class CassandraConfig extends AbstractCassandraConfiguration {
    private static final String KEYSPACE = "books_keyspace";

    @Override
    public SchemaAction getSchemaAction() {
        return CREATE_IF_NOT_EXISTS;
    }

    @Override
    protected List<CreateKeyspaceSpecification> getKeyspaceCreations() {
        return Collections.singletonList(CreateKeyspaceSpecification
                .createKeyspace(KEYSPACE)
                .ifNotExists()
                .withSimpleReplication());
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
