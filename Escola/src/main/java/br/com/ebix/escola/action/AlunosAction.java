package br.com.ebix.escola.action;

import java.util.Calendar;
import java.util.List;

import org.apache.struts2.interceptor.validation.SkipValidation;

import com.opensymphony.xwork2.ActionSupport;

import br.com.ebix.escola.facade.AlunoFacadeImpl;
import br.com.ebix.escola.model.Aluno;

public class AlunosAction extends ActionSupport /*implements ModelDriven<Object>*/ {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private AlunoFacadeImpl alunoFacadeImpl = new AlunoFacadeImpl();
	
	private Aluno aluno = new Aluno();

	private List<Aluno> alunos;

	public Aluno getAluno() {
		return aluno;
	}

	public void setAluno(Aluno aluno) {
		this.aluno = aluno;
	}
	
	public List<Aluno> getAlunos() {
		return alunos;
	}

	public void setAlunos(List<Aluno> alunos) {
		this.alunos = alunos;
	}

	@SkipValidation
	public String listar() {
		alunos = alunoFacadeImpl.getAll();
		return "success";
	}
	
	@SkipValidation
	public String adicionar() {
		if(alunoFacadeImpl.add(aluno)) {
			alunos = alunoFacadeImpl.getAll();
			return "success";
		} else {
			return "input";
		}
	}
	
	@SkipValidation
	public String atualizar() {
		if(alunoFacadeImpl.update(aluno)) {
			alunos = alunoFacadeImpl.getAll();
			return "success";
		} else {
			return "input";
		}
	}
	
	@SkipValidation
	public String remover() {
		if(alunoFacadeImpl.delete(aluno)) {
			return "success";
		} else {
			return "error";
		}
	}
	
}
