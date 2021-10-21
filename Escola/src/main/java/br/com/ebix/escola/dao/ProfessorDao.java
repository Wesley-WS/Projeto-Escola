package br.com.ebix.escola.dao;

import java.util.List;
import java.util.Optional;

import br.com.ebix.escola.model.Materia;
import br.com.ebix.escola.model.Professor;

public interface ProfessorDao {
	List<Professor> getAll();
	Optional<Professor> get(Professor professor);
	List<Materia> getAllMaterias(Professor professor);
	void add(Professor professor);
	void update(Professor professor);
	void delete(Professor professor);
	boolean cpfCadastrado(Professor professor);
}
