<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
   <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Owned Restaurants</title>
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
<h1>My Restaurants</h1>
		<div class="infoBurger">
			<c:forEach var="restaurant" items="${ownedRestaurantsList}">
				<a href="<c:url value='DetailRestaurantServlet.do?id=${restaurant.id}'/>"><img
					src="${pageContext.request.contextPath}/css/Resources/${restaurant.name}.jpg"></a><br>
				<h3 class="restaurantnames">${restaurant.name}</h3>
				<a href="<c:url value='EditMenuServlet.do?restaurantId=${restaurant.id}'/>"><input type="button" name = "editOwnedRestMenu" value="Edit Menu"></input></a>
                <a href="<c:url value='EditRestaurantServlet.do?restaurantId=${restaurant.id}'/>"><input type="button" name = "editOwnedRest" value="Edit Restaurant"></input></a>
			</c:forEach>
		</div>				
		
		<a href="<c:url value='CreateRestaurantServlet.do?'/>"><input type="button" name = "createRestaurant" value="Add new restaurant"></input></a>																
</body>
</html>