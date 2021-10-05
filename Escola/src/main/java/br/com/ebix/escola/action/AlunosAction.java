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
	private Long cod_aluno;
	private String nome;
	private String cpf;
	private String email;
	private String telefoneCelular;
	private String telefoneResidencial;
	private Calendar dataNascimento;	
	
	private List<Aluno> alunos;
	
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
	
	public List<Aluno> getAlunos() {
		return alunos;
	}

	@SkipValidation
	public String execute() {
		if(cod_aluno != null) {
			System.out.println(cod_aluno);
			
			/*Aluno aluno = new Aluno();
			setCod_aluno(aluno.getCod_aluno());
			setNome(aluno.getNome());*/
		}
		
		// Aluno aluno = alunoFacadeImpl.getByCodAluno(cod_aluno);
		
		return "success";
	}
	
	public String listar() {
		alunos = alunoFacadeImpl.getAll();
		return "success";
	}

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
			return "input";
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
		System.out.println(aluno.getCod_aluno());
		
		if(alunoFacadeImpl.update(aluno)) {
			alunos = alunoFacadeImpl.getAll();
			return "success";
		} else {
			return "input";
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
