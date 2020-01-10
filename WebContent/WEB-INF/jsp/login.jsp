<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Login Page</title>
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"/>
	<link href="<c:url value="/resources/css/login.css" />" rel="stylesheet">
	<script type="text/javascript" src="<c:url value="/resources/js/login.js" />"></script>
</head>
<body>
	<div id="page_header">
		<span id ="pagetitle">Messenger</span>
	</div>
		<h4 class = "new">${newUserMessage}</h4>
		<h4 class = "error">${errorUserMessage}</h4><br><br>
		<div id = "loginform"> 
			<h3><br>
				<br><br>Log In<br>
			</h3><br>
			<form action="login" method="post" id="form1" >
				Username<br><input id= "idtext" type="text" name="uid" required/><br><br> 
				Password<br><input id= "passtext" type="password" name="pswd" required/><br><br>
				<input type="submit" id ="login_button" value="Login" class="btn btn-dark"/><br><br>
			</form>
			<div>
				<br>Not a member click <a href="register">here</a> to join.
			</div><br><br><br>
		</div>
</body>
</html>