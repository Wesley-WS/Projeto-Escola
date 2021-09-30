package br.com.ebix.escola.model;

import java.util.List;
import java.util.Optional;

public interface Crud<T> {
	Optional<T> get (int id);
	List<T> getAll();
	void add(T t);
	void update(T t);
	void delete(T t);
}
