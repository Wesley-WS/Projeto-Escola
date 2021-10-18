<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@	taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

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
	<title>Detalhar Professor</title>
</head>
<body>
	<div class="app">
		<s:include value="../components/sidebar.jspf"></s:include>
		<div class="body-wrapper">
			<div class="body">
				<div class="row p-8">
					<div class="col flex-dir-row">
						<div class="logo">
							<i class="fas fa-glasses"></i>
						</div>
						<div class="d-flex flex-dir-col">
							<s:date name="professor.dataNascimento.time" format="dd/MM/yyyy" var="dataNascimento"/>
							<h2>Nome: ${professor.nome}</h2>
							<small>Cpf: ${professor.cpf}</small>
							<small>Email: ${professor.email}</small>
							<small>Data de nascimento: ${dataNascimento}</small>
							<small>Telefone celular: ${professor.telefoneCelular}</small>
							<small>Telefone residencial: ${professor.telefoneResidencial}</small>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>