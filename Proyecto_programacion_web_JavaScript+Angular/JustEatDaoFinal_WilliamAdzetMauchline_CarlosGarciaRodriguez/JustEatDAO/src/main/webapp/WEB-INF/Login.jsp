<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Sign Up</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/stylesheet.css">
</head>
<body>
<img class="logo" src="${pageContext.request.contextPath}/css/Resources/JustEat.png">
<div class="content">
    <h1>Sign in</h1>
    <fieldset>
    <h3>Login with:</h3>
        <input type="button" id="facebook" >
        <input type="button" id="google" >
    <h3>Or</h3>
    <form method="post" action="?">
    	<div>
        <label for="email">Email</label><br>
        <input type="email" id="mail" name="email"><br>
        </div>
        <div>
        <label for="password">Password</label><br>
        <input type="password" id="password" name="password"><br>
        </div>
        <div>
        <input type="checkbox" id="forgetpass"> Guardar sesión <br>
 		</div>       
        <a href="${pageContext.request.contextPath}/RegisterServlet">¿No tienes cuenta? Regístrate</a><br>
        <input type="submit" id="signin" value="Sign in">
    </form>  
    </fieldset>
</div>
</body>
</html>