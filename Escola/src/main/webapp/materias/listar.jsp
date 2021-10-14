<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<%@	taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="context" value="${pageContext.request.contextPath}" />

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<link rel="stylesheet" href="${context}/assets/css/styles.css">
	<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
	<script src="https://kit.fontawesome.com/6697f5eca6.js" crossorigin="anonymous"></script>
	<script src="../assets/js/modal.js"></script>
	<title>Materias</title>
</head>
<body>
	<div class="app">
		<s:include value="../components/sidebar.jspf"></s:include>
		<div class="body-wrapper">
			<div class="body-header">
				<h2>Lista de mat�rias</h2>
				<a href="iniciarCadastro" class="btn btn-primary"><i class="fas fa-plus"></i> Inserir materia</a>
			</div>
			<div class="body">
				<div class="scroller scroller-base">
					<table class="table" border="1">
						<tr>
							<th>Nome</th>
							<th>Sigla</th>
							<th colspan="2">A��es</th>
						</tr>
						
						<s:iterator value="materias">
							<tr>
								<td><s:property value="nome" /></td>
								<td><s:property value="sigla" /></td>
								<td colspan="2">
									<a href="alterar?materia.cod_materia=${cod_materia}"> Atualizar</a>
									<a href="detalhar?materia.cod_materia=${cod_materia}">Detalhar</a>
									<a href="#" onclick="toggleModal('deletar?materia.cod_materia=${cod_materia}')">Deletar</a>
								</td>
							</tr>
						</s:iterator>
					</table>
				</div>
			</div>
		</div>
	</div>
	<div id="modal" class="modal-content" style="display: none;">
		<div class="modal-wrapper">
			<div class="modal">
				<div class="modal-header">
					<h2>Deletar</h2>
				</div>
				<div class="modal-body">
					<p>Voc� deseja deletar este item?</p>
					
					<div class="d-flex" style="column-gap: 8px;">
						<a id="delete" href="#" class="btn btn-danger flex-sg-auto">Deletar</a>
						<a href="#" class="btn btn-primary flex-sg-auto"
							onclick="toggleModal()">Cancelar</a>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>