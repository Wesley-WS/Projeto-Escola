package br.com.ebix.escola.dao;

import java.util.List;
import java.util.Optional;

import br.com.ebix.escola.model.Materia;
import br.com.ebix.escola.model.Professor;

public interface ProfessorMateriaDao {
	List<Materia> getAllMateriasFromProfessor(Professor professor);
	Optional<Materia> getMateriaByCodProfessor(Professor professor);
}
