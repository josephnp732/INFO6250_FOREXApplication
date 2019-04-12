<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add User</title>
</head>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<span style="padding-left: 3em"> <a href="${contextPath}/">BACK</a></span>
</br>
</br>
</br>
<center>
	<h1>Enter your details</h1>
</center>
<body>
	<center>
		<form:form action="${contextPath}/add" method="post"
			modelAttribute="user">
			<table>
				<tr>
					<td>User Name :</td>
					<td><form:input name="userName" path="userName"
							required="required" /></td>
							<td> </td>
				</tr>
				<tr>
					<td>Password :</td>
					<td><form:password name="password" path="password"
							required="required" /></td>
							<td> </td>
				</tr>
				<tr>
					<td>Name :</td>
					<td><form:input name="name" path="name" required="required" /></td>
					<td> <font color="red"><form:errors path="name"/></font> </td>			
				</tr>
				<tr>
					<td>Phone Number:</td>
					<td><form:input type="text" name="phoneNumber"
							path="phoneNumber" required="required" /></td>
							<td> </td>
							
				</tr>
				<tr>
					<td>Email ID:</td>
					<td><form:input type="text" name="email" path="email" required="required" /></td>
					<td><font color="red"><form:errors path="email"/></font> </td>
				</tr>
				<tr>
					<td>Address:</td>
					<td><form:textarea path="address" rows="3" cols="20" /></td>
					<td> </td>
				</tr>
				<tr>
					<td>Date of Birth:</td>
					<td><form:input type="text" path="dateOfBirth"
							required="required" /></td>
					<td>		<font color="red"><form:errors path="dateOfBirth"/></font> </td>
				</tr>
				<tr>
				<td><font size=2>(mm/dd/yyyy)</font></td>
				</tr>
				<tr>
				<td> </td>
					<td align="center"><input type="submit" value="Create" /></td>
				<td> </td>
				</tr>
			</table>
		</form:form>
</body>
</center>
</html>