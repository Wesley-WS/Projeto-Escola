package br.com.ebix.escola.action;

import java.text.ParseException;
import java.util.List;

import com.opensymphony.xwork2.ActionSupport;

import br.com.ebix.escola.enums.AcoesValidacao;
import br.com.ebix.escola.facade.MateriaFacade;
import br.com.ebix.escola.facade.MateriaFacadeImpl;
import br.com.ebix.escola.facade.ProfessorFacade;
import br.com.ebix.escola.facade.ProfessorFacadeImpl;
import br.com.ebix.escola.model.Materia;
import br.com.ebix.escola.model.Professor;

public class ProfessoresAction extends ActionSupport {
	private static final long serialVersionUID = 1L;

	private ProfessorFacade professorFacade = new ProfessorFacadeImpl();
	private MateriaFacade materiaFacade = new MateriaFacadeImpl();

	private Professor professor = new Professor();
	private Materia materia = new Materia();

	private List<Professor> professores;
	private List<Materia> materias;
	
	private String[] materiasSelecionadas;

	public String listar() {
		professores = professorFacade.getAll();
		return SUCCESS;
	}

	public String listarMateriasDisponiveis() {
		materias = materiaFacade.getAllAvaiable();
		return SUCCESS;
	}

	public String detalhar() {
		professor = professorFacade.get(professor);
		if (professor != null) {
			return SUCCESS;
		} else {
			return ERROR;
		}
	}

	public String associar() {
		for (String cod_materia : materiasSelecionadas) {
			Long cod_materiaLong = Long.parseLong(cod_materia);
			
			Materia materia = new Materia();
			materia.setCod_materia(cod_materiaLong);
	
			Materia materiaObtida = materiaFacade.get(materia);
			materiaObtida.setCod_materia(cod_materiaLong);
			materiaObtida.setCod_professor(professor.getCod_professor());
			materiaFacade.update(materiaObtida);
		}
		return SUCCESS;
	}

	public String cadastrar() {
		List<AcoesValidacao> acoes = professorFacade.add(professor);
		if (acoes.size() > 0) {
			for (AcoesValidacao acao : acoes) {
				addFieldError(acao.getCampo(), acao.getMensagem());
			}
			return INPUT;
		} else {
			return SUCCESS;
		}
	}

	public String alterar() {
		List<AcoesValidacao> acoes = professorFacade.update(professor);
		if (acoes.size() > 0) {
			for (AcoesValidacao acao : acoes) {
				addFieldError(acao.getCampo(), acao.getMensagem());
			}
			return INPUT;
		} else {
			return SUCCESS;
		}
	}

	public String deletar() {
		AcoesValidacao acao = professorFacade.delete(professor);
		if (acao == null) {
			return SUCCESS;
		} else {
			return INPUT;
		}
	}

	public Professor getProfessor() {
		return professor;
	}

	public void setProfessor(Professor professor) {
		this.professor = professor;
	}

	public Materia getMateria() {
		return materia;
	}

	public void setMateria(Materia materia) {
		this.materia = materia;
	}

	public List<Professor> getProfessores() {
		return professores;
	}

	public void setProfessores(List<Professor> professores) {
		this.professores = professores;
	}

	public List<Materia> getMaterias() {
		return materias;
	}

	public void setMaterias(List<Materia> materias) {
		this.materias = materias;
	}
	
	public String[] getMateriasSelecionadas() {
		return materiasSelecionadas;
	}

	public void setMateriasSelecionadas(String[] materiasSelecionadas) {
		this.materiasSelecionadas = materiasSelecionadas;
	}
}
