package br.com.ebix.escola.facade;

import java.util.List;
import java.util.Optional;

import br.com.ebix.escola.enums.AcoesValidacao;
import br.com.ebix.escola.model.Materia;

public interface MateriaFacade {
	List<Materia> getAll();
	Materia get(Materia materia);
	List<AcoesValidacao> add(Materia materia);
	List<AcoesValidacao> update(Materia materia);
	AcoesValidacao delete(Materia materia);
}
