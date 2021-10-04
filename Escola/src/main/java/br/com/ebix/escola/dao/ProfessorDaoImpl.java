package br.com.ebix.escola.dao;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Optional;

import br.com.ebix.escola.model.Professor;

public class ProfessorDaoImpl extends ConnectionFactory implements ProfessorDao {
	
	public Optional<Professor> get(int id) {
		
		return null;
	}
	
	@Override
	public ResultSet getAll() {
		ResultSet resultado = null;
		try {
			String sql = "SELECT * FROM escola.professores ";
			PreparedStatement ps = getConnection().prepareStatement(sql);
			resultado = ps.executeQuery();
			return resultado;
		} catch (SQLException e) {
			e.printStackTrace();
			return resultado;
		}
	}


	@Override
	public void add(Professor p) {
		try {
			String sql = "INSERT INTO escola.professores (nome, cpf, email, dataNascimento, telefone_cel, telefone_res) VALUES(?, ?, ?, ?)";
			PreparedStatement ps = getConnection().prepareStatement(sql);
			ps.setString(1, p.getNome());
			ps.setString(2, p.getCpf());
			ps.setString(4, p.getEmail());
			ps.setDate(3, new Date(p.getDataNascimento().getTimeInMillis()));
			ps.setString(5, p.getTelefoneCelular());
			ps.setString(6, p.getTelefoneResidencial());
			ps.execute();
			ps.close();
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}


	@Override
	public void update(Professor p) {
		try {
			String sql = "UPDATE escola.professores SET nome = ?, cpf= ?, email= ?, dataNascimento= ?, telefone_cel= ?, telefone_res= ? WHERE cod_professor = ?";
			PreparedStatement ps = getConnection().prepareStatement(sql);
			ps.setString(1, p.getNome());
			ps.setString(2, p.getCpf());
			ps.setString(4, p.getEmail());
			ps.setDate(3, new Date(p.getDataNascimento().getTimeInMillis()));
			ps.setString(5, p.getTelefoneCelular());
			ps.setString(6, p.getTelefoneResidencial());
			ps.setLong(7, p.getCod_professor());
			ps.execute();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}


	@Override
	public void delete(Professor p) {
		try {
			String sql = "DELETE FROM escola.professores WHERE cod_professor=?";
			PreparedStatement ps = getConnection().prepareStatement(sql);
			ps.setLong(1, p.getCod_professor());
			ps.execute();
			ps.close();
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
}
