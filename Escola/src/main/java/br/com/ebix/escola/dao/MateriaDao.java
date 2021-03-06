package br.com.ebix.escola.dao;

import java.util.List;
import java.util.Optional;

import br.com.ebix.escola.model.Materia;

public interface MateriaDao {
	List<Materia> getAll();
	List<Materia> getAllAvaiable();
	Optional<Materia> get(Materia materia);
	void add(Materia materia);
	void update(Materia materia);
	void delete(Materia materia);	
}
