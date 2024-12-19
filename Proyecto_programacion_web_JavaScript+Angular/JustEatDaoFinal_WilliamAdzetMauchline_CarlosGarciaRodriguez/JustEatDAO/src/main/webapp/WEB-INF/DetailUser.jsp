<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>User Details</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/stylesheet.css">
</head>
<body>
<a href="${pageContext.request.contextPath}/SearchServlet"><img class="logo"
		src="${pageContext.request.contextPath}/css/Resources/JustEat.png"></a><a href="${pageContext.request.contextPath}/ModifyUserServlet">Account Details</a>
<a href="${pageContext.request.contextPath}/OwnedRestaurantsServlet">My restaurants</a>
<a href="${pageContext.request.contextPath}/CartServlet">My cart</a>
<a href="${pageContext.request.contextPath}/HistoricalServlet">My historical</a>
<a href="${pageContext.request.contextPath}/LogOutServlet">Log Out</a>
	<h1>Detalles del usuario ${user.name}</h1>
	<form method="post" action="?">
		<div>
		<label for="name">User name</label><br>
		<input type="text" id="name" name="name" value="${user.name}"><br>
		</div>
		<div>
		<label for="surname">User surname</label><br>
		<input type="text" id="surname" name="surname" value="${user.surname}"><br>
		</div>
		<div>
		<label for="email">User mail</label><br>
		<input type="email" id="email" name="email" value="${user.email}"><br>
		</div>
		<div>
		<label for="password">User Password</label><br>
		<input type="password" id="password" name="password" value="${user.password}"><br>
		</div>
		<input type="submit" id="editacc" name="editacc" value="Edit User Infomation">
		<input type="submit" id="deleteracc" name="deleteacc" value="Delete User">
	</form>
</body>
</html>