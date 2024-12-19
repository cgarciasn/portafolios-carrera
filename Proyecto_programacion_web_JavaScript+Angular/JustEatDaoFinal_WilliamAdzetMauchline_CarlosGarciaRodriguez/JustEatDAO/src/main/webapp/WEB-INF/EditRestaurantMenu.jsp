<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
    <h1>${restaurant.name}</h1>
    <div class="infoBurger">
	<c:forEach var="dish" items="${menu}">
	<ul>
		<li><h2>${dish.name}</h2><a href="<c:url value='DishDetailsServlet.do?dishId=${dish.id}'/>"><button id="detailsDish">View Details</button></a></li>	
	</ul>
	</c:forEach>
		</div>	
		
	<form id= "editNewDish" method="post" action="EditMenuServlet.do">
   	<fieldset id="newMenu">
   		<input type="hidden" name="restaurantId" value="${restaurant.id}">
       	<label>Dish</label><br>
       	<input type="text" name="dishName" id="dishName"><br>
       	<label>Dish price</label><br>
       	<input type="text" name="dishPrice" id="dishPrice"><br>
       	<label>Dish description</label><br>
 		<input type="text" name="dishDescription" id="dishDescription"><br>
   	</fieldset>
   	<input type="submit" value="Add" id="addDishSubmit">
   	</form>
    	


    

