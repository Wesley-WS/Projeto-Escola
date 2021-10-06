<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<%@	taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="context" value="${pageContext.request.contextPath}" />

<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<link rel="stylesheet" href="${context}/assets/css/styles.css">
	<script src="https://kit.fontawesome.com/6697f5eca6.js" crossorigin="anonymous"></script>
	<title>Materias</title>
</head>
<body>
	<div class="app">
		<s:include value="../components/sidebar.jspf"></s:include>
		<div class="body-wrapper">
			<div class="body">
				<div class="row">
					<div class="col">
						<h2>Lista de materias</h2>
						
						<table class="table" border="1">
							<tr>
								<th>Nome</th>
								<th>Sigla</th>
								<th colspan="2">Ações</th>
							</tr>
							
							<s:iterator value="materias">
								<tr>
									<td><s:property value="nome" /></td>
									<td><s:property value="sigla" /></td>
									<td colspan="2"><a href="atualizarFormulario?cod_materia=${cod_materia}" class="btn btn-primary"> Atualizar</a><a href="deletar?cod_materia=${cod_materia}" class="btn btn-primary"><i class="fas fa-trash"></i> Deletar</a></td>
								</tr>
							</s:iterator>
						</table>
						<a href="iniciarCadastro" class="btn btn-danger"><i class="fas fa-plus"></i> Inserir tarefa</a>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>