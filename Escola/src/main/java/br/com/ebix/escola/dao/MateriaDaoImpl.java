package br.com.ebix.escola.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Optional;

import br.com.ebix.escola.model.Materia;

public class MateriaDaoImpl extends ConnectionFactory implements MateriaDao {

	@Override
	public Optional<Materia> get(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultSet getAll() {
		ResultSet resultado = null;
		try {
			String sql = "SELECT * FROM escola.materias";
			PreparedStatement ps = getConnection().prepareStatement(sql);
			resultado = ps.executeQuery();
			return resultado;
		}catch(SQLException e) {
			e.printStackTrace();
			return resultado;
		}
	}

	@Override
	public void add(Materia t) {
		try {
			String sql = "INSERT INTO TABLE escola.materias (nome, sigla) VALUES(?, ?)";
			PreparedStatement ps = getConnection().prepareStatement(sql);
			ps.setString(1, t.getNome());
			ps.setString(2, t.getSigla());
			ps.execute();
			ps.close();
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void update(Materia t) {
		try {
			String sql = "UPDATE escola.materias SET nome=?, sigla=? WHERE cod_materia=?";
			PreparedStatement ps = getConnection().prepareStatement(sql);
			ps.setString(1, t.getNome());
			ps.setString(2, t.getSigla());
			ps.setLong(3, t.getCod_materia());
			ps.execute();
			ps.close();
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void delete(Materia t) {
		try {
			String sql = "DELETE FROM TABLE escola.materias WHERE cod_materia=?";
			PreparedStatement ps = getConnection().prepareStatement(sql);
			ps.setLong(1, t.getCod_materia());
			ps.execute();
			ps.close();
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}

}
