package br.com.ebix.escola.action;

import java.util.List;

import com.opensymphony.xwork2.ActionSupport;

import br.com.ebix.escola.facade.AlunoFacade;
import br.com.ebix.escola.facade.AlunoFacadeImpl;
import br.com.ebix.escola.model.Aluno;


public class AlunosAction extends ActionSupport {
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

	public String listar() {
		alunos = alunoFacade.getAll();
		return SUCCESS;
	}
	
	public String detalhar() {
		aluno = alunoFacade.get(aluno);
		if(aluno != null) {
			return SUCCESS;
		} else {
			return ERROR;
		}
	}
	
	public String cadastrar() {
		if(alunoFacade.add(aluno)) {
			return SUCCESS;
		} else {
			return ERROR;
		}
	}
	
	public String alterar() {
		if(alunoFacade.update(aluno)) {
			return SUCCESS;
		} else {
			return ERROR;
		}
	}
	
	public String deletar() {
		if(alunoFacade.delete(aluno)) {
			return SUCCESS;
		} else {
			return ERROR;
		}
	}
	
}
