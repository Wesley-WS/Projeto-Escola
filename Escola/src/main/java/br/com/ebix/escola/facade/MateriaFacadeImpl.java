package br.com.ebix.escola.facade;

import java.util.List;
import java.util.Optional;

import br.com.ebix.escola.dao.MateriaDao;
import br.com.ebix.escola.dao.MateriaDaoImpl;
import br.com.ebix.escola.model.Materia;
import br.com.ebix.escola.utils.ValidaStringUtil;

public class MateriaFacadeImpl implements MateriaFacade {
	private MateriaDao materiaDao = new MateriaDaoImpl();

	@Override
	public Materia get(Materia materia) {
		if (validaCod(materia)) {
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
	public boolean add(Materia materia) {
		if (validaMateria(materia)) {
			return false;
		} else {
			materiaDao.add(materia);
			return true;
		}
	}

	@Override
	public boolean update(Materia materia) {
		if (validaCod(materia) || validaMateria(materia)) {
			return false;
		} else {
			materiaDao.update(materia);
			return true;
		}
	}

	@Override
	public boolean delete(Materia materia) {
		if (validaCod(materia)) {
			return false;
		} else {
			materiaDao.delete(materia);
			return true;
		}

	}

	public boolean validaCod(Materia materia) {
		if (ValidaStringUtil.eNuloVazioOuHaApenasEspaco(materia.getCod_materia())) {
			return false;
		} else {
			return true;
		}
	}

	public boolean validaMateria(Materia materia) {
		if (ValidaStringUtil.eNuloVazioOuHaApenasEspaco(materia.getCod_materia())
				|| ValidaStringUtil.eNuloVazioOuHaApenasEspaco(materia.getNome())
				|| ValidaStringUtil.eNuloVazioOuHaApenasEspaco(materia.getSigla())) {
			return false;
		} else {
			return true;
		}
	}
}
