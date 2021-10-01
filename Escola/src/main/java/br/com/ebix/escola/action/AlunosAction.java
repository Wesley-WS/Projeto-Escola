package br.com.ebix.escola.action;

import java.util.List;

import com.opensymphony.xwork2.ActionSupport;

import br.com.ebix.escola.facade.AlunoFacadeImpl;
import br.com.ebix.escola.model.Aluno;

public class AlunosAction extends ActionSupport /*implements ModelDriven<Object>*/ {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private AlunoFacadeImpl alunoFacadeImpl = new AlunoFacadeImpl();
	
	// private Aluno aluno = new Aluno();
	
	private List<Aluno> alunos;

	//usando esse metodo a pagina jsp consegue pegar a lista da action
	public List<Aluno> getAlunos() {
		return alunos;
	}

	public String listar() {
		alunos = alunoFacadeImpl.getAll();
		return "success";
	}
	
	public String adicionar() {
		Aluno aluno = new Aluno();
		
		if(alunoFacadeImpl.add(aluno)) {
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
