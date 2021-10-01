package br.com.ebix.escola.action;

import java.util.ArrayList;
import java.util.List;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import br.com.ebix.escola.model.Materia;

public class MateriasAction extends ActionSupport /*implements ModelDriven<Object>*/ {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	// private Materia materia = new Materia();
	private List<Materia> materias = new ArrayList<Materia>();
	
	public List<Materia> getMaterias() {
		return materias;
	}
	
	public String listar() {
		return "success";
	}

	public String adicionar() {
		return "success";
	}

	public String remover() {
		return "success";
	}
	
	/*@Override
	public Object getModel() {
		return materias;
	}*/
}
