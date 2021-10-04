package br.com.ebix.escola.action;

import java.util.Calendar;
import java.util.List;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import br.com.ebix.escola.facade.ProfessorFacadeImpl;
import br.com.ebix.escola.model.Aluno;
import br.com.ebix.escola.model.Professor;

public class ProfessoresAction extends ActionSupport /*implements ModelDriven<Object>*/ {
	private static final long serialVersionUID = 1L;
	private ProfessorFacadeImpl professorFacadeImpl = new ProfessorFacadeImpl();
	private List<Professor> professores;
	
	private String nome;
	private String cpf;
	private String email;
	private String telefoneCelular;
	private String telefoneResidencial;
	private Calendar dataNascimento;
	

	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setTelefoneCelular(String telefoneCelular) {
		this.telefoneCelular = telefoneCelular;
	}

	public void setTelefoneResidencial(String telefoneResidencial) {
		this.telefoneResidencial = telefoneResidencial;
	}

	public void setDataNascimento(Calendar dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

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
		professor.setNome(nome);
		professor.setCpf(cpf);
		professor.setEmail(email);
		professor.setTelefoneCelular(telefoneCelular);
		professor.setTelefoneResidencial(telefoneResidencial);
		professor.setDataNascimento(dataNascimento);
		
		if(professorFacadeImpl.add(professor)) {
			professores = professorFacadeImpl.getAll();
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
