import java.util.Calendar;

import br.com.ebix.escola.model.Aluno;
import br.com.ebix.escola.utils.ValidaEmail;
import br.com.ebix.escola.utils.ValidaStringUtil;

public class AppTestes {
	public static void main(String[] args) {
		Aluno aluno = new Aluno();
		aluno.setCod_aluno(1l);
		aluno.setCpf("1111");
		aluno.setDataNascimento(Calendar.getInstance());
		aluno.setEmail("email@gmail");
		aluno.setNome("Nome sla");
		aluno.setTelefoneCelular("12121212112");
		aluno.setTelefoneResidencial("333333");
		
		System.out.println(ValidaEmail.eUmEmailValido(aluno.getEmail()));
		System.out.println(validaPessoa(aluno));
	}
	
	public static boolean validaPessoa(Aluno aluno) {
		if((!ValidaEmail.eUmEmailValido(aluno.getEmail()) || ValidaStringUtil.eNuloVazioOuHaApenasEspaco(aluno.getEmail())) ||
			ValidaStringUtil.eNuloVazioOuHaApenasEspaco(aluno.getCod_aluno()) || 
			ValidaStringUtil.eNuloVazioOuHaApenasEspaco(aluno.getNome()) || 
			ValidaStringUtil.eNuloVazioOuHaApenasEspaco(aluno.getCpf()) ||
			ValidaStringUtil.eNuloVazioOuHaApenasEspaco(aluno.getDataNascimento())) {
			return false;
		} else {
			return true;
		}
		/*if(ValidaStringUtil.eNuloVazioOuHaApenasEspaco(aluno.getCod_aluno()) || 
				ValidaStringUtil.eNuloVazioOuHaApenasEspaco(aluno.getNome()) || 
				ValidaStringUtil.eNuloVazioOuHaApenasEspaco(aluno.getCpf()) || 
				ValidaStringUtil.eNuloVazioOuHaApenasEspaco(aluno.getEmail()) && ValidaEmail.eUmEmailValido(aluno.getEmail()) || 
				ValidaStringUtil.eNuloVazioOuHaApenasEspaco(aluno.getDataNascimento())) {
			return false;
		} else {
			return true;
		}*/
	}
}
