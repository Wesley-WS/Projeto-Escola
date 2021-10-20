package br.com.ebix.escola.facade;

import java.util.List;
import java.util.Optional;

import br.com.ebix.escola.enums.AcoesValidacao;
import br.com.ebix.escola.model.Professor;

public interface ProfessorFacade {
	List<Professor> getAll();
	Professor get(Professor professor);
	List<AcoesValidacao> add(Professor professor);
	List<AcoesValidacao> update(Professor professor);
	AcoesValidacao delete(Professor professor);
}
