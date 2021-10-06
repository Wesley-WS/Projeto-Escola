package br.com.ebix.escola.facade;

import java.util.List;
import java.util.Optional;

import br.com.ebix.escola.model.Aluno;

public interface AlunoFacade {
	List<Aluno> getAll();
	Aluno get(Aluno aluno);
	boolean add(Aluno aluno);
	boolean update(Aluno aluno);
	boolean delete(Aluno aluno);
}
