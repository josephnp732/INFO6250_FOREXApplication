<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>My Details</title>
</head>
<body>
	<c:set var="contextPath" value="${pageContext.request.contextPath}" />
	<span style="padding-left: 3em"> <a href="${contextPath}/home">BACK</a></span>
	<span style="padding-left: 55em"> <a href="${contextPath}/">LOGOUT</a></span>
	</br>
	</br>
	</br>
	<center>
		<h2>
			<i>My Details</i>
		</h2>
		<font size=4 color=blue><b><i>Name:</i></b></font>
		${sessionScope.user.getName()} </br> </br> <font size=4 color=blue><b><i>User
					Name:</i></b></font> ${sessionScope.user.getUserName()} </br> </br> <font size=4 color=blue><b><i>Phone
					Number:</i></b></font> ${sessionScope.user.getPhoneNumber()} </br> </br> <font size=4
			color=blue><b><i>Address:</i></b></font>
		${sessionScope.user.getAddress()} </br> </br> <font size=4 color=blue><b><i>Date
					of Birth:</i></b></font> ${sessionScope.user.getDateOfBirth()} </br> </br> <font size=4
			color=blue><b><i>Email Address:</i></b></font>
		${sessionScope.user.getEmail()} </br> </br> </br>

		<font color=red size=3> <i> Contact us to update your details</i></font>
		<!-- 	
		<h3><i>Update Details</i></h3>	
		<form:form action="${contextPath}/updateDetails/updateUserDetails" modelAttribute="user">
			<td align="center"><input type="submit" value="Update" /></td>  -->
		</form:form>
	</center>
</body>
</html>