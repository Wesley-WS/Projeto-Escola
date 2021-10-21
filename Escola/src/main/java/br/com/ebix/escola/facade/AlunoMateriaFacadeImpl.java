package br.com.ebix.escola.facade;

import br.com.ebix.escola.dao.AlunoMateriaDao;
import br.com.ebix.escola.dao.AlunoMateriaDaoImpl;
import br.com.ebix.escola.model.Aluno;
import br.com.ebix.escola.model.Materia;
import br.com.ebix.escola.utils.ValidaStringUtil;

public class AlunoMateriaFacadeImpl implements AlunoMateriaFacade{
	
	private AlunoMateriaDao alunoMateriaDao = new AlunoMateriaDaoImpl();
	private MateriaFacade materiaFacade = new MateriaFacadeImpl();
	
	@Override
	public void associar(Aluno aluno, Materia materia) {
		if(!codigoEInvalido(aluno, materia)) {
			Materia materiaObtida = materiaFacade.get(materia);
			
			if(materiaObtida != null) {
				alunoMateriaDao.associar(aluno, materia);
			}
		}
	}
	
	public boolean codigoEInvalido(Aluno aluno, Materia materia) {
		return (ValidaStringUtil.eNuloVazioOuHaApenasEspaco(aluno.getCod_aluno()) || ValidaStringUtil.eNuloVazioOuHaApenasEspaco(materia.getCod_materia()));
	}
}
