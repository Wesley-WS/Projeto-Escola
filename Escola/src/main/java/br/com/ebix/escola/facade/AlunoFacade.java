package br.com.ebix.escola.facade;

import java.util.List;
import java.util.Optional;

import br.com.ebix.escola.model.Aluno;

public interface AlunoFacade {
	List<Aluno> getAll();
	Optional<Aluno> get(int id);
	boolean add(Aluno aluno);
	boolean update(Aluno aluno);
	boolean delete(Aluno aluno);
}
