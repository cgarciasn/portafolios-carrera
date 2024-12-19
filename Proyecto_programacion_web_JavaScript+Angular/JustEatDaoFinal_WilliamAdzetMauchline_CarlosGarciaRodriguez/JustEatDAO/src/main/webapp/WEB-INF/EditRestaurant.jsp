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
    <form method="post" action="EditRestaurantServlet.do">
    	<input type="hidden" name="restaurantId" value="${restaurant.id}">
		<div>
		<label for="name">Restaurant Name</label><br>
		<input type="text" id="name" name="name" value="${restaurant.name}"><br>
		</div>
		<div>
		<label for="address">Restaurant Address</label><br>
		<textarea id="address" name="address">${restaurant.address}</textarea><br>
		</div>
		<div>
		<label for="telephone">Restaurant Telephone</label><br>
		<input type="tel" id="telephone" name="telephone" value="${restaurant.telephone}"><br>
		</div>
		<div>
		<label for="email">Restaurant Mail</label><br>
		<input type="email" id="email" name="email" value="${restaurant.contactEmail}"><br>
		</div>
		<div>
		<label for="minPrice">Restaurant Minimum Price</label><br>
		<input type="number" id="minPrice" name="minPrice" value="${restaurant.minPrice}"><br>
		</div>
		<div>
		<label for="maxPrice">Restaurant Maximum Price</label><br>
		<input type="number" id="maxPrice" name="maxPrice" value="${restaurant.maxPrice}"><br>
		</div>
		<div>
		<label for="averagevaloration">Restaurant Average Valoration</label><br>
		<input type="text" id="averagevaloration" name="averagevaloration" value="${restaurant.gradesAverage}"><br>
		</div>
		<label>Available for orders</label><br>
		<div>
		<c:choose>
		<c:when test="${restaurant.available=='1'}">
          <li><input type="radio" id="availableYes" name="available" value="Yes" checked><label for="available">Yes</label></li>
          <li><input type="radio" id="availableNo" name="available" value="No"><label for="available">No</label></li>
        </c:when>
        <c:otherwise>
          <li><input type="radio" id="availableYes" name="available" value="Yes"><label for="available">Yes</label></li>
          <li><input type="radio" id="availableNo" name="available" value="No" checked><label for="available">No</label></li>
        </c:otherwise>
        </c:choose>
		</div>
		<label>BikeFriendly</label><br>
		<div>
		<c:choose>
		<c:when test="${restaurant.bikeFriendly=='1'}">
          <li><input type="radio" id="bikeFriendlyYes" name="bikeFriendly" value="Yes" checked><label for="bikeFriendly">Yes</label></li>
          <li><input type="radio" id="bikeFriendlyNo" name="bikeFriendly" value="No"><label for="bikeFriendly">No</label></li>
        </c:when>
        <c:otherwise>
          <li><input type="radio" id="bikeFriendlyYes" name="bikeFriendly" value="Yes"><label for="bikeFriendly">Yes</label></li>
          <li><input type="radio" id="bikeFriendlyNo" name="bikeFriendly" value="No" checked><label for="bikeFriendly">No</label></li>
        </c:otherwise>     
        </c:choose>
        </div>
        <div>
        <label>Categories</label>
        <c:forEach var="category" items="${categories}">
        	<li>${category.name}<input type="radio" name="${category.name}"></li>
        </c:forEach>
        </div>
		<input type="submit" value="Update Restaurant"><button class="deleteDish" name="Delete">Delete</button>
		</form>
</body>