<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<table>
	<c:forEach var ="cus" items ="${cusDetails}">
	
	<!-- update-->
	
	<c:set var ="id" value="${cus.id}"/>
	<c:set var ="name" value="${cus.name}"/>
	<c:set var ="email" value="${cus.email}"/>
	<c:set var ="phone" value="${cus.phone}"/>
	<c:set var ="username" value="${cus.username}"/>
	<c:set var ="password" value="${cus.password}"/>
	<!--end-->
	
	
	
	
	
	
	<tr>
		<td>Customer ID </td>	
		<td>${cus.id}</td>
	</tr>
	<tr>
		<td>Customer Name 	</td>	
		<td>${cus.name}</td>
	</tr>
	<tr>
		<td>Customer Email 	</td>	
		<td>${cus.email}</td>
	</tr>
	<tr>
		<td>Customer phone </td>	
		<td>${cus.phone}</td>
	</tr>
	<tr>
		<td>Customer UserName </td>	
		<td>${cus.username}</td>
	</tr>
	

	
	</c:forEach>
	</table>
	
	
	
	 <!--for update method  -->
	 <c:url value ="updatecustomer.jsp" var= "cusupdate">
	 	<c:param name="id" value = "${id}"/>
	 	<c:param name="name" value ="${name}"/>
	 	<c:param name="email" value ="${email}"/>
	 	<c:param name="phone" value ="${phone}"/>
	 	<c:param name="uname" value ="${username}"/>
	 	<c:param name="pass" value ="${password}"/>
	 </c:url>
	 
	 <a href="${cusupdate }">
	 <input type ="button" name ="update" value ="Update My data">
	 </a>
	<!-- end -->
	
	
	
</body>
</html>