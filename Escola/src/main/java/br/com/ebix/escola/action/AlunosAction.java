package br.com.ebix.escola.action;

import java.util.List;

import com.opensymphony.xwork2.ActionSupport;

import br.com.ebix.escola.enums.AcoesValidacao;
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
		List<AcoesValidacao> acoes = alunoFacade.add(aluno);
		if(acoes.size() > 0) {
			for (AcoesValidacao acao : acoes) {
				addFieldError(acao.getCampo(), acao.getMensagem());
			}
			return INPUT;
		} else {
			return SUCCESS;
		}
	}
	
	public String alterar() {
		List<AcoesValidacao> acoes = alunoFacade.update(aluno);
		if(acoes.size() > 0) {
			for (AcoesValidacao acao : acoes) {
				addFieldError(acao.getCampo(), acao.getMensagem());
			}
			return INPUT;
		} else {
			return SUCCESS;
		}
	}
	
	public String deletar() {
		AcoesValidacao acao = alunoFacade.delete(aluno);
		if(acao == null) {
			return SUCCESS;
		} else {
			addFieldError(acao.getCampo(), acao.getMensagem());
			return INPUT;
		}
	}
	
}
