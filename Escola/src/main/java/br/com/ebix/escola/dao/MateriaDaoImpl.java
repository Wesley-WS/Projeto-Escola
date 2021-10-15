package br.com.ebix.escola.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import br.com.ebix.escola.model.Materia;

public class MateriaDaoImpl extends ConnectionFactory implements MateriaDao {

	@Override
	public Optional<Materia> get(Materia materia) {
		Materia materiaObtida = null;
		try {
			String sql = "SELECT * FROM escola.materias WHERE cod_materia=?";
			
			PreparedStatement ps = getConnection().prepareStatement(sql);
			ps.setLong(1, materia.getCod_materia());
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				materiaObtida = new Materia();
				materiaObtida.setCod_materia(rs.getLong("cod_materia"));
				materiaObtida.setNome(rs.getString("nome"));
				materiaObtida.setSigla(rs.getString("sigla"));
			}
			
			rs.close();
			ps.close();
			
			return Optional.ofNullable(materiaObtida);
		}catch(SQLException e) {
			e.printStackTrace();
			return Optional.ofNullable(materiaObtida);
		}
	}

	@Override
	public List<Materia> getAll() {
		List<Materia> materias = new ArrayList<Materia>();
		try {
			String sql = "SELECT * FROM escola.materias";
			
			PreparedStatement ps = getConnection().prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				Materia materia = new Materia();
				materia.setCod_materia(rs.getLong("cod_materia"));
				materia.setNome(rs.getString("nome"));
				materia.setSigla(rs.getString("sigla"));
				
				materias.add(materia);
			}
			
			rs.close();
			ps.close();
			
			return materias;
		}catch(SQLException e) {
			e.printStackTrace();
			return materias;
		}
	}

	@Override
	public void add(Materia materia) {
		try {
			String sql = "INSERT INTO escola.materias (nome, sigla) VALUES(?, ?)";
			PreparedStatement ps = getConnection().prepareStatement(sql);
			ps.setString(1, materia.getNome());
			ps.setString(2, materia.getSigla());
			
			ps.execute();
			ps.close();
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void update(Materia materia) {
		try {
			String sql = "UPDATE escola.materias SET nome=?, sigla=? WHERE cod_materia=?";
			PreparedStatement ps = getConnection().prepareStatement(sql);
			ps.setString(1, materia.getNome());
			ps.setString(2, materia.getSigla());
			ps.setLong(3, materia.getCod_materia());
			
			ps.execute();
			ps.close();
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void delete(Materia materia) {
		try {
			String sql = "DELETE FROM escola.materias WHERE cod_materia=?";
			PreparedStatement ps = getConnection().prepareStatement(sql);
			ps.setLong(1, materia.getCod_materia());
			
			ps.execute();
			ps.close();
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}

}
