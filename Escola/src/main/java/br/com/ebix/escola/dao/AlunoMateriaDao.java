package br.com.ebix.escola.dao;

import java.util.List;

import br.com.ebix.escola.model.AlunoMateria;

public interface AlunoMateriaDao {
	List<AlunoMateria> selecionaMateriasAluno(long codigo);
}
