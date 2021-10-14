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
								<input type="text" name="professor.nome" maxlength="100" required/>
							</div>
							<div>
								<label>Cpf</label><br />
								<input type="text" name="professor.cpf" maxlength="20" placeholder="xxx.xxx.xxx-xx" pattern="[0-9]{3}.[0-9]{3}.[0-9]{3}-[0-9]{2}" required/>
							</div>
							<div>
								<label>Data de nascimento</label><br />
								<input type="text" name="professor.dataNascimento" required/>
							</div>
							<div>
								<label>Email</label><br />
								<input type="email" name="professor.email" maxlength="100" placeholder="xxxxx@xxxx.com" required/>
							</div>
							<div>
								<label>Telefone Celular</label><br />
								<input type="tel" name="professor.telefoneCelular" maxlength="20" placeholder="(xx)xxxxx-xxxx" pattern="\([0-9]{2}\)[0-9]{5}-[0-9]{4}"/>
							</div>
							<div>
								<label>Telefone Residêncial</label><br />
								<input type="tel" name="professor.telefoneResidencial" maxlength="20" placeholder="xxxx-xxxx" pattern="\([0-9]{2}\)[0-9]{4}-[0-9]{4}"/>
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