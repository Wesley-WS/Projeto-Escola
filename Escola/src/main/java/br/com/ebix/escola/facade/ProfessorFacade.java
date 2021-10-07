package br.com.ebix.escola.facade;

import java.util.List;
import java.util.Optional;

import br.com.ebix.escola.model.Professor;

public interface ProfessorFacade {
	List<Professor> getAll();
	Professor get(Professor professor);
	boolean add(Professor professor);
	boolean update(Professor professor);
	boolean delete(Professor professor);
}
