<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

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
	<h1>Materias</h1>
	
	<div class="d-flex content">	
		<table class="table" border="1">
			<tr>
				<th>Nome</th>
				<th>Sigla</th>
				<th></th>
				<th><a href="adicionarFormulario" class="btn btn-danger">Adicionar materia</a></th>
			</tr>
			
			<s:iterator value="materias">
				<tr>
					<td><s:property value="nome" /></td>
					<td><s:property value="sigla" /></td>
					<td><a href="atualizarFormulario?cod_materia=${cod_materia}" class="btn btn-primary"> Atualizar</a></td>
					<td><a href="deletar?cod_materia=${cod_materia}" class="btn btn-primary"><i class="fas fa-trash"></i> Deletar</a></td>
				</tr>
			</s:iterator>
		</table>
	</div>
</body>
</html>