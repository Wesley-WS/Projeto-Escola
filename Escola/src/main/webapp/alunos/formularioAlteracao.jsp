<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@	taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sx" uri="/struts-dojo-tags"%>

<c:set var="context" value="${pageContext.request.contextPath}" />

<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<link rel="stylesheet" href="${context}/assets/css/styles.css">
	<link rel="stylesheet"
		href="https://use.fontawesome.com/releases/v5.15.4/css/all.css"
		integrity="sha384-DyZ88mC6Up2uqS4h/KRgHuoeGwBcD4Ng9SiP4dIRy0EXTlnuz47vAwmeGwVChigm"
		crossorigin="anonymous">
<script src="https://code.jquery.com/jquery-2.2.4.js" integrity="sha256-iT6Q9iMJYuQiMWNd9lDyBUStIq/8PuOW33aOqmvFpqI=" crossorigin="anonymous"></script>
<script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/jquery.mask/1.14.0/jquery.mask.js"></script>
<script type="text/javascript" src="${context}/assets/js/app.js"></script>
	<title>Formulario - Atualizar aluno</title>
</head>
<body>
	<div class="app">
		<s:include value="../components/sidebar.jspf"></s:include>
		<div class="body-wrapper">
			<div class="body">
				<div class="row">
					<div class="col">
						<h2>Atualizar aluno</h2>
						
						<s:form id="formularioPessoa" action="alterar" method="post">
							<s:hidden name="aluno.cod_aluno" value="%{aluno.cod_aluno}" />
							
							<div>
								<label>Nome</label><br />
								<input id="nome" type="text" name="aluno.nome" value="${aluno.nome }"/>
								<div id="mensagem-nome" style="display: none;">
									<small class="warning-message">#</small>
								</div>
							</div>
							<div>
								<label>Cpf</label><br />
								<input id="CPF" type="text" name="aluno.cpf" value="${aluno.cpf }"/>
								<div id="mensagem-cpf" style="display: none;">
									<small class="warning-message">#</small>
								</div>
							</div>
							<div>
								<label>Data de nascimento</label><br />
								<input id="dataNascimento" type="text" name="aluno.dataNascimento" value="<s:date name="aluno.dataNascimento" format="dd/MM/yyyy" />"/>							
								<div id="mensagem-dataNascimento" style="display: none;">
									<small class="warning-message">#</small>
								</div>
							</div>
							<div>
								<label>Email</label><br />
								<input id="email" type="email" name="aluno.email" value="${aluno.email }"/>
								<div id="mensagem-email" style="display: none;">
									<small class="warning-message">#</small>
								</div>
							</div>
							<div>
								<label>Telefone Celular</label><br />
								<input id="telCelular" type="text" name="aluno.telefoneCelular" value="${aluno.telefoneCelular }"/>
							</div>
							<div>
								<label>Telefone Residêncial</label><br />
								<input id="telResidencial" type="text" name="aluno.telefoneResidencial" value="${aluno.telefoneResidencial }"/>
							</div>
			
							<s:submit />
						</s:form>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>