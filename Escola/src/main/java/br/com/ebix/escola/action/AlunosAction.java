package br.com.ebix.escola.action;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import br.com.ebix.escola.dao.AlunoDao;
import br.com.ebix.escola.dao.ConectionFactory;
import br.com.ebix.escola.model.Aluno;

public class AlunosAction extends ActionSupport implements ModelDriven<Object> {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Aluno aluno = new Aluno();
	private List<Aluno> alunos = new ArrayList<Aluno>();
	
	public String listar() {
		Connection connection = new ConectionFactory().getConnection();
		AlunoDao alunoDao = new AlunoDao(connection);
		alunos = alunoDao.obterAlunos();
		return "success";
	}
	
	public String adicionar() {
		// alunoDao.adicionar(aluno);
		return "success";
	}
	
	public String remover() {
		// alunoDao.remover(aluno);
		return "success";
	}
	
	@Override
	public Object getModel() {
		return alunos;
	}
}
