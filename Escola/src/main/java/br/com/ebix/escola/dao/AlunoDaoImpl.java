package br.com.ebix.escola.dao;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Optional;

import br.com.ebix.escola.model.Aluno;

public class AlunoDaoImpl extends ConnectionFactory implements AlunoDao {
	@Override
	public Optional<Aluno> get(int id) {
		// TODO Auto-generated method stub
		
		return null;
	}

	@Override
	public ResultSet getAll() {
		ResultSet resultado = null;
		try {
			String sql = "SELECT * FROM escola.alunos ";
			PreparedStatement ps = getConnection().prepareStatement(sql);
			resultado = ps.executeQuery();
			return resultado;
		} catch (SQLException e) {
			e.printStackTrace();
			return resultado;
		}
	}

	@Override
	public void add(Aluno t) {
		try {
			String sql = "INSERT INTO escola.alunos (nome, cpf, dataNascimento, email, telefone_celular, telefone_residencial) VALUES(?, ?, ?, ?, ?, ?)";
			PreparedStatement ps = getConnection().prepareStatement(sql);
			ps.setString(1, t.getNome());
			ps.setString(2, t.getCpf());
			ps.setDate(3, new Date(t.getDataNascimento().getTimeInMillis()));
			ps.setString(4, t.getEmail());
			ps.setString(5, t.getTelefoneCelular());
			ps.setString(6, t.getTelefoneResidencial());
			
			ps.execute();
			ps.close();
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void update(Aluno t) {
		try {
			String sql = "UPDATE escola.alunos SET nome=?, cpf=?, dataNascimento=?, email=?, telefone_celular=?, telefone_residencial=? WHERE cod_aluno=?";
			PreparedStatement ps = getConnection().prepareStatement(sql);
			ps.setString(1, t.getNome());
			ps.setString(2, t.getCpf());
			ps.setDate(3, new Date(t.getDataNascimento().getTimeInMillis()));
			ps.setString(4, t.getEmail());
			ps.setString(5, t.getTelefoneCelular());
			ps.setString(6, t.getTelefoneResidencial());
			ps.setLong(7, t.getCod_aluno());
			
			ps.execute();
			ps.close();
		} catch(SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void delete(Aluno t) {
		try {
			String sql = "DELETE FROM escola.alunos WHERE cod_aluno=?";
			PreparedStatement ps = getConnection().prepareStatement(sql);
			ps.setLong(1, t.getCod_aluno());
			ps.execute();
			ps.close();
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
}
