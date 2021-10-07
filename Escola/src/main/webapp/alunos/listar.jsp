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
	<div class="app">
		<s:include value="../components/sidebar.jspf"></s:include>
		<div class="body-wrapper">
			<div class="body">
				<div class="row">
					<div class="col">
						<h2>Lista de alunos</h2>
						
						<table class="table" border="1">
							<tr>
								<th>Nome</th>
								<th>CPF</th>
								<th>Email</th>
								<th colspan="2">A��es</th>
							</tr>
				
							<s:iterator value="alunos">
								<tr>
									<td><s:property value="nome" /></td>
									<td><s:property value="cpf" /></td>
									<td><s:property value="email" /></td>
									<td colspan="2">
										<a href="alterar?aluno.cod_aluno=${cod_aluno}">Atualizar</a>
										<a href="detalhar?aluno.cod_aluno=${cod_aluno}">Detalhar</a>
										<a href="deletar?aluno.cod_aluno=${cod_aluno}" class="btn btn-danger"><i class="fas fa-trash"></i> Deletar</a>
									</td>
								</tr>
							</s:iterator>
						</table>
						<a href="iniciarCadastro" class="btn btn-danger"><i class="fas fa-plus"></i> Inserir aluno</a>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>