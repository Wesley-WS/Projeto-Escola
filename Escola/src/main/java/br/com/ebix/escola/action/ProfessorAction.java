package br.com.ebix.escola.action;

import java.util.List;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class ProfessorAction extends ActionSupport /*implements ModelDriven<Object>*/ {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private ProfessorFacadeImpl professorFacadeImpl = new ProfessorFacadeImpl();
	
	
	
	private List<Professor> professores;

	//usando esse metodo a pagina jsp consegue pegar a lista da action
	public List<Professor> getProfessores() {
		return Professores;
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
