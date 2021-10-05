package br.com.ebix.escola.action;

import java.util.ArrayList;
import java.util.List;

import org.apache.struts2.interceptor.validation.SkipValidation;

import com.opensymphony.xwork2.ActionSupport;

import br.com.ebix.escola.facade.MateriaFacadeImpl;
import br.com.ebix.escola.model.Materia;

public class MateriasAction extends ActionSupport /*implements ModelDriven<Object>*/ {
	private static final long serialVersionUID = 1L;
	
	private MateriaFacadeImpl materiaFacadeImpl = new MateriaFacadeImpl();
	
	private Long cod_materia;
	private String nome;
	private String sigla;
	
	private List<Materia> materias;
	
	public void setCod_materia(Long cod_materia) {
		this.cod_materia = cod_materia;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setSigla(String sigla) {
		this.sigla = sigla;
	}

	public List<Materia> getMaterias() {
		return materias;
	}
	
	@SkipValidation
	public String listar() {
		materias = materiaFacadeImpl.getAll();
		return "success";
	}

	public String adicionar() {
		Materia materia = new Materia();
		materia.setNome(nome);
		materia.setSigla(sigla);
		
		if(materiaFacadeImpl.add(materia)) {
			materias = materiaFacadeImpl.getAll();
			return "success";
		}else {
			return "input";
		}
	}
	
	public String atualizar() {
		Materia materia = new Materia();
		materia.setCod_materia(cod_materia);
		materia.setNome(nome);
		materia.setSigla(sigla);
		System.out.println(materia.getCod_materia());
		
		if(materiaFacadeImpl.update(materia)) {
			materias = materiaFacadeImpl.getAll();
			return "success";
		}else {
			return "input";
		}
	}

	public String remover() {
		Materia materia = new Materia();
		materia.setCod_materia(cod_materia);
		
		if(materiaFacadeImpl.delete(materia)) {
			return "success";
		}else {
			return "error";
		}
	}
	
	/*@Override
	public Object getModel() {
		return materias;
	}*/
}
