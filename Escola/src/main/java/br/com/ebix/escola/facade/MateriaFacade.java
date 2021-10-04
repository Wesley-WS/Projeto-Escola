package br.com.ebix.escola.facade;

import java.util.List;
import java.util.Optional;

import br.com.ebix.escola.model.Materia;

public interface MateriaFacade {
	List<Materia> getAll();
	Optional<Materia> get(int id);
	boolean add(Materia materia);
	boolean update(Materia materia);
	boolean delete(Materia materia);
}
