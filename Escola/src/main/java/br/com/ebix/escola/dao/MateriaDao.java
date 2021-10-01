package br.com.ebix.escola.dao;

import java.sql.ResultSet;
import java.util.Optional;

import br.com.ebix.escola.model.Materia;

public interface MateriaDao {
	ResultSet getAll();
	Optional<Materia> get(int id);
	void add(Materia materia);
	void update(Materia materia);
	void delete(Materia materia);
}
