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

<title>Formulario - Atualizar professor</title>
</head>
<body>
	<div style="background-color: whitesmoke;">
		<div class="d-flex modal-header">
			<div style="flex: 1 1 auto;">
				<h3>Atualizar professor</h3>
			</div>
			<div style="align-self: center;">
				<a href="#"><i class="fas fa-times" aria-hidden="true"></i>
					Fechar</a>
			</div>
		</div>
		<div style="padding: 16px;">
			<s:form action="atualizar" method="post">
				<s:hidden name="cod_professor" value="%{cod_professor}" />
				
				<s:textfield name="nome" label="Nome" />
				<s:textfield name="cpf" label="Cpf" />
				<s:textfield name="dataNascimento" label="Data de nascimento" />
				<s:textfield name="email" label="Email" />
				<s:textfield name="telefoneCelular" label="Telefone celular" />
				<s:textfield name="telefoneResidencial" label="Telefone residencial" />

				<s:submit />
			</s:form>
		</div>
	</div>
</body>
</html>