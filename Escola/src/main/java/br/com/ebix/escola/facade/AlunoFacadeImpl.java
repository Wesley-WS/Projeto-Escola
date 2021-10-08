package br.com.ebix.escola.facade;

import java.util.Calendar;
import java.util.List;
import java.util.Optional;

import br.com.ebix.escola.dao.AlunoDao;
import br.com.ebix.escola.dao.AlunoDaoImpl;
import br.com.ebix.escola.model.Aluno;
import br.com.ebix.escola.model.Professor;
import br.com.ebix.escola.utils.ValidaStringUtil;

public class AlunoFacadeImpl implements AlunoFacade {
	
	//@Autowired
	//private AlunoDao alunoDao;
	
	private AlunoDao alunoDao = new AlunoDaoImpl();
	
	@Override
	public Aluno get(Aluno aluno) {
		Optional<Aluno> alunoObtido = alunoDao.get(aluno);
		
		if(alunoObtido.isPresent()) {
			return alunoObtido.get();
		} else {
			Aluno alunoInexistente = new Aluno();
			alunoInexistente.setCod_aluno(-1l);
			alunoInexistente.setCpf("NA");
			alunoInexistente.setDataNascimento(Calendar.getInstance());
			alunoInexistente.setEmail("NA");
			alunoInexistente.setNome("NA");
			alunoInexistente.setTelefoneCelular("NA");
			alunoInexistente.setTelefoneResidencial("NA");
			return alunoInexistente;
		}
	}

	@Override
	public List<Aluno> getAll() {
		return alunoDao.getAll();
	}

	@Override
	public boolean add(Aluno aluno) {
		if(validaDados(aluno)) {
			return false;
		} else {
			alunoDao.add(aluno);
			return true;
		}

	}

	@Override
	public boolean update(Aluno aluno) {
		if(validaDados(aluno)) {
			return false;
		} else {
			alunoDao.update(aluno);
			return true;
		}
	}

	@Override
	public boolean delete(Aluno aluno) {
		if(validaCod(aluno)) {
			return false;
		} else {
			alunoDao.delete(aluno);
			return true;
		}

	}

	public boolean validaCod(Aluno aluno) {
		if(ValidaStringUtil.eNuloVazioOuHaApenasEspaco(aluno.getCod_aluno())) {
			return false;
		} else {
			return true;
		}
	}
	
	public boolean validaDados(Aluno aluno) {
		if(ValidaStringUtil.eNuloVazioOuHaApenasEspaco(aluno.getCod_aluno()) || 
				ValidaStringUtil.eNuloVazioOuHaApenasEspaco(aluno.getNome()) || 
				ValidaStringUtil.eNuloVazioOuHaApenasEspaco(aluno.getCpf()) || 
				ValidaStringUtil.eNuloVazioOuHaApenasEspaco(aluno.getEmail()) || 
				ValidaStringUtil.eNuloVazioOuHaApenasEspaco(aluno.getDataNascimento())) {
			return false;
		} else {
			return true;
		}
	}
	
}
