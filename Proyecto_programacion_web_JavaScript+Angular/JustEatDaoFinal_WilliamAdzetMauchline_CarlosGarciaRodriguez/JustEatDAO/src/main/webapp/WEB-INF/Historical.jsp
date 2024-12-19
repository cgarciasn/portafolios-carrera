<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Historical</title>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/stylesheet.css">
</head>
<body>
<a href="${pageContext.request.contextPath}/SearchServlet"><img class="logo"
		src="${pageContext.request.contextPath}/css/Resources/JustEat.png"></a><a href="${pageContext.request.contextPath}/ModifyUserServlet">Account Details</a>
<a href="${pageContext.request.contextPath}/OwnedRestaurantsServlet">My restaurants</a>
<a href="${pageContext.request.contextPath}/CartServlet">My cart</a>
<a href="${pageContext.request.contextPath}/HistoricalServlet">My historical</a>
<a href="${pageContext.request.contextPath}/LogOutServlet">Log Out</a>
<h1>Historical Orders</h1>
<ul>
<c:forEach var="entry" items="${displaymap}">
<div class="fragments">
	<li>
		<h2>Order id: ${entry.key}</h2>
	<li>
	<ol>
	<c:forEach var="dish" items="${entry.value}">
		<li>
			<h3>${dish.name}: ${dish.price} $</h3>
		</li>
	</c:forEach>
	</ol>
</div>
</c:forEach>
</ul>
</body>
</html>