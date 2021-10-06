package br.com.ebix.escola.dao;

import java.util.List;
import java.util.Optional;

import br.com.ebix.escola.model.Aluno;

public interface AlunoDao {
	List<Aluno> getAll();
	Optional<Aluno> get(Aluno aluno);
	void add(Aluno aluno);
	void update(Aluno aluno);
	void delete(Aluno aluno);
}
