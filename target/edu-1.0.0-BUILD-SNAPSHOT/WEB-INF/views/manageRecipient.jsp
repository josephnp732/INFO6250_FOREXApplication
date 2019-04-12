<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<c:set var="contextPath" value="${pageContext.request.contextPath}" />
	<span style="padding-left: 3em"> <a href="${contextPath}/home">HOME</a></span>
	<span style="padding-left: 55em"> <a href="${contextPath}/">LOGOUT</a></span>
	</br>
	</br>
	</br>
	<table table width="60%" border="1" align="center">
		<tr bgcolor="#94949">
			<th>Name</th>
			<th>Account Number</th>
			<th>Routing Number</th>
			<th>Email Address</th>
			<th><i>Delete?<i/></th>
		</tr>
		<c:forEach var="recipient" items="${recipients}">
			<tr>
				<td><c:out value="${recipient.name}" /></td>
				<td><c:out value="${recipient.accountNumber}" /></td>
				<td><c:out value="${recipient.routingNumber}" /></td>
				<td><c:out value="${recipient.emailAddress}" /></td>
				<td>
					
				</td>
			</tr>
		</c:forEach>
	</table>
	<c:set var="contextPath" value="${pageContext.request.contextPath}" />
	<form:form action="${contextPath}/userRecipient/add" method="post"
		commandName="user">
		<center>
			<input type="submit" value="Add Recipient" />
		</center>
	</form:form>
</body>
</html>