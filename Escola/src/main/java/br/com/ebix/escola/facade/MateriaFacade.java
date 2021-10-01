package br.com.ebix.escola.facade;

import java.util.List;
import java.util.Optional;

import br.com.ebix.escola.model.Materia;

public interface MateriaFacade {
	List<Materia> getAll();
	Optional<Materia> get(int id);
	void add(Materia materia);
	void update(Materia materia);
	void delete(Materia materia);
}
