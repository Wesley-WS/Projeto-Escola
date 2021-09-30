package br.com.ebix.escola.dao;

import java.sql.ResultSet;

import br.com.ebix.escola.model.InterfaceBasica;
import br.com.ebix.escola.model.Materia;

public interface MateriaDao extends InterfaceBasica<Materia> {
	ResultSet getAll();
}
