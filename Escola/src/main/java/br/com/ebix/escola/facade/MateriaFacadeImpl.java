package br.com.ebix.escola.facade;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import br.com.ebix.escola.dao.MateriaDaoImpl;
import br.com.ebix.escola.model.Materia;
import br.com.ebix.escola.utils.ValidaStringUtil;

public class MateriaFacadeImpl implements MateriaFacade {
	private MateriaDaoImpl materiaDaoImpl = new MateriaDaoImpl();

	@Override
	public Optional<Materia> get(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Materia> getAll() {
		List<Materia> materias = new ArrayList<Materia>();
		try {
			ResultSet rs = materiaDaoImpl.getAll();

			while (rs.next()) {
				Materia materia = new Materia();
				materia.setCod_materia(rs.getLong("cod_materia"));
				materia.setNome(rs.getString("nome"));
				materia.setSigla(rs.getString("sigla"));

				materias.add(materia);
			}
			rs.close();
			return materias;
		} catch (SQLException e) {
			e.printStackTrace();
			return materias;
		}
	}

	@Override
	public boolean add(Materia t) {
		if (ValidaStringUtil.eNuloVazioOuHaApenasEspaco(t.getNome())
				|| ValidaStringUtil.eNuloVazioOuHaApenasEspaco(t.getSigla())) {
			return false;
		} else {
			materiaDaoImpl.add(t);
			return true;
		}
	}

	@Override
	public boolean update(Materia t) {
		if (ValidaStringUtil.eNuloVazioOuHaApenasEspaco(t.getNome())
				|| ValidaStringUtil.eNuloVazioOuHaApenasEspaco(t.getSigla())) {
			return false;
		} else {
			materiaDaoImpl.update(t);
			return true;
		}
	}

	@Override
	public boolean delete(Materia t) {
		if (ValidaStringUtil.eNuloVazioOuHaApenasEspaco(t.getCod_materia())) {
			return false;
		} else {
			materiaDaoImpl.delete(t);
			return true;
		}

	}

}
