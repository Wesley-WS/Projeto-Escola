<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags" %>

<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Login</title>
</head>
<body>
	<h1>Login</h1>
	<div>
		<s:form action="login">
			<div>
				<label>Username</label><br />
				<input type="text" name="username" />
			</div>
			<div>
				<label>Password</label><br />
				<input type="password" name="password" />
			</div>
			<div>
				<s:submit />
			</div>
		</s:form>
	</div>
</body>
</html>