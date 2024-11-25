package com.example.biblioteca.controller;

import java.sql.SQLException;
import java.util.List;

public interface ICRUDDao<T>{

    public void insert(T t) throws SQLException;
    public void update(T t) throws SQLException;
    public void delete(T t) throws SQLException;
    public T findOne(T t) throws SQLException;
    public List<T> findAll() throws SQLException;

}
