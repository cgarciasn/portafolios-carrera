<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Restaurant Details</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/stylesheet.css">
</head>
<body>
<a href="${pageContext.request.contextPath}/SearchServlet"><img class="logo"
		src="${pageContext.request.contextPath}/css/Resources/JustEat.png"></a>    <a href="${pageContext.request.contextPath}/ModifyUserServlet">Account Details</a>
	<a href="${pageContext.request.contextPath}/OwnedRestaurantsServlet">My restaurants</a>
	<a href="${pageContext.request.contextPath}/CartServlet">My cart</a>
	<a href="${pageContext.request.contextPath}/HistoricalServlet">My historical</a>
	<a href="${pageContext.request.contextPath}/LogOutServlet">Log Out</a>
    <form method="post" action="?">
		<div>
		<label for="name">Restaurant Name</label><br>
		${restaurant.name}<br><br>
		</div>
		<div>
		<label for="address">Restaurant Address</label><br>
		${restaurant.address}<br><br>
		</div>
		<div>
		<label for="telephone">Restaurant Telephone</label><br>
		${restaurant.telephone}<br><br>
		</div>
		<div>
		<label for="email">Restaurant Mail</label><br>
		${restaurant.contactEmail}<br><br>
		</div>
		<div>
		<label for="pricerange">Restaurant Price Range</label><br>
		Min:${restaurant.minPrice} Max:${restaurant.maxPrice}<br><br>
		</div>
		<div>
		<label for="averagevaloration">Restaurant Average Valoration</label><br>
		${restaurant.gradesAverage}<br><br>
		</div>
		<div>
		<label for="bikefriendly">Restaurant Bike Friendly</label><br>
		<c:choose>
		<c:when test="${restaurant.bikeFriendly=='1'}">
		Yes<br><br>
		</c:when>
		<c:otherwise>
		No<br><br>
		</c:otherwise>
		</c:choose>
		</div>
		<label for="Available">Available for orders</label><br>
		<c:choose>
		<c:when test="${restaurant.available=='1'}">
		Yes<br><br>
		</c:when>
		<c:otherwise>
		No<br><br>
		</c:otherwise>
		</c:choose>
		<label>Categories</label>
        <c:forEach var="category" items="${categories}">
        	<li><label>${category.name}</label></li>
        </c:forEach>
		</form>
        
</body>