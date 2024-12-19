<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Search content</title>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/stylesheet.css">
</head>
<body>
	<a href="${pageContext.request.contextPath}/SearchServlet"><img class="logo"
		src="${pageContext.request.contextPath}/css/Resources/JustEat.png"></a>
		<a href="${pageContext.request.contextPath}/ModifyUserServlet">Account Details</a>
		<a href="${pageContext.request.contextPath}/OwnedRestaurantsServlet">My restaurants</a>
		<a href="${pageContext.request.contextPath}/CartServlet">My cart</a>
		<a href="${pageContext.request.contextPath}/HistoricalServlet">My historical</a>
		<a href="${pageContext.request.contextPath}/LogOutServlet">Log Out</a>
	<div class="content">
		<h2>${restaurantList.size()} Restaurantes abiertos</h2>
		<div class="infoBurger">
			<c:forEach var="restaurant" items="${restaurantList}">
				<a href="<c:url value='OrderRestaurantServlet.do?id=${restaurant.id}'/>"><img
					src="${pageContext.request.contextPath}/css/Resources/${restaurant.name}.jpg"></a>
				<h3 class="restaurantnames">${restaurant.name}</h3>
				<h3>Valoration: ${restaurant.gradesAverage}</h3>
			</c:forEach>
		</div>
	</div>
</body>