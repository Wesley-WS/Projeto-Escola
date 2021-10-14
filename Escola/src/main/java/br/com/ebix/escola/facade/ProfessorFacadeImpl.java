package br.com.ebix.escola.facade;


import java.util.List;
import java.util.Optional;

import br.com.ebix.escola.dao.ProfessorDao;
import br.com.ebix.escola.dao.ProfessorDaoImpl;
import br.com.ebix.escola.model.Professor;
import br.com.ebix.escola.utils.ValidaCpf;
import br.com.ebix.escola.utils.ValidaDataUtil;
import br.com.ebix.escola.utils.ValidaEmail;
import br.com.ebix.escola.utils.ValidaStringUtil;


public class ProfessorFacadeImpl implements ProfessorFacade {
	private ProfessorDao professorDao = new ProfessorDaoImpl();

	@Override
	public Professor get(Professor professor) {
		if(codigoEstaInvalido(professor)) {
			return null;
		} else {
			Optional<Professor> professorObtido = professorDao.get(professor);
			
			if(professorObtido.isPresent()) {
				return professorObtido.get();
			} else {
				return null;
			}
		}
	}

	@Override
	public List<Professor> getAll() {
		return professorDao.getAll();
	}

	@Override
	public boolean add(Professor professor) {
		if(dadosEstaoInvalidos(professor)) {
			return false;
		} else {
			professorDao.add(professor);
			return true;
		}

	}

	@Override
	public boolean update(Professor professor) {
		if(codigoEstaInvalido(professor) || dadosEstaoInvalidos(professor)) {
			return false;
		} else {
			professorDao.update(professor);
			return true;
		}
	}

	@Override
	public boolean delete(Professor professor) {
		if(codigoEstaInvalido(professor)) {
			return false;
		} else {
			professorDao.delete(professor);
			return true;
		}

	}
	
	public boolean codigoEstaInvalido(Professor professor) {
		return ValidaStringUtil.eNuloVazioOuHaApenasEspaco(professor.getCod_professor());
	}
	
	public boolean dadosEstaoInvalidos(Professor professor) {
		return (ValidaEmail.eUmEmailInvalido(professor.getEmail())
				|| ValidaDataUtil.eUmaDataInvalida(professor.getDataNascimento())
				|| ValidaCpf.cpfEInvalido(professor.getCpf())
				|| ValidaStringUtil.eNuloVazioOuHaApenasEspaco(professor.getEmail())
				|| ValidaStringUtil.eNuloVazioOuHaApenasEspaco(professor.getNome())
				|| ValidaStringUtil.eNuloVazioOuHaApenasEspaco(professor.getCpf())
				|| ValidaStringUtil.eNuloVazioOuHaApenasEspaco(professor.getDataNascimento()));
	}

}
