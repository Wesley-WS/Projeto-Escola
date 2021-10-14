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

<title>Formulario - Cadastrar mat�ria</title>
</head>
<body>
	<div class="app">
		<s:include value="../components/sidebar.jspf"></s:include>
		<div class="body-wrapper">
			<div class="body">
				<div class="row">
					<div class="col">
						<h2>Cadastrar mat�ria</h2>
						
						<s:form id="formularioMateria" action="cadastrar" method="post">
							<div>
								<label>Nome</label><br />
								<input id="nome" type="text" name="materia.nome" />
							</div>
							<div>
								<label>Sigla</label><br />
								<input id="sigla" type="text" name="materia.sigla" />
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