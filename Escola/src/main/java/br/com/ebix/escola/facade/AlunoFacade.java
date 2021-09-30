package br.com.ebix.escola.facade;

import java.util.List;

import br.com.ebix.escola.model.Aluno;
import br.com.ebix.escola.model.InterfaceBasica;

public interface AlunoFacade extends InterfaceBasica<Aluno> {
	List<Aluno> getAll();
}
