<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>OrderRestaurant</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/stylesheet.css">
</head>
<body>
<a href="${pageContext.request.contextPath}/SearchServlet"><img class="logo"
		src="${pageContext.request.contextPath}/css/Resources/JustEat.png"></a><a href="${pageContext.request.contextPath}/ModifyUserServlet">Account Details</a>
<a href="${pageContext.request.contextPath}/OwnedRestaurantsServlet">My restaurants</a>
<a href="${pageContext.request.contextPath}/CartServlet">My cart</a>
<a href="${pageContext.request.contextPath}/HistoricalServlet">My historical</a>
<a href="${pageContext.request.contextPath}/LogOutServlet">Log Out</a>
<div class="fragments">
<h1>${restaurant.name}</h1>
<h2>${dishRestaurantList.size()} platos</h2>
<c:forEach var="dish" items="${dishRestaurantList}">
<form method="post" action="OrderRestaurantServlet.do">
<h2>${dish.name} </h2>
<ul>
<li>${dish.price} $</li>
<input type="hidden" name="dishprice" value="${dish.price}">
<li>${dish.description}</li>
</ul>
<input type="hidden" name="dishid" value="${dish.id}">
<input type="submit" name="add" value="Add">
</form>
</c:forEach>
</div>
<div class="fragments">
<h1>Reviews</h1>
<ul>
<c:forEach var="entry" items="${displaymap}">
	<li>
	<h2>${entry.key}</h2>
	</li>
	<c:set var="review" value="${entry.value}" />
		<li>
		${review.review}<br>
		</li>
		<li>
		Grade: ${review.grade}
		</li>
	</c:forEach>
</ul>
<a href="<c:url value='ReviewServlet.do?id=${restaurant.id}'/>"><input type="button" name="review" value="Leave review"></a>
</div>
<a href="<c:url value='DetailRestaurantServlet.do?id=${restaurant.id}'/>"><input type="button" name="details" value="View Restaurant Details"></a>
</body>
</html>