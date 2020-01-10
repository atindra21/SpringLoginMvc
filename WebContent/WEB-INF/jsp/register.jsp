<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/angularjs/1.6.4/angular.min.js"></script>
		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
		<title>Register</title>
		<link href="<c:url value="/resources/css/register.css" />" rel="stylesheet">
	 	<script type="text/javascript" src="<c:url value="/resources/js/register.js" />"></script>
	</head>
	<body ng-app="regapp" ng-controller = "regcontroller">
	<h2 class="text-center">Messenger</h2>
	<br>
	<div id ="signupform"><br><br>
	<h3>Enter your details to register</h3>
	<form action="register" method="post" id= "form1" ><br><br>
		<table>
			<tr>
				<td>Username</td>
				<td>
					<input id="username" name="username" class="form-control" ng-model="myUserName" placeholder="enter username" required>
				</td>
			</tr>
			<tr>
				<td></td>
				<td><span id="isPresentID" ng-bind ="message"></span></td>
			</tr>
			<tr><td class = "blank">.</td></tr>
			<tr>
				<td>Password</td>
				<td><input type="password" name="password"class="form-control" required placeholder="enter password"></td>
			</tr>
			<tr><td class = "blank">.</td></tr>
			<tr>
				<td>First Name</td>
				<td><input name="firstname" class="form-control" required placeholder="enter firstname"></td>
			</tr>
			<tr><td class = "blank">.</td></tr>
			<tr>
				<td>Last Name</td>
				<td><input name="lastname" class="form-control" required placeholder="enter lastname"></td>
			</tr>
			<tr><td class = "blank">.</td></tr>
			<tr>
				<td>Contact No</td>
				<td><input type="number" name="phone" class="form-control" required placeholder="enter contact number"></td>
			</tr>
		</table>
		<br> <input id="button" type="submit" value="Sign up" class="btn btn-dark"  ng-disabled="isUserNameDisabled"/>
	</form>
	<div>
		<br/>Click <a href="login">here</a> to login.
	</div><br><br>
	</div>
	</body>
</html>