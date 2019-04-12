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
<span style="padding-left:3em"> <a href="${contextPath}/home">HOME</a></span> 
<span style="padding-left:55em"> <a href="${contextPath}/">LOGOUT</a></span> 
</br> </br> </br>
	<center>
		<h2>Enter Recipient Details</h2>
		<form:form action="${contextPath}/userRecipient/create" method="post"
			modelAttribute="recipient">
			<table>
				<tr>
					<td>Recipient Name :</td>
					<td><form:input name="name" path="name" required="required" /></td>
					<font color="red"><form:errors path="emailAddress"/></font>
				</tr>
				<tr>
					<td>Account Number :</td>
					<td><form:input name="accountNumber" path="accountNumber"
							required="required" /></td>
				</tr>
				<tr>
					<td>Routing Number :</td>
					<td><form:input name="routingNumber" path="routingNumber"
							required="required" /></td>
				</tr>
				<tr>
					<td>Email Address:</td>
					<td><form:input type="text" path="emailAddress"
							required="required" /></td>
					<font color="red"><form:errors path="emailAddress"/></font>
				</tr>
				<tr>
					<td>Relation:</td>
					<td><form:input type="text" path="purpose"
							required="required" /></td>
					<font color="red"><form:errors path="purpose"/></font>	
				</tr>
				<tr>
					<td align="center"><input type="submit" value="Add Recipient" /></td>
				</tr>
			</table>
		</form:form>
	</center>
</body>
</html>