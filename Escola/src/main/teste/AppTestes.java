import java.util.Calendar;

import br.com.ebix.escola.model.Aluno;
import br.com.ebix.escola.utils.ValidaCpf;
import br.com.ebix.escola.utils.ValidaDataUtil;
import br.com.ebix.escola.utils.ValidaEmail;
import br.com.ebix.escola.utils.ValidaStringUtil;

public class AppTestes {
	public static void main(String[] args) {
		Calendar calendar = Calendar.getInstance();
		calendar.set(Calendar.YEAR, 2030);
		
		Aluno aluno = new Aluno();
		aluno.setCod_aluno(1l);
		aluno.setCpf("360.832.503-40");
		aluno.setDataNascimento(calendar);
		aluno.setEmail("email@gmail.com");
		aluno.setNome("Nome sla");
		aluno.setTelefoneCelular("12121212112");
		aluno.setTelefoneResidencial("333333");
		
		/*System.out.println(ValidaEmail.eUmEmailInvalido(aluno.getEmail()));
		System.out.println(ValidaDataUtil.eUmaDataInvalida(aluno.getDataNascimento()));
		System.out.println(ValidaCpf.cpfEInvalido(aluno.getCpf()));*/
		
		System.out.println(dadosEstaoInvalidos(aluno));
	}

	public static boolean dadosEstaoInvalidos(Aluno aluno) {
		return (ValidaEmail.eUmEmailInvalido(aluno.getEmail())
				|| ValidaDataUtil.eUmaDataInvalida(aluno.getDataNascimento())
				|| ValidaCpf.cpfEInvalido(aluno.getCpf())
				|| ValidaStringUtil.eNuloVazioOuHaApenasEspaco(aluno.getEmail())
				|| ValidaStringUtil.eNuloVazioOuHaApenasEspaco(aluno.getNome())
				|| ValidaStringUtil.eNuloVazioOuHaApenasEspaco(aluno.getCpf())
				|| ValidaStringUtil.eNuloVazioOuHaApenasEspaco(aluno.getDataNascimento()));
	}

}
