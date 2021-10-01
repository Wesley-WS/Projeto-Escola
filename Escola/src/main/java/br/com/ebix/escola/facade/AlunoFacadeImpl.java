package br.com.ebix.escola.facade;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import br.com.ebix.escola.dao.AlunoDaoImpl;
import br.com.ebix.escola.model.Aluno;

public class AlunoFacadeImpl implements AlunoFacade {
	private AlunoDaoImpl alunoDaoImpl = new AlunoDaoImpl();

	@Override
	public Optional<Aluno> get(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Aluno> getAll() {
		List<Aluno> alunos = new ArrayList<Aluno>();
		try {
			ResultSet rs = alunoDaoImpl.getAll();

			while (rs.next()) {
				Aluno aluno = new Aluno();
				aluno.setCod_aluno(rs.getLong("cod_aluno"));
				aluno.setNome(rs.getString("nome"));
				aluno.setCpf(rs.getString("cpf"));

				Date date = rs.getDate("dataNascimento");
				Calendar calendario = Calendar.getInstance();
				calendario.setTime(date);
				aluno.setDataNascimento(calendario);

				aluno.setEmail(rs.getString("email"));
				aluno.setTelefoneCelular(rs.getString("telefone_celular"));
				aluno.setTelefoneResidencial(rs.getString("telefone_residencial"));
				alunos.add(aluno);
			}
			rs.close();
			return alunos;
		} catch (SQLException e) {
			e.printStackTrace();
			return alunos;
		}
	}

	@Override
	public boolean add(Aluno t) {
		// TODO Auto-generated method stub
		if (t.getNome().isBlank() || t.getNome().trim().isEmpty() || t.getCpf().isBlank() || t.getCpf().trim().isEmpty() || t.getDataNascimento() == null) {
			return false;
		} else {
			alunoDaoImpl.add(t);
			return true;
		}

	}

	@Override
	public boolean update(Aluno t) {
		// TODO Auto-generated method stub
		if (t.getNome().isBlank() || t.getNome().trim().isEmpty() || t.getCpf().isBlank() || t.getCpf().trim().isEmpty()
				|| t.getEmail().isBlank() || t.getEmail().trim().isEmpty() || t.getDataNascimento() == null) {
			return false;
		} else {
			alunoDaoImpl.update(t);
			return true;
		}
	}

	@Override
	public boolean delete(Aluno t) {
		if (t.getCod_aluno() == null) {
			return false;
		} else {
			alunoDaoImpl.delete(t);
			return true;
		}

	}

}
