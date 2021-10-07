package br.com.ebix.escola.action;

import java.util.List;

import org.apache.struts2.interceptor.validation.SkipValidation;

import com.opensymphony.xwork2.ActionSupport;

import br.com.ebix.escola.facade.ProfessorFacade;
import br.com.ebix.escola.facade.ProfessorFacadeImpl;
import br.com.ebix.escola.model.Professor;

public class ProfessoresAction extends ActionSupport {
	private static final long serialVersionUID = 1L;
	
	private ProfessorFacade professorFacade = new ProfessorFacadeImpl();
	private List<Professor> professores;
	private Professor professor = new Professor();
	
	public List<Professor> getProfessores() {
		return professores;
	}

	public Professor getProfessor() {
		return professor;
	}

	public void setProfessor(Professor professor) {
		this.professor = professor;
	}

	public void setProfessores(List<Professor> professores) {
		this.professores = professores;
	}
	
	@SkipValidation
	public String listar() {
		professores = professorFacade.getAll();
		return "success";
	}
	
	public String cadastrar() {		
		if(professorFacade.add(professor)) {
			professores = professorFacade.getAll();
			return "success";
		} else {
			return "input";
		}
	}
	
	public String alterar() {
		if(professorFacade.update(professor)) {
			professores = professorFacade.getAll();
			return "success";
		} else {
			return "input";
		}
	}
	
	public String deletar() {
		if(professorFacade.delete(professor)) {
			return "success";
		} else {
			return "error";
		}
	}
	
	public String detalhar() {
		professor = professorFacade.get(professor);
	}
	
}
