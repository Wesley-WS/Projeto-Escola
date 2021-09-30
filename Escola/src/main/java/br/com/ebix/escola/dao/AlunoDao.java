package br.com.ebix.escola.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import br.com.ebix.escola.model.Aluno;

public class AlunoDao {
	private	Connection	connection;
	
	public	AlunoDao(Connection	connection) {
			this.connection	=	connection;
	}
	
	public void adiciona() {
	}
	
	public List<Aluno> obterAlunos() {
		List<Aluno> alunos = new ArrayList<Aluno>();
		try {
			String	sql	=	"Select * from escola.alunos ";
			PreparedStatement	ps	=  connection.prepareStatement(sql);
			ResultSet resultado = ps.executeQuery();
			while(resultado.next()) {
				Aluno aluno = new Aluno();
				aluno.setNome(resultado.getString("nome"));
				aluno.setCod_aluno(resultado.getInt("cod_aluno"));;
				aluno.setCod_materia(resultado.getInt("cod_materia"));
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
}
