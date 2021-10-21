package br.com.ebix.escola.facade;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import br.com.ebix.escola.dao.MateriaDao;
import br.com.ebix.escola.dao.MateriaDaoImpl;
import br.com.ebix.escola.enums.AcoesValidacao;
import br.com.ebix.escola.model.Materia;
import br.com.ebix.escola.utils.ValidaStringUtil;

public class MateriaFacadeImpl implements MateriaFacade {
	private MateriaDao materiaDao = new MateriaDaoImpl();

	@Override
	public Materia get(Materia materia) {
		if (codigoEstaInvalido(materia)) {
			return null;
		} else {
			Optional<Materia> materiaObtida = materiaDao.get(materia);

			if (materiaObtida.isPresent()) {
				return materiaObtida.get();
			} else {
				return null;
			}
		}
	}

	@Override
	public List<Materia> getAll() {
		return materiaDao.getAll();
	}

	@Override
	public List<Materia> getAllAvaiable() {
		return materiaDao.getAllAvaiable();
	}
	
	@Override
	public List<AcoesValidacao> add(Materia materia) {
		List<AcoesValidacao> acoes = dadosEstaoInvalidos(materia);
		if(acoes.size() == 0) {
			materiaDao.add(materia);
		}
		
		return acoes;
	}
	
	@Override
	public List<AcoesValidacao> update(Materia materia) {
		List<AcoesValidacao> acoes = dadosEstaoInvalidos(materia);
		if(codigoEstaInvalido(materia)) {
			acoes.add(AcoesValidacao.CODIGOINVALIDO);
		}
		
		if(acoes.size() == 0) {
			materiaDao.update(materia);
		}
		
		return acoes;
	}

	@Override
	public AcoesValidacao delete(Materia materia) {
		AcoesValidacao acao = null;
		if(codigoEstaInvalido(materia)) {
			acao = AcoesValidacao.CODIGOINVALIDO;
		} else {
			materiaDao.delete(materia);
		}
		return acao;

	}

	public boolean codigoEstaInvalido(Materia materia) {
		return (ValidaStringUtil.eNuloVazioOuHaApenasEspaco(materia.getCod_materia()));
	}

	public List<AcoesValidacao> dadosEstaoInvalidos(Materia materia) {
		List<AcoesValidacao> acoes = new ArrayList<AcoesValidacao>();
		
		if(ValidaStringUtil.eNuloVazioOuHaApenasEspaco(materia.getNome())) {
			acoes.add(AcoesValidacao.NOMEEMBRANCO);
		}
		if(ValidaStringUtil.eNuloVazioOuHaApenasEspaco(materia.getSigla())) {
			acoes.add(AcoesValidacao.SIGLAEMBRANCO);
		} else {
			if(materia.getSigla().length() > 5) {
				acoes.add(AcoesValidacao.SIGLAMINIMOCHAREXCEDIDO);
			}
		}
		return acoes;
	}

}
