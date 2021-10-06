package br.com.ebix.escola.action;

import java.util.List;

import org.apache.struts2.interceptor.validation.SkipValidation;

import com.opensymphony.xwork2.ActionSupport;

import br.com.ebix.escola.facade.ProfessorFacadeImpl;
import br.com.ebix.escola.model.Professor;

public class ProfessoresAction extends ActionSupport {
	private static final long serialVersionUID = 1L;
	private ProfessorFacadeImpl professorFacadeImpl = new ProfessorFacadeImpl();
	private List<Professor> professores;
	private Professor professor = new Professor();
	
	public Professor getProfessor() {
		return professor;
	}

	public void setProfessor(Professor professor) {
		this.professor = professor;
	}

	public void setProfessores(List<Professor> professores) {
		this.professores = professores;
	}

	public List<Professor> getProfessores() {
		return professores;
	}
	
	@SkipValidation
	public String listar() {
		professores = professorFacadeImpl.getAll();
		return "success";
	}
	
	public String cadastrar() {		
		if(professorFacadeImpl.add(professor)) {
			//professores = professorFacadeImpl.getAll();
			return "success";
		} else {
			return "error";
		}
	}
	public String alterar() {
		if(professorFacadeImpl.update(professor)) {
			//professores = professorFacadeImpl.getAll();
			return "success";
		} else {
			return "error";
		}
	}
	
	public String deletar() {
		if(professorFacadeImpl.delete(professor)) {
			return "success";
		} else {
			return "error";
		}
	}
	
}
