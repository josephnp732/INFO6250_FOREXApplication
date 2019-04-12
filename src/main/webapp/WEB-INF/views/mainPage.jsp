<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Welcome</title>
</head>
<body>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<span style="padding-left:60em"> <a href="${contextPath}/">LOGOUT</a></span> 
</br>
<a href="${contextPath}/mydetails">My Details</a> | <a href="${contextPath}/userRecipient/recipients">Manage Recipients</a> | <a href="${contextPath}/userPayment/payments">Manage Payment Methods</a>  | <a href="${contextPath}/userTransaction/viewTransactions">View Transactions</a> </br> </br> </br>
<h2><b><i>Welcome ${sessionScope.user.getName()}</i></b></h2>
<i>Login Time: </i><%= new java.util.Date() %> </br> 
<i> User Name: </i> ${sessionScope.user.getUserName()} </br> </br>
<a href="${contextPath}/userTransaction/begin"><font size=5>Start New Transaction</font></a> 
</body>
</html>