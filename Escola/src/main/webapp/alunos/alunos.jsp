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
<script src="https://kit.fontawesome.com/6697f5eca6.js"
	crossorigin="anonymous"></script>
<title>Alunos</title>
</head>
<body>
	<h1>Alunos</h1>
	<div class="d-flex content">
		<s:form action="adicionar" method="post">
			<s:textfield name="nome" label="Nome" />
			<s:textfield name="cpf" label="Cpf" />
			<s:textfield name="dataNascimento" label="Data de nascimento" />
			<s:textfield name="email" label="Email" />
			<s:textfield name="telefoneCelular" label="Telefone celular" />
			<s:textfield name="telefoneResidencial" label="Telefone residencial" />

			<s:submit />
		</s:form>
	</div>
	<div class="d-flex content">
		<table class="table" border="1">
			<tr>
				<th>Nome</th>
				<th>CPF</th>
				<th>Email</th>
				<th></th>
			</tr>

			<s:iterator value="alunos">
				<tr>
					<td><s:property value="nome" /></td>
					<td><s:property value="cpf" /></td>
					<td><s:property value="email" /></td>
					<td><a href="#" class="btn btn-primary"><i
							class="fas fa-trash"></i>Deletar</a></td>
				</tr>
			</s:iterator>
		</table>
	</div>
</body>
</html>