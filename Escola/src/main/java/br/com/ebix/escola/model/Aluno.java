package br.com.ebix.escola.model;

import java.util.Calendar;

public class Aluno {
	private long cod_aluno;
	private String nome;
	private String cpf;
	private String email;
	private Calendar dataNascimento;

	public Aluno() {

	}

	public Aluno(String nome) {
		this.nome = nome;
	}

	public long getCod_aluno() {
		return cod_aluno;
	}

	public void setCod_aluno(long cod_aluno) {
		this.cod_aluno = cod_aluno;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Calendar getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(Calendar dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

}
