<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Settings</title>
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
	<script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/angularjs/1.6.4/angular.js"></script>
	<link href="<c:url value="/resources/css/settings.css" />" rel="stylesheet">
	<script	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
	<script type="text/javascript" src="<c:url value="/resources/js/settings.js" />"></script>
</head>
<body ng-app="myApp" ng-controller="myController" >
	<div id="page_header">
		<span id="pagetitle">Messenger</span>
	</div><br/><br/>
	<h2>Settings<br></h2>
	<div id ="setting form" ><br>
		<div id ="changepassword">
			<span class="titles" ng-click="showhidepassform()">Change Password</span><br/>
			<div id ="passwordTable" ng-show="isVisiblePassForm">
				<input type="{{ showPassword ? 'text' : 'password' }}" ng-model="oldPassword" placeholder="old password" class ="passrow"><br/><br/>
				<input type="{{ showPassword ? 'text' : 'password' }}" ng-model="newPassword"  placeholder="new password" class ="passrow"><br/><br/>
				<input type="{{ showPassword ? 'text' : 'password' }}" ng-model="confirmPassword" placeholder="confirm password" class ="passrow"><br><span id="isMatchedId">{{isMatched}}</span><br/>
				<input type="checkbox" ng-checked="showPassword" ng-model="showPassword"/>Show password<br/><br>
				<button ng-click="changePassword()" id="changepasswordbutton" class="btn btn-success" ng-disabled="isDisabledChangePassword">Change</button>
				<button ng-click="reset()" class="btn btn-danger" id="cancelpasswordbutton">Cancel</button><br/>
			</div>
		</div><br/><br/>
		<!-- <div id="about user">
			<span class="titles" ng-click="showhideuserform()">Edit Profile</span><br/>
			<div id="userDetailsTable" ng-show="isVisibleProfile">
				<div class="tablerow">
					<span class ="tabledatakey">First Name</span>
					<input placeholder="enter first name" class ="userrow" required>
				</div><br/>
				<div class="tablerow">
					<span class ="tabledatakey">Last Name</span>
					<input placeholder="enter lastname" class ="userrow" required>
				</div><br/>
				<div class="tablerow">
					<span class ="tabledatakey">Phone</span>
					<input type="number" class ="userrow" required placeholder="enter contact number">
				</div><br/>
				<button ng-click="saveUser()" class="btn btn-success">Save</button>
				<button ng-click="resetUser()" class="btn btn-danger">Cancel</button>
			</div>
		</div> -->
	</div>
</body>
</html>