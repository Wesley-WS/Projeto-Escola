package br.com.ebix.escola.facade;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import br.com.ebix.escola.dao.ProfessorDaoImpl;
import br.com.ebix.escola.model.Professor;
import br.com.ebix.escola.utils.ValidaStringUtil;


public class ProfessorFacadeImpl implements ProfessorFacade {
	private ProfessorDaoImpl professorDaoImpl = new ProfessorDaoImpl();

	@Override
	public Optional<Professor> get(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Professor> getAll() {
		List<Professor> professores = new ArrayList<Professor>();
		try {
			ResultSet rs = professorDaoImpl.getAll();

			while (rs.next()) {
				Professor professor = new Professor();
				professor.setCod_professor(rs.getLong("cod_professor"));
				professor.setNome(rs.getString("nome"));
				professor.setCpf(rs.getString("cpf"));

				Date date = rs.getDate("dataNascimento");
				Calendar calendario = Calendar.getInstance();
				calendario.setTime(date);
				professor.setDataNascimento(calendario);

				professor.setEmail(rs.getString("email"));
				professor.setTelefoneCelular(rs.getString("telefone_celular"));
				professor.setTelefoneResidencial(rs.getString("telefone_residencial"));
				professores.add(professor);
			}
			rs.close();
			return professores;
		} catch (SQLException e) {
			e.printStackTrace();
			return professores;
		}
	}

	@Override
	public boolean add(Professor p) {
		// TODO Auto-generated method stub
		if(ValidaStringUtil.eNuloVazioOuHaApenasEspaco(p.getNome()) ||
				ValidaStringUtil.eNuloVazioOuHaApenasEspaco(p.getCpf()) ||
				ValidaStringUtil.eNuloVazioOuHaApenasEspaco(p.getDataNascimento())) {
			return false;
		} else {
			professorDaoImpl.add(p);
			return true;
		}

	}

	@Override
	public boolean update(Professor p) {
		professorDaoImpl.update(p);
		return true;
	}

	@Override
	public boolean delete(Professor p) {
		if(ValidaStringUtil.eNuloVazioOuHaApenasEspaco(p.getCod_professor())) {
			return false;
		} else {
			professorDaoImpl.delete(p);
			return true;
		}

	}

}
