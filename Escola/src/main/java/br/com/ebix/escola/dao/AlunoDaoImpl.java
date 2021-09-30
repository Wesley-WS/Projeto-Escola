package br.com.ebix.escola.dao;

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
			String sql = "Select * from escola.alunos ";
			PreparedStatement ps = getConnection().prepareStatement(sql);
			ResultSet resultado = ps.executeQuery();
			while(resultado.next()) {
				Aluno aluno = new Aluno();
				aluno.setNome(resultado.getString("nome"));
				aluno.setCod_aluno(resultado.getInt("cod_aluno"));;
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
		/*try {
			
		} catch(SQLException e) {
			e.printStackTrace();
		}*/
	}

	@Override
	public void update(Aluno t) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Aluno t) {
		
	}
}
