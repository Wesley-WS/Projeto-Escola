package br.com.ebix.escola.facade;

import java.util.List;
import java.util.Optional;

import br.com.ebix.escola.dao.AlunoDao;
import br.com.ebix.escola.dao.AlunoDaoImpl;
import br.com.ebix.escola.model.Aluno;
import br.com.ebix.escola.utils.ValidaStringUtil;

public class AlunoFacadeImpl implements AlunoFacade {
	
	//@Autowired
	//private AlunoDao alunoDao;
	
	private AlunoDao alunoDao = new AlunoDaoImpl();
	
	@Override
	public Aluno get(Aluno aluno) {
		if(ValidaStringUtil.eNuloVazioOuHaApenasEspaco(aluno.getCod_aluno())) {
			return null;
		} else {
			Optional<Aluno> alunoObtido = alunoDao.get(aluno);
			
			if(alunoObtido.isPresent()) {
				return alunoObtido.get();
			} else {
				return null;
			}
		}
	}

	@Override
	public List<Aluno> getAll() {
		return alunoDao.getAll();
	}

	@Override
	public boolean add(Aluno aluno) {
		if(ValidaStringUtil.eNuloVazioOuHaApenasEspaco(aluno.getNome()) ||
				ValidaStringUtil.eNuloVazioOuHaApenasEspaco(aluno.getCpf()) ||
				ValidaStringUtil.eNuloVazioOuHaApenasEspaco(aluno.getDataNascimento())) {
			return false;
		} else {
			alunoDao.add(aluno);
			return true;
		}

	}
	
	/*public boolean valida(Aluno aluno) {
		if(ValidaStringUtil.eNuloVazioOuHaApenasEspaco(aluno.getCod_aluno()) || 
				ValidaStringUtil.eNuloVazioOuHaApenasEspaco(aluno.getNome()) || 
				ValidaStringUtil.eNuloVazioOuHaApenasEspaco(aluno.getCpf()) || 
				ValidaStringUtil.eNuloVazioOuHaApenasEspaco(aluno.getEmail()) || 
				ValidaStringUtil.eNuloVazioOuHaApenasEspaco(aluno.getDataNascimento())) {
			return false;
		} else if() {
			
		}
	}*/

	@Override
	public boolean update(Aluno aluno) {
		if(ValidaStringUtil.eNuloVazioOuHaApenasEspaco(aluno.getCod_aluno()) || 
				ValidaStringUtil.eNuloVazioOuHaApenasEspaco(aluno.getNome()) || 
				ValidaStringUtil.eNuloVazioOuHaApenasEspaco(aluno.getCpf()) || 
				ValidaStringUtil.eNuloVazioOuHaApenasEspaco(aluno.getEmail()) || 
				ValidaStringUtil.eNuloVazioOuHaApenasEspaco(aluno.getDataNascimento())) {
			return false;
		} else {
			alunoDao.update(aluno);
			return true;
		}
	}

	@Override
	public boolean delete(Aluno aluno) {
		if(ValidaStringUtil.eNuloVazioOuHaApenasEspaco(aluno.getCod_aluno())) {
			return false;
		} else {
			alunoDao.delete(aluno);
			return true;
		}

	}

}
