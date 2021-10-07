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
	<title>Detalhar Mat�ria</title>
</head>
<body>
	<div class="app">
		<s:include value="../components/sidebar.jspf"></s:include>
		<div class="body-wrapper">
			<div class="body">
				<div class="row p-8 bg-primary">
					<div class="col items-center">
						<div class="perfil-circle">
							<i class="fas fa-chalkboard"></i>
						</div>
					</div>
				</div>
				<div class="row p-8 bg-primary">
					<div class="col text-center">
						<h2>Nome da materia aqui</h2>
					</div>
				</div>
				<div class="row p-8">
					<div class="col">
						<h3>Nome</h3>
						<p>Analise e desenvolvimento de sistemas</p>
					</div>
					
				</div>
				<div class="row p-8">
					<div class="col">
						<h3>Sigla</h3>
						<p>ADS</p>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>