package com.cafeJazira.dao;

import java.util.List;

public interface IDao<T> {

	List<T> getAll();

	boolean create(T obj);

	boolean update(T obj);

	boolean delete(T obj);
}
