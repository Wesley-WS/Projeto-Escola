<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@	taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sx" uri="/struts-dojo-tags"%>

<c:set var="context" value="${pageContext.request.contextPath}" />

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Associação aqui.</title>
</head>
<body>
	<h1>Associe aqui</h1>
	<s:form action="associar" method="post">
		<s:hidden name="professor.cod_professor" value="%{professor.cod_professor}" />
		
		<s:iterator value="materias">
			<s:checkbox name="materiasSelecionadas" id="%{cod_materia}" fieldValue="%{cod_materia}" label="%{nome}"></s:checkbox>
		</s:iterator>
		<s:submit value="submit" name="submit" />
	</s:form>
</body>
</html>