package br.com.ebix.escola.facade;

import br.com.ebix.escola.model.Aluno;
import br.com.ebix.escola.model.Materia;

public interface AlunoMateriaFacade {

	void associar(Aluno aluno, Materia materia);

}
