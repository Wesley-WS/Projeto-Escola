package br.com.ebix.escola.facade;

import java.util.List;

import br.com.ebix.escola.model.InterfaceBasica;
import br.com.ebix.escola.model.Materia;

public interface MateriaFacade extends InterfaceBasica<Materia> {
	List<Materia> getAll();
}