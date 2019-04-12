<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Recipient</title>
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
			<th>Name On Card</th>
			<th>Card Type</th>
			<th>Card Number</th>
			<th>Expiration Date</th>
			<th>Zip Code</th>
		</tr>
		<c:forEach var="payment" items="${payments}">
			<tr>
				<td><c:out value="${payment.nameOnCard}" /></td>
				<td><c:out value="${payment.cardType}" /></td>
				<td><c:out value="${payment.cardNumber}" /></td>
				<td><c:out value="${payment.month}" />/<c:out
						value="${payment.year}" /></td>
				<td><c:out value="${payment.zipCode}" /></td>
			</tr>
		</c:forEach>
	</table>
	<c:set var="contextPath" value="${pageContext.request.contextPath}" />
	<form:form action="${contextPath}/userPayment/add" method="post"
		commandName="user">
		<center>
			<input type="submit" value="Add Payment" />
		</center>
	</form:form>
</body>
</html>