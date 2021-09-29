package br.com.ebix.escola.action;

import java.util.ArrayList;
import java.util.List;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import br.com.ebix.escola.model.Materia;

public class MateriasAction extends ActionSupport implements ModelDriven<Object> {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Materia materia = new Materia();
	private List<Materia> materias = new ArrayList<Materia>();
	
	public String listar() {
		// materias = materiasDao.obterMaterias();
		return "success";
	}

	public String adicionar() {
		// materiasDao.adicionar(materia);
		return "success";
	}

	public String remover() {
		// materiaDao.remover(materia);
		return "success";
	}
	
	@Override
	public Object getModel() {
		return materias;
	}
}
