<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<html>
<head>
<title>Home</title>
</head>
<body>
	<h1>
		<center>Welcome</center>
	</h1>
	<c:set var="contextPath" value="${pageContext.request.contextPath}" />
	<form:form action="${contextPath}/login" method="post"
		commandName="user">
		<center>
			<table>
				<tr>
					<td>User Name :</td>
					<td><form:input name="userName" path="userName" required="required" /></td>
				</tr>
				<tr>
					<td>Password :</td>
					<td><form:password name="password" path="password" required="required" /></td>
				</tr>
				<tr>
				<td> </td>
				<td align="center">
				<c:if test="${validate == 79}">
				<font color="red">Invalid Credentials</font></c:if> </td>
				</tr>
				<tr>
					<td></td>
					<td align="center"><input type="submit" value="Login" /></td>
				</tr>
			</table>
		</center>
	</form:form>
	<center>
	<h3>New User?</h3>
	<form:form action="${contextPath}/welcome" method="post"
		commandName="user">
		<input type="submit" value="Create Account" />
	</form:form>
	</center>
</body>
</html>
