package br.com.ebix.escola.action;

import java.util.List;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import br.com.ebix.escola.dao.AlunoDaoImpl;
import br.com.ebix.escola.model.Aluno;

public class AlunosAction extends ActionSupport implements ModelDriven<Object> {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Aluno aluno = new Aluno();
	private List<Aluno> alunos;

	public String listar() {
		AlunoDaoImpl alunoDao = new AlunoDaoImpl();
		alunos = alunoDao.getAll();
		
		return "success";
	}
	
	public String adicionar() {
		// alunoDao.adicionar(aluno);
		return "success";
	}
	
	public String remover() {
		AlunoDaoImpl alunoDao = new AlunoDaoImpl();
		alunoDao.delete(aluno);
		System.out.println(aluno.getCod_aluno());
		
		return "success";
	}
	
	@Override
	public Object getModel() {
		return (alunos == null) ? aluno : alunos;
	}
}
