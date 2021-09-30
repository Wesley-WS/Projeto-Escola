package br.com.ebix.escola.model;

import java.sql.ResultSet;
import java.util.List;
import java.util.Optional;

public interface InterfaceBasica<T> {
	Optional<T> get(int id);
	void add(T t);
	void update(T t);
	void delete(T t);
}
