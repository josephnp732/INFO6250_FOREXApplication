<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add Payment</title>
</head>
<body>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<span style="padding-left:3em"> <a href="${contextPath}/home">HOME</a></span> 
<span style="padding-left:55em"> <a href="${contextPath}/">LOGOUT</a></span> 
</br> </br> </br>
	<center>
		<h2>Enter Payment Details</h2>
		<form:form action="${contextPath}/userPayment/create" method="post"
			modelAttribute="payment">
			<table>
				<tr>
					<td>Name on Card :</td>
					<td><form:input name="nameOnCard" path="nameOnCard" required="required" /></td>
				</tr>
				<tr>
					<td>Card Number :</td>
					<td><form:input name="cardNumber" path="cardNumber"
							required="required" /></td>
				</tr>
				<tr>
					<td>Card Type :</td>
					<td><form:select name="cardType" path="cardType" items="${map.cardTypes}"
							required="required" /></td>
				</tr>
				<tr>
					<td>Expiry Date:</td>
					<td><form:select type="text" path="month" items="${map.months}"
							required="required" /></td>
					<td><form:select type="text" path="year" items="${map.years}"
							required="required" /></td>
				</tr>
				<tr>
					<td>Zip Code:</td>
					<td><form:input type="text" path="zipCode" required="required" /></td>
				</tr>
				<tr>
					<td align="center"><input type="submit" value="Add Payment" /></td>
				</tr>
			</table>
		</form:form>
	</center>
</body>
</html>