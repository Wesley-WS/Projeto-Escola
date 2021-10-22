package br.com.ebix.escola.facade;

import java.util.ArrayList;
import java.util.List;

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
	

	public List<Materia> getAllMateriasByCodAluno(Aluno aluno){
		List<Long> cod_materias = alunoMateriaDao.getAllCodMatByCod(aluno);
		List<Materia> materiasAll = new ArrayList<Materia>();
		materiasAll = materiaFacade.getAll();
		
		if(cod_materias.size() > 0) {
			for(Long cod_materia : cod_materias) {
				for(Materia materia : materiasAll) {
					if(materia.getCod_materia()==cod_materia) {
						materiasAll.remove(materia);
						break;
					}
				}
			}
			return materiasAll;
		} else {
			return materiasAll;
		}
		
	}
	
	public List<Materia> getAllMateriasByCodAlunoHaving(Aluno aluno){
		List<Long> cod_materias = alunoMateriaDao.getAllCodMatByCod(aluno);
		List<Materia> materiasAll = new ArrayList<Materia>();
		materiasAll = materiaFacade.getAll();
		List<Materia> materiasAssociadas = new ArrayList<Materia>();
		if(cod_materias.size() > 0) {
			for(Long cod_materia : cod_materias) {
				for(Materia materia : materiasAll) {
					if(materia.getCod_materia()==cod_materia) {
						materiasAssociadas.add(materia);
						break;
					}
				}
			}
			return materiasAssociadas;
		} else {
			return materiasAssociadas;
		}
	}
	
	public boolean codigoEInvalido(Aluno aluno, Materia materia) {
		return (ValidaStringUtil.eNuloVazioOuHaApenasEspaco(aluno.getCod_aluno()) || ValidaStringUtil.eNuloVazioOuHaApenasEspaco(materia.getCod_materia()));
	}
}
