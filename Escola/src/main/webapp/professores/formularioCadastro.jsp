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

<title>Formulario - Cadastrar professor</title>
</head>
<body>
	<div class="app">
		<s:include value="../components/sidebar.jspf"></s:include>
		<div class="body-wrapper">
			<div class="body">
				<div class="row">
					<div class="col">
						<h2>Cadastrar professor</h2>
						
						<s:form action="cadastrar" method="post">
							<div>
								<label>Nome</label><br />
								<input type="text" name="´professor.nome" />
							</div>
							<div>
								<label>Cpf</label><br />
								<input type="text" name="professor.cpf" />
							</div>
							<div>
								<label>Data de nascimento</label><br />
								<input type="text" name="professor.dataNascimento" />
							</div>
							<div>
								<label>Email</label><br />
								<input type="email" name="professor.email" />
							</div>
							<div>
								<label>Telefone Celular</label><br />
								<input type="text" name="professor.telefoneCelular" />
							</div>
							<div>
								<label>Telefone Residêncial</label><br />
								<input type="text" name="professor.telefoneResidencial" />
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