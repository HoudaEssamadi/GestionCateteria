package com.cafeJazira.metier;

import java.util.List;

public interface IMetier<T> {

	List<T> getAll();

	boolean create(T obj);

	boolean update(T obj);

	boolean delete(T obj);
}
