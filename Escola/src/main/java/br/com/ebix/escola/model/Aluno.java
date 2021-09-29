package br.com.ebix.escola.model;

public class Aluno {
	private long cod_aluno;
	private String nome;
	private long cod_materia;
	
	public Aluno() {
		
	}
	
	public Aluno(String nome, long cod_materia) {
		this.nome = nome;
		this.cod_materia = cod_materia;
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

	public long getCod_materia() {
		return cod_materia;
	}

	public void setCod_materia(long cod_materia) {
		this.cod_materia = cod_materia;
	}
	
}
