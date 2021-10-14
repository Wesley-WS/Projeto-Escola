$(document).ready(() => {
	carregarMascaras();
	
	$("#formularioPessoa").submit(function() {
		let { nome, cpf, telCelular, telResidencial, data } = obterCamposPessoa();
		let eValido = true;
		
		if(!nome) {
			// Faça aparecer uma mensagem de campo em branco
			eValido = false;
		}
		if(!cpf) {
			// Faça aparecer uma mensagem de campo em branco
			eValido = false;
		}
		if(!telCelular) {
			// Faça aparecer uma mensagem de campo em branco
			eValido = false;
		}
		if(!telResidencial) {
			// Faça aparecer uma mensagem de campo em branco
			eValido = false;
		}
		if(!data) {
			// Faça aparecer uma mensagem de campo em branco
			eValido = false;
		}
		
		return eValido;
	});
	
	$("#formularioMateria").submit(function() {
		let { nome, sigla } = obterCamposMateria();
		let eValido = true;
		
		if(!nome) {
			// Faça aparecer uma mensagem de campo em branco
			eValido = false;
		}
		if(!sigla) {
			// Faça aparecer uma mensagem de campo em branco
			eValido = false;
		}
		
		return eValido;
	})
})

function obterCamposPessoa() {
	return {
		nome: $("#nome"),
		cpf: $("#CPF"),
		telCelular: $("#telcelular"),
		telResidencial: $("#telresidencial"),
		data: $("#data")
	}
}

function obterCamposMateria() {
	return {
		nome: $("#nome"),
		sigla: $("#sigla")
	}
}

function carregarMascaras() {
	let { cpf, telCelular, telResidencial, data } = obterCamposPessoa();
		
	cpf.mask('000.000.000-00', {reverse: true});
	telCelular.mask('(00)00000-0000', {reverse: false});
	telResidencial.mask('(00)0000-0000', {reverse: false});
	data.mask('00/00/0000', {reverse: true});
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
