<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Review</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/stylesheet.css">
</head>
<body>
<a href="${pageContext.request.contextPath}/SearchServlet"><img class="logo"
		src="${pageContext.request.contextPath}/css/Resources/JustEat.png"></a><a href="${pageContext.request.contextPath}/ModifyUserServlet">Account Details</a>
<a href="${pageContext.request.contextPath}/OwnedRestaurantsServlet">My restaurants</a>
<a href="${pageContext.request.contextPath}/CartServlet">My cart</a>
<a href="${pageContext.request.contextPath}/HistoricalServlet">My historical</a>
<a href="${pageContext.request.contextPath}/LogOutServlet">Log Out</a>
<h2>${restaurant.name} Review</h2>
<form method="post" action="ReviewServlet.do">
<div>
		<input type="hidden" name="restaurantid" value="${restaurant.id}"> 
        <label for="review">Review</label><br>
        <input type="text" id="review" name="review"><br>
        </div>
        <div>
        <label for="valoration">Valoration</label><br>
        <input type="number" id="valoration" name="valoration" min="1" max="5"><br>
        </div>
        <input type="submit" name="sendreview" value="Send review">
</form>
</body>
</html>