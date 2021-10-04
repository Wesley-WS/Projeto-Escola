package br.com.ebix.escola.action;

import java.util.Calendar;
import java.util.List;

import com.opensymphony.xwork2.ActionSupport;

import br.com.ebix.escola.facade.AlunoFacadeImpl;
import br.com.ebix.escola.model.Aluno;

public class AlunosAction extends ActionSupport /*implements ModelDriven<Object>*/ {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Long cod_aluno;
	private String nome;
	private String cpf;
	private String email;
	private String telefoneCelular;
	private String telefoneResidencial;
	private Calendar dataNascimento;	
	
	public Long getCod_aluno() {
		return cod_aluno;
	}

	public void setCod_aluno(Long cod_aluno) {
		this.cod_aluno = cod_aluno;
	}

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

	private List<Aluno> alunos;
	
	public List<Aluno> getAlunos() {
		return alunos;
	}

	public String listar() {
		alunos = alunoFacadeImpl.getAll();
		return "success";
	}
	
	private AlunoFacadeImpl alunoFacadeImpl = new AlunoFacadeImpl();

	public String adicionar() {
		Aluno aluno = new Aluno();
		aluno.setNome(nome);
		aluno.setCpf(cpf);
		aluno.setEmail(email);
		aluno.setTelefoneCelular(telefoneCelular);
		aluno.setTelefoneResidencial(telefoneResidencial);
		aluno.setDataNascimento(dataNascimento);
		
		if(alunoFacadeImpl.add(aluno)) {
			alunos = alunoFacadeImpl.getAll();
			return "success";
		} else {
			return "error";
		}
	}
	
	public String atualizar() {
		Aluno aluno = new Aluno();
		aluno.setCod_aluno(cod_aluno);
		aluno.setNome(nome);
		aluno.setCpf(cpf);
		aluno.setEmail(email);
		aluno.setTelefoneCelular(telefoneCelular);
		aluno.setTelefoneResidencial(telefoneResidencial);
		aluno.setDataNascimento(dataNascimento);
		
		if(alunoFacadeImpl.update(aluno)) {
			alunos = alunoFacadeImpl.getAll();
			return "success";
		} else {
			return "error";
		}
	}
	
	public String remover() {
		Aluno aluno = new Aluno();
		aluno.setCod_aluno(cod_aluno);
		
		if(alunoFacadeImpl.delete(aluno)) {
			return "success";
		} else {
			return "error";
		}
	}
	
	/*@Override
	public Object getModel() {
		return (alunos == null) ? aluno : alunos;
	}*/
}
