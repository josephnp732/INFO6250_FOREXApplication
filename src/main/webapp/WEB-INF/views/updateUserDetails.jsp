<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Update Details</title>
</head>
<body>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<span style="padding-left:3em"> <a href="${contextPath}/home">HOME</a></span> 
<span style="padding-left:55em"> <a href="${contextPath}/">LOGOUT</a></span> 
</br> </br> </br>
	<center>
		<h2>Enter your Details</h2>
		<form:form action="${contextPath}/updateDetails/update" modelAttribute="user">
			<table>
				<tr>
					<td>Address :</td>
					<td><form:input name="address" path="address"  value="${sessionScope.user.getAddress()}"/></td>
				</tr>
				<tr>
					<td>Phone Number :</td>
					<td><form:input name="phoneNumber" path="phoneNumber" value="${sessionScope.user.getPhoneNumber()}"/></td>
				</tr>
				<tr>
					<td>Email ID :</td>
					<td><form:input name="email" path="email" value="${sessionScope.user.getEmail()}"/></td>
				</tr>
				<tr>
					<td> </td>
					<td align="center"><input type="submit" value="Update Details" /></td>
				</tr>
			</table>
		</form:form>
	</center>
</body>
</html>