package br.com.ebix.escola.action;

import java.util.List;

import org.apache.struts2.interceptor.validation.SkipValidation;

import com.opensymphony.xwork2.ActionSupport;

import br.com.ebix.escola.facade.MateriaFacadeImpl;
import br.com.ebix.escola.model.Materia;

public class MateriasAction extends ActionSupport /*implements ModelDriven<Object>*/ {
	private static final long serialVersionUID = 1L;
	
	private MateriaFacadeImpl materiaFacadeImpl = new MateriaFacadeImpl();
	
	private Materia materia = new Materia();
	
	private List<Materia> materias;
	
	public Materia getMateria() {
		return materia;
	}
	
	public void setMateria(Materia materia) {
		this.materia = materia;
	}
	
	public List<Materia> getMaterias() {
		return materias;
	}
	
	public void setMaterias(List<Materia> materias) {
		this.materias = materias;
	}

	@SkipValidation
	public String listar() {
		materias = materiaFacadeImpl.getAll();
		return "success";
	}

	public String cadastrar() {
		if(materiaFacadeImpl.add(materia)) {
			materias = materiaFacadeImpl.getAll();
			return "success";
		}else {
			return "input";
		}
	}
	
	public String alterar() {
		if(materiaFacadeImpl.update(materia)) {
			materias = materiaFacadeImpl.getAll();
			
			return "success";
		}else {
			return "input";
		}
	}

	public String deletar() {
		if(materiaFacadeImpl.delete(materia)) {
			return "success";
		}else {
			return "error";
		}
	}
	
	/*@Override
	public Object getModel() {
		return materias;
	}*/
}
