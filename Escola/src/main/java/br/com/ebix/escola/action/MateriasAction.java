package br.com.ebix.escola.action;

import java.util.List;

import org.apache.struts2.interceptor.validation.SkipValidation;

import com.opensymphony.xwork2.ActionSupport;

import br.com.ebix.escola.facade.MateriaFacade;
import br.com.ebix.escola.facade.MateriaFacadeImpl;
import br.com.ebix.escola.model.Materia;

public class MateriasAction extends ActionSupport /*implements ModelDriven<Object>*/ {
	private static final long serialVersionUID = 1L;
	private MateriaFacade materiaFacade = new MateriaFacadeImpl();
	
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
		materias = materiaFacade.getAll();
		return "success";
	}

	public String cadastrar() {
		if(materiaFacade.add(materia)) {
			//materias = materiaFacade.getAll();
			return "success";
		}else {
			return "input";
		}
	}
	
	public String alterar() {
		if(materiaFacade.update(materia)) {
			//materias = materiaFacade.getAll();
			
			return "success";
		}else {
			return "input";
		}
	}

	public String deletar() {
		if(materiaFacade.delete(materia)) {
			return "success";
		}else {
			return "error";
		}
	}
	
	public String detalhar() {
		materia = materiaFacade.get(materia); //TODO: ARRUMAR ISSO AQUI
		
		return "success";
	}
	
	/*@Override
	public Object getModel() {
		return materias;
	}*/
}
