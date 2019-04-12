<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>User Transactions</title>
</head>
<body>
	<c:set var="contextPath" value="${pageContext.request.contextPath}" />
	<span style="padding-left: 3em"> <a href="${contextPath}/home">HOME</a></span>
	<span style="padding-left: 55em"> <a href="${contextPath}/">LOGOUT</a></span>
	</br>
	</br>
	</br>
	<table table width="80%" border="1" align="center">
		<tr bgcolor="#94949">
			<th>Recipient</th>
			<th>Payment Method</th>
			<th>Transaction Amount</th>
			<th>Currency</th>
			<th>Transaction Date</th>
		</tr>
		<c:forEach var="transaction" items="${transactions}">
			<tr>
				<td><c:out value="${transaction.recipient}" /></td>
				<td><c:out value="${transaction.cardNumber}" /></td>
				<td><c:out value="${transaction.transactionAmount}" /></td>
				<td><c:out value="${transaction.transactionCurrency}" /></td>
				<td><c:out value="${transaction.transactionDateTime}" /></td>
			</tr>
		</c:forEach>
	</table>
	</br>
	<center>
		<a href="${contextPath}/userTransaction/downloadPDF.pdf"><font size=4>Download as PDF</font></a>
		<center>
</body>
</html>