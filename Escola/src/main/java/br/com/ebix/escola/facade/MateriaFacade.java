package br.com.ebix.escola.facade;

import java.util.List;
import java.util.Optional;

import br.com.ebix.escola.model.Materia;

public interface MateriaFacade {
	List<Materia> getAll();
	Materia get(Materia materia);
	boolean add(Materia materia);
	boolean update(Materia materia);
	boolean delete(Materia materia);
}
