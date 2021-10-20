package br.com.ebix.escola.facade;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import br.com.ebix.escola.dao.AlunoDao;
import br.com.ebix.escola.dao.AlunoDaoImpl;
import br.com.ebix.escola.enums.AcoesValidacao;
import br.com.ebix.escola.model.Aluno;
import br.com.ebix.escola.model.Materia;
import br.com.ebix.escola.utils.ValidaCpf;
import br.com.ebix.escola.utils.ValidaDataUtil;
import br.com.ebix.escola.utils.ValidaEmail;
import br.com.ebix.escola.utils.ValidaStringUtil;
import br.com.ebix.escola.utils.ValidaTelefoneUtil;

public class AlunoFacadeImpl implements AlunoFacade {

	// @Autowired
	// private AlunoDao alunoDao;

	private AlunoDao alunoDao = new AlunoDaoImpl();

	@Override
	public Aluno get(Aluno aluno) {
		if(codigoEstaInvalido(aluno)) {
			return null;
		} else {
			Optional<Aluno> alunoObtido = alunoDao.get(aluno);
			
			if(alunoObtido.isPresent()) {
				return alunoObtido.get();
			} else {
				return null;
			}
		}
	}

	@Override
	public List<Aluno> getAll() {
		return alunoDao.getAll();
	}
	
	public List<Materia> getAllMateriasByCodAluno(Aluno aluno){
		List<Long> cod_materias = alunoDao.getAllCodMatByCod(aluno);
		List<Materia> materias = new ArrayList<Materia>();
		
		if(cod_materias.size() > 0) {
			for(Long cod_materia : cod_materias) {
				materias.add(alunoDao.getAllMatByCod(cod_materia));
			}
			
			return materias;
		} else {
			return materias;
		}
		
	}

	@Override
	public List<AcoesValidacao> add(Aluno aluno) {
		List<AcoesValidacao> acoes = dadosEstaoInvalidos(aluno);
		if(cpfJaExiste(aluno)) {
			acoes.add(AcoesValidacao.CPFEXISTENTE);
		}
		
		if(acoes.size() == 0) {
			alunoDao.add(aluno);
		}
		return acoes;

	}

	@Override
	public List<AcoesValidacao> update(Aluno aluno) {
		List<AcoesValidacao> acoes = dadosEstaoInvalidos(aluno);
		if(codigoEstaInvalido(aluno)) {
			acoes.add(AcoesValidacao.CODIGOINVALIDO);
		}
		if(updateCpfJaExiste(aluno)) {
			acoes.add(AcoesValidacao.CPFEXISTENTE);
		}
		
		if(acoes.size() == 0) {
			alunoDao.update(aluno);
		}
		return acoes;
	}

	@Override
	public AcoesValidacao delete(Aluno aluno) {
		AcoesValidacao acao = null;
		if (codigoEstaInvalido(aluno)) {
			acao = AcoesValidacao.CODIGOINVALIDO;
		} else {
			alunoDao.delete(aluno);
		}
		return acao;

	}

	public boolean naoEstaEmIdadeEscolar(Aluno aluno) {
		return (aluno.obterIdade() <= 4);
	}
	
	public boolean codigoEstaInvalido(Aluno aluno) {
		return (ValidaStringUtil.eNuloVazioOuHaApenasEspaco(aluno.getCod_aluno()));
	}

	public List<AcoesValidacao> dadosEstaoInvalidos(Aluno aluno) {
		List<AcoesValidacao> campos = new ArrayList<AcoesValidacao>();
		
		if(ValidaStringUtil.eNuloVazioOuHaApenasEspaco(aluno.getNome())) {
			campos.add(AcoesValidacao.NOMEEMBRANCO);
		} else {
			if(aluno.getNome().length() > 100) {
				campos.add(AcoesValidacao.NOMEMINIMOCHAREXCEDIDO);
			}
		}
		if(ValidaStringUtil.eNuloVazioOuHaApenasEspaco(aluno.getCpf())) {
			campos.add(AcoesValidacao.CPFEMBRANCO);
		} else {
			if(ValidaCpf.cpfEInvalido(aluno.getCpf())) {
				campos.add(AcoesValidacao.CPFINVALIDO);
			}
		}
		if(ValidaStringUtil.eNuloVazioOuHaApenasEspaco(aluno.getEmail())) {
			campos.add(AcoesValidacao.EMAILEMBRANCO);
		} else {
			if (ValidaEmail.eUmEmailInvalido(aluno.getEmail())) {
				campos.add(AcoesValidacao.EMAILINVALIDO);
			}
		}
		if(!ValidaStringUtil.eNuloVazioOuHaApenasEspaco(aluno.getTelefoneCelular())) {
			if(ValidaTelefoneUtil.eUmNumeroDeCelularInvalido(aluno.getTelefoneCelular())) {
				campos.add(AcoesValidacao.TELEFONECELULARINVALIDO);
			}
		}
		if(!ValidaStringUtil.eNuloVazioOuHaApenasEspaco(aluno.getTelefoneResidencial())) {
			if(ValidaTelefoneUtil.eUmNumeroResidencialInvalido(aluno.getTelefoneResidencial())) {
				campos.add(AcoesValidacao.TELEFONERESIDENCIALINVALIDO);
			}
		}
		if(ValidaStringUtil.eNuloVazioOuHaApenasEspaco(aluno.getDataNascimento())) {
			campos.add(AcoesValidacao.DATANASCIMENTOEMBRANCO);
		} else {
			if(ValidaDataUtil.eUmaDataInvalida(aluno.getDataNascimento())) {
				campos.add(AcoesValidacao.DATANASCIMENTOINVALIDA);
			} else {
				if(naoEstaEmIdadeEscolar(aluno)) {
					campos.add(AcoesValidacao.DATANASCIMENTOINVALIDAALUNO);
				}
			}
		}
		
		return campos;
	}
	
	public boolean cpfJaExiste(Aluno aluno) {
		return alunoDao.cpfCadastrado(aluno);
	}
	
	public boolean updateCpfJaExiste(Aluno aluno) {
		String cpfDigitado = aluno.getCpf();
		Optional<Aluno> alunoObtido = alunoDao.get(aluno);
		if(!alunoObtido.isPresent()) {
			return false;
		}
		if(cpfDigitado.equals(alunoObtido.get().getCpf())) {
			return false;
		}else {
			return alunoDao.cpfCadastrado(aluno);
		}
		
	}
}
