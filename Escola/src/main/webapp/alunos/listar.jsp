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
	
<title>Alunos</title>
</head>
<body>
	<div class="d-flex content">
		<table class="table" border="1">
			<tr>
				<th>Nome</th>
				<th>CPF</th>
				<th>Email</th>
				<th></th>
				<th><a href="adicionarFormulario" class="btn btn-danger">Inserir aluno</a></th>
			</tr>

			<s:iterator value="alunos">
				<tr>
					<td><s:property value="nome" /></td>
					<td><s:property value="cpf" /></td>
					<td><s:property value="email" /></td>
					<td><a href="atualizarFormulario?cod_aluno=${cod_aluno}" class="btn btn-primary"> Atualizar</a></td>
					<td><a href="deletar?cod_aluno=${cod_aluno}" class="btn btn-danger"><i class="fas fa-trash"></i> Deletar</a></td>
				</tr>
			</s:iterator>
		</table>
	</div>
</body>
</html>