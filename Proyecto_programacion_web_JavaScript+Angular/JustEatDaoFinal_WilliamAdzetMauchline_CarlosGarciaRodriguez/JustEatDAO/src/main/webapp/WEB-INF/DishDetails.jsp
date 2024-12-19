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
    <div class="DishDetails">
    	<h1>Dish Details</h1>
		<ul id="DishDetails">
			<form id= "updateDish" method="post" action="DishDetailsServlet.do">
				<input type="hidden" name="dishId" value="${dish.id}">
				<li><input type="text" name= "dishName" value="${dish.name}"></li>
				<li><input type="text" name= "dishPrice" value="${dish.price}"></li>
				<li><input type="text" name= "dishDescription" value="${dish.description}"></li>
				<li><input type="submit" value="Update"><button class="deleteDish" name="Delete">Delete</button></li>
			</form>
		</ul>
	</div>	