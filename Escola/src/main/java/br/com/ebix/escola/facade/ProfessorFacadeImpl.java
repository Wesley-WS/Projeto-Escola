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
import br.com.ebix.escola.utils.ValidaTelefoneUtil;


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
		if(dadosEstaoInvalidos(professor) || telefoneEstaInvalido(professor) || CpfJaExiste(professor)) {
			return false;
		} else {
			professorDao.add(professor);
			return true;
		}

	}

	@Override
	public boolean update(Professor professor) {
		if(codigoEstaInvalido(professor) || dadosEstaoInvalidos(professor) || telefoneEstaInvalido(professor) || updateCpfJaExiste(professor)) {
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
	
	public boolean telefoneEstaInvalido(Professor professor) {
		if(ValidaStringUtil.eNuloVazioOuHaApenasEspaco(professor.getTelefoneCelular())
				|| ValidaStringUtil.eNuloVazioOuHaApenasEspaco(professor.getTelefoneCelular())) {
			return false;
		} else {
			return (ValidaTelefoneUtil.eUmNumeroDeCelularInvalido(professor.getTelefoneCelular())
					|| ValidaTelefoneUtil.eUmNumeroResidencialInvalido(professor.getTelefoneResidencial()));
		}
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

	public boolean CpfJaExiste(Professor professor) {
		return professorDao.cpfCadastrado(professor);
	}
	
	public boolean updateCpfJaExiste(Professor professor) {
		String cpfDigitado = professor.getCpf();
		Optional<Professor> professorObtido = professorDao.get(professor);
		if(!professorObtido.isPresent()) {
			return false;
		}
		if(cpfDigitado.equals(professorObtido.get().getCpf())) {
			return false;
		}else {
			return professorDao.cpfCadastrado(professor);
		}
		
	}
}
