package br.com.ebix.escola.dao;

import java.sql.ResultSet;
import java.util.Optional;

import br.com.ebix.escola.model.Aluno;
import br.com.ebix.escola.model.Professor;

public interface ProfessorDao {
	ResultSet getAll();
	Optional<Professor> get(int id);
	void add(Professor p);
	void update(Professor p);
	void delete(Professor p);
}
