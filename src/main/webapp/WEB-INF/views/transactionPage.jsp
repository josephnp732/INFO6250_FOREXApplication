<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Transaction</title>
</head>
<body>
	<c:set var="contextPath" value="${pageContext.request.contextPath}" />
	<span style="padding-left: 3em"> <a href="${contextPath}/home">HOME</a></span>
	<span style="padding-left: 55em"> <a href="${contextPath}/">LOGOUT</a></span>
	</br>
	</br>
	</br>
	<center>
		<h2>Initiate Transaction</h2>
	</center>
	<center>
		<form:form action="${contextPath}/userTransaction/transact"
			method="post" modelAttribute="transaction">
			<table>
				<tr>
					<td>Select Currency:</td>
					<td><form:select name="transactionCurrency"
							path="transactionCurrency" items="${map.currencies}"
							required="required" /></td>
				</tr>
				<tr>
					<td>Amount :</td>
					<td><form:input name="transactionAmount"
							path="transactionAmount" required="required" />
									<font color="red"><form:errors path="transactionAmount"/></font></td>
							
				</tr>
				<tr>
					<td>Select Recipient:</td>
					<td><form:select name="recipient" path="recipient"
							items="${map.recipients}" required="required" /></td>
				</tr>
				<tr>
					<td>Select Card:</td>
					<td><form:select name="cardNumber" path="cardNumber"
							items="${map.payments}" required="required" /></td>
				</tr>
				<tr>
				<td> </td>
					<td align="center"><input type="submit" value="Send" /></td>
				</tr>
			</table>
		</form:form>
	</center>
</body>
</html>