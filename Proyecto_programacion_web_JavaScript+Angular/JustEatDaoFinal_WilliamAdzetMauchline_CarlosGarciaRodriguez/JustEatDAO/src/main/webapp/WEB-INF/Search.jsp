<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Restaurant Search</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/stylesheet.css">
</head>
<body>
<img class="logo" src="${pageContext.request.contextPath}/css/Resources/JustEat.png">
<a href="${pageContext.request.contextPath}/ModifyUserServlet">Account Details</a>
<a href="${pageContext.request.contextPath}/OwnedRestaurantsServlet">My restaurants</a>
<a href="${pageContext.request.contextPath}/CartServlet">My cart</a>
<a href="${pageContext.request.contextPath}/HistoricalServlet">My historical</a>
<a href="${pageContext.request.contextPath}/LogOutServlet">Log Out</a>
<div class="content">
    <h1>Takeaways near you</h1>
    <div class="searchWidget">
    <form method="post" action="?">
    <input type="text" id="street" name="query" placeholder="ex. Alcalá Street, 48, Madrid" >
    <input type="submit" id="search" name="search" value="Search"><br>
    <div>
    <input type="checkbox" id= "all" name="all" value="Accept All" checked>
    <label for="all">All</label>
    <input type="checkbox" id= "acceptOrders" name="acceptOrders" value="Accept orders">
    <label for="acceptOrders">Accept Orders</label>
    <input type="checkbox" id= "noAcceptOrders" name="noAcceptOrders" value="No accept orders">
    <label for="noAcceptOrders">No Accept Orders</label>
    </div>
    </form>
    </div>
    <h1>Most popular types of food</h1>
   
    <ul class = "foodTypes">
        <li><button id="american">American</button></li>
        <li><button id="argentina">Argentinian</button></li>
        <li><button id="spanish">Spanish</button></li>
        <li><button id="italian">Italian</button></li>
        <li><button id="chinese">Chinese</button></li>
        <li><button id="pizza">Pizza</button></li>
        <li><button id="burger">Burgers</button></li>
        <li><button id="sandwich">Sandwiches</button></li>
        <li><button id="fries">French Fries</button></li>
        <li><button id="wraps">Wraps</button></li>
    </ul>
</div>
</body>
</html>