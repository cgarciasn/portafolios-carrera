<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Register</title>
<link rel="stylesheet" href ="${pageContext.request.contextPath}/css/stylesheet.css">
</head>
<body>
<img class="logo" src="${pageContext.request.contextPath}/css/Resources/JustEat.png">
<div class="content">
    <h1>Create account</h1>
    <form method="post" action="?">
    	<div>
        <label for="name">Name</label><br>
        <input type="text" id="name" name="name"><br>
        </div>
        <div>
        <label for="surname">Surname</label><br>
        <input type="text" id="surname" name="surname"><br>
        </div>
        <div>
        <label for="email">Email</label><br>
        <input type="email" id="email" name="email"><br>
        </div>
        <div>
        <label for="password">Password (Debe incluir 1 minúscula, 1 mayúscula, 1 número y carácter especial)</label><br>
        <input type="password" id="password" name="password"><br>
        </div>
        <input type="submit" id="createacc" value="Create account">
    </form>
</div>
</body>
</html>