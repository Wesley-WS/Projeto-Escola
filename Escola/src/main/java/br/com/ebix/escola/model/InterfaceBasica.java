package br.com.ebix.escola.model;

import java.sql.ResultSet;
import java.util.List;
import java.util.Optional;

public interface InterfaceBasica<T> {
	Optional<T> get(int id);
	boolean add(T t);
	boolean update(T t);
	boolean delete(T t);
}
