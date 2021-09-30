package br.com.ebix.escola.dao;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import br.com.ebix.escola.model.Aluno;

public class AlunoDaoImpl extends ConnectionFactory implements AlunoDao {
	@Override
	public Optional<Aluno> get(int id) {
		// TODO Auto-generated method stub
		
		return null;
	}

	@Override
	public List<Aluno> getAll() {
		List<Aluno> alunos = new ArrayList<Aluno>();
		try {
			String sql = "SELECT * FROM escola.alunos ";
			PreparedStatement ps = getConnection().prepareStatement(sql);
			ResultSet resultado = ps.executeQuery();
			while(resultado.next()) {
				Aluno aluno = new Aluno();
				aluno.setNome(resultado.getString("nome"));
				aluno.setCod_aluno(resultado.getInt("cod_aluno"));
				aluno.setCpf(resultado.getString("cpf"));
				aluno.setDataNascimento(resultado.getDate("dataNascimento"));
				aluno.setEmail(resultado.getString("email"));
				alunos.add(aluno);
			}
			ps.close();
			resultado.close();
			return alunos;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return alunos;
		}
	}

	@Override
	public void add(Aluno t) {
		try {
			String sql = "INSERT INTO escola.alunos (nome, cpf, dataNascimento, email) VALUES(?, ?, ?, ?)";
			PreparedStatement ps = getConnection().prepareStatement(sql);
			ps.setString(1, t.getNome());
			ps.setString(2, t.getCpf());
			ps.setDate(3, new Date(t.getDataNascimento().getTimeInMillis())); //Ta certo isso?
			ps.setString(4, t.getEmail());
			ps.execute();
			ps.close();
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void update(Aluno t) {
		// TODO Auto-generated method stub
		
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
