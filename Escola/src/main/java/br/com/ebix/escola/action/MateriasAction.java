package br.com.ebix.escola.action;

import java.util.List;

import com.opensymphony.xwork2.ActionSupport;

import br.com.ebix.escola.enums.AcoesValidacao;
import br.com.ebix.escola.facade.MateriaFacade;
import br.com.ebix.escola.facade.MateriaFacadeImpl;
import br.com.ebix.escola.model.Materia;

public class MateriasAction extends ActionSupport {
	private static final long serialVersionUID = 1L;

	private MateriaFacade materiaFacade = new MateriaFacadeImpl();
	private Materia materia = new Materia();

	private List<Materia> materias;

	public Materia getMateria() {
		return materia;
	}

	public void setMateria(Materia materia) {
		this.materia = materia;
	}

	public List<Materia> getMaterias() {
		return materias;
	}

	public void setMaterias(List<Materia> materias) {
		this.materias = materias;
	}

	public String listar() {
		materias = materiaFacade.getAll();
		return SUCCESS;
	}

	public String detalhar() {
		materia = materiaFacade.get(materia);
		if (materia != null) {
			return SUCCESS;
		} else {
			return ERROR;
		}
	}
	
	public String cadastrar() {
		List<AcoesValidacao> acoes = materiaFacade.add(materia);
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
		List<AcoesValidacao> acoes = materiaFacade.update(materia);
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
		AcoesValidacao acao = materiaFacade.delete(materia);
		if(acao == null) {
			return SUCCESS;
		} else {
			addFieldError(acao.getCampo(), acao.getMensagem());
			return INPUT;
		}
	}

}
