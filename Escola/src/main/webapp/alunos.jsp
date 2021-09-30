<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@	taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sx" uri="/struts-dojo-tags"%>

<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<link rel="stylesheet" href="./assets/css/styles.css">
	<title>Alunos</title>
</head>
<body>
	<div class="d-flex content">
		<table class="table">
			<thead>
				<tr>
					<th>Nome</th>
					<th>Matéria</th>
					<th></th>
					<th></th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="contato" items="${model}">
					<tr>
						<td>${contato.nome}</td>
						<td>${contato.cod_materia}</td>
						<td><button class="btn btn-danger">Detalhar</button></td>
						<td><button class="btn btn-danger">Deletar</button></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</body>
</html>