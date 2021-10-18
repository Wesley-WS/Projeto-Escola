$(document).ready(() => {
	carregarMascaras();
	
	$("#formularioPessoa").submit(function() {
		let { mensagemNome, mensagemCpf, mensagemDataNascimento, mensagemEmail } = obterMensagemPessoa();
		let { nome, cpf, dataNascimento, email } = obterCamposPessoa();
		let eValido = true;
		
		if(!nome.val()) {
			showMessage("Campo em branco", mensagemNome);
			eValido = false;
		} else if(nome.val().length > 100) {
			showMessage("Minimo de 100 characters", mensagemNome);
			eValido = false;
		}
		if(!cpf.val()) {
			showMessage("Cpf em branco", mensagemCpf);
			eValido = false;
		}
		if(!dataNascimento.val()) {
			showMessage("Data de nascimento em branco", mensagemDataNascimento);
			eValido = false;
		}
		if(!email.val()) {
			showMessage("Email em branco", mensagemEmail);
			eValido = false;
		} else if(email.val().length > 100) {
			showMessage("Minimo de 100 characters", mensagemEmail);
			eValido = false;
		}
		
		return eValido;
	});
	
	$("#formularioMateria").submit(function() {
		let { nome, sigla } = obterCamposMateria();
		let { mensagemNome, mensagemSigla } = obterMensagemMateria();
		let eValido = true;
		
		if(!nome.val()) {
			showMessage("Nome em branco", mensagemNome);
			eValido = false;
		}
		if(!sigla.val()) {
			showMessage("Sigla em branco", mensagemSigla);
			eValido = false;
		}else if (sigla.val().length > 5){
			showMessage("Minimo de 5 characters", mensagemSigla);
			eValido = false;
		}
		
		return eValido;
	})
})

function obterCamposPessoa() {
	return {
		nome: $("#nome"),
		cpf: $("#CPF"),
		email: $("#email"),
		telCelular: $("#telCelular"),
		telResidencial: $("#telResidencial"),
		dataNascimento: $("#dataNascimento")
	}
}

function obterMensagemPessoa() {
	return {
		mensagemNome: $('#mensagem-nome'),
		mensagemCpf: $('#mensagem-cpf'),
		mensagemDataNascimento: $('#mensagem-dataNascimento'),
		mensagemEmail: $('#mensagem-email')
	}
}

function obterCamposMateria() {
	return {
		nome: $("#nome"),
		sigla: $("#sigla")
	}
}

function obterMensagemMateria(){
	return {
		mensagemNome: $('#mensagem-nome'),
		mensagemSigla: $('#mensagem-sigla'),
	}
}

function carregarMascaras() {
	let { cpf, telCelular, telResidencial, dataNascimento } = obterCamposPessoa();
		
	cpf.mask('000.000.000-00', {reverse: false});
	telCelular.mask('(00)00000-0000', {reverse: false});
	telResidencial.mask('(00)0000-0000', {reverse: false});
	dataNascimento.mask('00/00/0000', {reverse: true});
}

function showMessage(mensagem, elem){
	elem.show();
	elem.html(`<small class='warning-message'>${mensagem}</small>`);
	setTimeout(function() {
	    elem.fadeOut('slow');
	}, 5000);
}

/*function validarCadastro() {
	const nome = $("#nome").val(),
		cpf = $("#cpf").val(),
		dataNascimento = $("#dataNascimento").val(),
		email = $("#email").val(),
		telefoneCelular =$("#telefoneCelular").val(),
		telefoneResidencial = $("#telefoneResidencial").val();

	if(nomeEInvalido(nome) 
		|| cpfEInvalido(cpf)
		|| dataNascimentoEInvalida(dataNascimento)
		|| emailEInvalido(email)
		|| telefoneCelularEInvalido(telefoneCelular)
		|| telefoneResidencialEInvalido(telefoneResidencial)) return false;
	
	console.log(nome, cpf, dataNascimento, email, telefoneCelular, telefoneResidencial);
	
	return false;
}

function nomeEInvalido(nome) {
	if(nome) {
		return (nome.length > 100);
	} else {
		return true;
	}
}

function cpfEInvalido(cpf) {
	if(cpf) {
		return !/[0-9]{3}.[0-9]{3}.[0-9]{3}-[0-9]{2}/.test(cpf);
	} else {
		return true;
	}
}

function dataNascimentoEInvalida(dataNascimento) {
	if(dataNascimento) {
		return !/[0-9]{2}\/[0-9]{2}\/[0-9]{4}/.test(dataNascimento);	
	} else {
		return true;
	}
}

function emailEInvalido(email) {
	if(email) {
		return !/^(([^<>()[\]\\.,;:\s@\"]+(\.[^<>()[\]\\.,;:\s@\"]+)*)|(\".+\"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/.test(email);
	} else {
		return true;
	}
}

function telefoneCelularEInvalido(telefoneCelular) {
	if(telefoneCelular) {
		console.log('a cel')
		return !/\([0-9]{2}\)[0-9]{5}-[0-9]{4}/.test(telefoneCelular);
	} else {
		console.log('ok cel')
		return false;
	}
}

function telefoneResidencialEInvalido(telefoneResidencial) {
	if(telefoneResidencial) {
		return !/\([0-9]{2}\)[0-9]{4}-[0-9]{4}/.test(telefoneResidencial);
	} else {
		return false;
	}
}*/
