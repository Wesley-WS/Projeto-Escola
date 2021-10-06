package br.com.ebix.escola.action;

import java.util.Calendar;
import java.util.List;

import org.apache.struts2.interceptor.validation.SkipValidation;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import br.com.ebix.escola.facade.ProfessorFacadeImpl;
import br.com.ebix.escola.model.Aluno;
import br.com.ebix.escola.model.Professor;

public class ProfessoresAction extends ActionSupport /*implements ModelDriven<Object>*/ {
	private static final long serialVersionUID = 1L;
	private ProfessorFacadeImpl professorFacadeImpl = new ProfessorFacadeImpl();
	private List<Professor> professores;
	private Professor professor = new Professor();


	public List<Professor> getProfessores() {
		return professores;
	}
	
	@SkipValidation
	public String listar() {
		professores = professorFacadeImpl.getAll();
		return "success";
	}
	
	public String cadastrar() {
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
	public String alterar() {
		Professor professor = new Professor();
		professor.setCod_professor(cod_professor);
		professor.setNome(nome);
		professor.setCpf(cpf);
		professor.setEmail(email);
		professor.setTelefoneCelular(telefoneCelular);
		professor.setTelefoneResidencial(telefoneResidencial);
		professor.setDataNascimento(dataNascimento);
		
		if(professorFacadeImpl.update(professor)) {
			professores = professorFacadeImpl.getAll();
			return "success";
		} else {
			return "error";
		}
	}
	
	public String deletar() {
		Professor professor = new Professor();
		professor.setCod_professor(cod_professor);
		
		if(professorFacadeImpl.delete(professor)) {
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