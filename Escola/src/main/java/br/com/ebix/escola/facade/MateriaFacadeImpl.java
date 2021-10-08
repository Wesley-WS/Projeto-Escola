package br.com.ebix.escola.facade;

import java.util.List;
import java.util.Optional;

import br.com.ebix.escola.dao.MateriaDao;
import br.com.ebix.escola.dao.MateriaDaoImpl;
import br.com.ebix.escola.model.Materia;
import br.com.ebix.escola.utils.ValidaStringUtil;

public class MateriaFacadeImpl implements MateriaFacade {
	//private MateriaDaoImpl materiaDaoImpl = new MateriaDaoImpl();
	private MateriaDao materiaDao = new MateriaDaoImpl();

	@Override
	public Materia get(Materia materia) {
		if(ValidaStringUtil.eNuloVazioOuHaApenasEspaco(materia.getCod_materia())) {
			return null;
		} else {
			Optional<Materia> materiaObtida = materiaDao.get(materia);
			
			if(materiaObtida.isPresent()) {
				return materiaObtida.get();
			}else {
				return null;
			}
		}
	}

	@Override
	public List<Materia> getAll() {
		return materiaDao.getAll();
	}

	@Override
	public boolean add(Materia materia) {
		if (ValidaStringUtil.eNuloVazioOuHaApenasEspaco(materia.getNome())
				|| ValidaStringUtil.eNuloVazioOuHaApenasEspaco(materia.getSigla())) {
			return false;
		} else {
			materiaDao.add(materia);
			return true;
		}
	}

	@Override
	public boolean update(Materia materia) {
		if (ValidaStringUtil.eNuloVazioOuHaApenasEspaco(materia.getNome())
				|| ValidaStringUtil.eNuloVazioOuHaApenasEspaco(materia.getSigla())) {
			return false;
		} else {
			materiaDao.update(materia);
			return true;
		}
	}

	@Override
	public boolean delete(Materia t) {
		if (ValidaStringUtil.eNuloVazioOuHaApenasEspaco(t.getCod_materia())) {
			return false;
		} else {
			materiaDao.delete(t);
			return true;
		}

	}

}
