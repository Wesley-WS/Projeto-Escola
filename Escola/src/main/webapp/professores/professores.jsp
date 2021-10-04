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
	<title>Professores</title>
</head>
<body>
	<h1>Professores</h1>
	
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
			
			<s:iterator value="professores">
				<tr>
					<td><s:property value="nome" /></td>
					<td><s:property value="cpf" /></td>
					<td><s:property value="email" /></td>
					<td><a href="#" class="btn btn-primary"><i class="fas fa-trash"></i>Deletar</a></td>
				</tr>
			</s:iterator>
		</table>
	</div>
</body>
</html>