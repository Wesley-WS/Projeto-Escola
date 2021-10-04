package br.com.ebix.escola.action;

import java.util.List;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import br.com.ebix.escola.facade.ProfessorFacadeImpl;
import br.com.ebix.escola.model.Professor;

public class ProfessoresAction extends ActionSupport /*implements ModelDriven<Object>*/ {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private ProfessorFacadeImpl professorFacadeImpl = new ProfessorFacadeImpl();
	
	
	
	private List<Professor> professores;

	//usando esse metodo a pagina jsp consegue pegar a lista da action
	public List<Professor> getProfessores() {
		return professores;
	}

	public String listar() {
		professores = professorFacadeImpl.getAll();
		return "success";
	}
	
	public String adicionar() {
		Professor professor = new Professor();
		if(professorFacadeImpl.add(professor)) {
			return "success";
		} else {
			return "error";
		}
	}
	
	public String remover() {		
		return "success";
	}
	
	/*@Override
	public Object getModel() {
		return (alunos == null) ? aluno : alunos;
	}*/
}
