<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@	taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sx" uri="/struts-dojo-tags"%>

<c:set var="context" value="${pageContext.request.contextPath}" />

<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<link rel="stylesheet" href="${context}/assets/css/styles.css">
	<title>Alunos</title>
</head>
<body>
	<div class="d-flex content">		
	</div>
	
	<table border="1">
		<tr>
			<th>Nome</th>
			<th>CPF</th>
			<th>Email</th>
		</tr>
		
		<s:iterator value="alunos">
			<tr>
				<td><s:property value="nome" /></td>
				<td><s:property value="cpf" /></td>
				<td><s:property value="email" /></td>
			</tr>
		</s:iterator>
		
	</table>
	
</body>
</html>