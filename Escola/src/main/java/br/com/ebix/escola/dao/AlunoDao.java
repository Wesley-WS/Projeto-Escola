package br.com.ebix.escola.dao;

import java.sql.ResultSet;
import java.util.Optional;

import br.com.ebix.escola.model.Aluno;

public interface AlunoDao {
	ResultSet getAll();
	Optional<Aluno> get(int id);
	void add(Aluno aluno);
	void update(Aluno aluno);
	void delete(Aluno aluno);
}
