package br.com.ebix.escola.action;

import java.util.List;

import org.apache.struts2.interceptor.validation.SkipValidation;

import com.opensymphony.xwork2.ActionSupport;

import br.com.ebix.escola.facade.AlunoFacade;
import br.com.ebix.escola.facade.AlunoFacadeImpl;
import br.com.ebix.escola.model.Aluno;


public class AlunosAction extends ActionSupport /*implements ModelDriven<Object>*/ {
	private static final long serialVersionUID = 1L;
	
	// @Autowired
	// private AlunoFacade alunoFacade;
	private AlunoFacade alunoFacade = new AlunoFacadeImpl();
	
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
		alunos = alunoFacade.getAll();
		return "success";
	}
	
	public String cadastrar() {
		if(alunoFacade.add(aluno)) {
			alunos = alunoFacade.getAll();
			return "success";
		} else {
			return "input";
		}
	}
	
	public String alterar() {
		if(alunoFacade.update(aluno)) {
			alunos = alunoFacade.getAll();
			return "success";
		} else {
			return "input";
		}
	}
	
	public String deletar() {
		if(alunoFacade.delete(aluno)) {
			return "success";
		} else {
			return "error";
		}
	}
	
}
