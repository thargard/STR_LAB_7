package com.example.borism.repository;

import com.example.borism.connection.ConnectionPool;

import java.sql.Connection;

public class RepositoryCreator implements AutoCloseable{
    private ConnectionPool connectionPool;
    private Connection connection;

    public RepositoryCreator() {
        this.connectionPool = ConnectionPool.getInstance();
        this.connection = connectionPool.getConnection();
    }

    public UserRepository getUserRepository() {
        return new UserRepository(connection);
    }

    public PersonRepository getPersonRepository() {
        return new PersonRepository(connection);
    }

    @Override
    public void close() {
        connectionPool.releaseConnection(connection);
    }
}
