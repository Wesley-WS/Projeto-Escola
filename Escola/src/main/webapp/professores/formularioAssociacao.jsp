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
<title>Associação aqui.</title>
</head>
<body>
	<h1>Associe aqui</h1>
	<s:form action="associar" method="post">
		<s:checkboxlist list="%{materias}" name="materiasSelecionadas" value="%{cod_materia}"/>
		
		<s:submit value="submit" name="submit" />
	</s:form>
</body>
</html>