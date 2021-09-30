package br.com.ebix.escola.dao;

import java.sql.ResultSet;

import br.com.ebix.escola.model.Aluno;
import br.com.ebix.escola.model.InterfaceBasica;

public interface AlunoDao extends InterfaceBasica<Aluno> {
	ResultSet getAll();
}
