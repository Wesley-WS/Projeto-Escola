package br.com.ebix.escola.facade;


import java.util.List;
import java.util.Optional;

import br.com.ebix.escola.dao.ProfessorDao;
import br.com.ebix.escola.dao.ProfessorDaoImpl;
import br.com.ebix.escola.model.Professor;
import br.com.ebix.escola.utils.ValidaStringUtil;


public class ProfessorFacadeImpl implements ProfessorFacade {
	private ProfessorDao professorDao = new ProfessorDaoImpl();

	@Override
	public Professor get(Professor professor) {
		if(ValidaStringUtil.eNuloVazioOuHaApenasEspaco(professor.getCod_professor())) {
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
	public boolean add(Professor p) {
		// TODO Auto-generated method stub
		if(ValidaStringUtil.eNuloVazioOuHaApenasEspaco(p.getNome()) ||
				ValidaStringUtil.eNuloVazioOuHaApenasEspaco(p.getCpf()) ||
				ValidaStringUtil.eNuloVazioOuHaApenasEspaco(p.getDataNascimento())) {
			return false;
		} else {
			professorDao.add(p);
			return true;
		}

	}

	@Override
	public boolean update(Professor professor) {
		if(ValidaStringUtil.eNuloVazioOuHaApenasEspaco(professor.getCod_professor()) || 
				ValidaStringUtil.eNuloVazioOuHaApenasEspaco(professor.getNome()) || 
				ValidaStringUtil.eNuloVazioOuHaApenasEspaco(professor.getCpf()) || 
				ValidaStringUtil.eNuloVazioOuHaApenasEspaco(professor.getEmail()) || 
				ValidaStringUtil.eNuloVazioOuHaApenasEspaco(professor.getDataNascimento())) {
			return false;
		} else {
			professorDao.update(professor);
			return true;
		}
	}

	@Override
	public boolean delete(Professor professor) {
		if(ValidaStringUtil.eNuloVazioOuHaApenasEspaco(professor.getCod_professor())) {
			return false;
		} else {
			professorDao.delete(professor);
			return true;
		}

	}

}
