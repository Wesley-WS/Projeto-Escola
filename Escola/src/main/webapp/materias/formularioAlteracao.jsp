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
<script src="https://code.jquery.com/jquery-2.2.4.js" integrity="sha256-iT6Q9iMJYuQiMWNd9lDyBUStIq/8PuOW33aOqmvFpqI=" crossorigin="anonymous"></script>
<script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/jquery.mask/1.14.0/jquery.mask.js"></script>
<script type="text/javascript" src="${context}/assets/js/app.js"></script>

<title>Formulario - Atualizar mat�ria</title>
</head>
<body>
	<div class="app">
		<s:include value="../components/sidebar.jspf"></s:include>
		<div class="body-wrapper">
			<div class="body">
				<div class="row">
					<div class="col">
						<h2>Atualizar mat�ria</h2>
						
						<s:form id="formularioMateria" action="alterar" method="post">
							<s:hidden name="materia.cod_materia" value="%{materia.cod_materia}" />
							
							<div>
								<label>Nome</label><br />
								<input id="nome" type="text" name="materia.nome" value="${materia.nome }"/>
								<div id="mensagem-nome" style="display: none;">
									<small class="warning-message">#</small>
								</div>
							</div>
							<div>
								<label>Sigla</label><br />
								<input id="sigla" type="text" name="materia.sigla" value="${materia.sigla }"/>
								<div id="mensagem-sigla" style="display: none;">
									<small class="warning-message">#</small>
								</div>
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