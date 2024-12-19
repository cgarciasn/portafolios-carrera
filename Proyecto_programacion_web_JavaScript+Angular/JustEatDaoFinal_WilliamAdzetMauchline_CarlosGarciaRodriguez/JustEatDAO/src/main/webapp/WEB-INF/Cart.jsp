<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Cart</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/stylesheet.css">
</head>
<body>
<a href="${pageContext.request.contextPath}/SearchServlet"><img class="logo"
		src="${pageContext.request.contextPath}/css/Resources/JustEat.png"></a>
<a href="${pageContext.request.contextPath}/ModifyUserServlet">Account Details</a>
<a href="${pageContext.request.contextPath}/OwnedRestaurantsServlet">My restaurants</a>
<a href="${pageContext.request.contextPath}/CartServlet">My cart</a>
<a href="${pageContext.request.contextPath}/HistoricalServlet">My historical</a>
<a href="${pageContext.request.contextPath}/LogOutServlet">Log Out</a>
<form method="post" action="CartServlet.do">
<c:set var="amount" value="0" />
<c:forEach var="dish" items="${dishList}">
	<h2>${dish.id}</h2>
	<ul>
		<li>${dish.name}</li>
		<li>${dish.price} $</li>
		<li>${dish.description}</li>
		<li><button name="${dish.name}">Remove</button></li>
		<c:set var="amount" value="${amount + dish.price}"/>
	</ul>
	<p> Total Price: ${amount} $</p>
</c:forEach>
<input type="submit" name="confirmedorder" value="Confirm order">
</form>
</body>
</html>