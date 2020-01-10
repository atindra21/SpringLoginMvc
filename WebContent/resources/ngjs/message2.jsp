<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
	<head>
		<title>Message Page</title>
		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
		<script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/angularjs/1.6.4/angular.js"></script>
		<script	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
		<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
		<link href="<c:url value="/resources/css/message.css" />" rel="stylesheet">
		<script type="text/javascript" src="<c:url value="/resources/ngjs/message.js" />"></script>
	</head>
 <body ng-app="newapp" ng-controller="msgcontroller">
	<div id="page_header">
		<span id="pagetitle">Messenger</span>
		<span class="dropdown">
			<span class="glyphicon glyphicon-user" id="dropimg"></span>
  				<span class="dropdown-content">
  					<a href="settings">Settings</a>
    				<a href="login">Logout</a>
  				</span>
		</span>
	</div><br>
	<h4>Welcome ${userFullName} !</h4><br>
	<div id="restPage">
		<h3>Add Message </h3>
		<div id= "form">
			<img src="https://www.listefit.com/wp-content/uploads/2017/12/tiny-png-google-g%C3%B6rsel-optimizasyonu.jpg" width="320" class="img-rounded" id ="panda"/><br><br>
			<table id ="messageformtable">
				<tr>
					<td>Name</td>
					<td><input id="name" class="form-control" required placeholder="enter name"/></td>
				</tr>
				<tr><td style="color: white">.</td></tr>
				<tr>
					<td>Message</td>
					<td><input id="message" class="form-control" required placeholder="enter message"/></td>
				</tr>
			</table><br>
		</div>
		<button id="add_button" class="btn btn-success" ng-click="addMessage()" disabled="disabled">Add</button><br>
		<button id="see_table_id" class="btn btn-success" ng-click="viewMessages()">See All Messages</button><br>
		<table id="table" border="1" class="table table-hover">
			<tr id ="row_head" hidden="hidden">
				<th class="name">NAME</th>
				<th class="message">MESSAGE</th>
				<th>DELETE</th>
			</tr>
			<tr ng-repeat = "value in values" class="allMessage">
        		<td>{{value.name}}</td>
        		<td>{{value.message}}</td>
      			<td><img src="http://www.sharmatransports.com/images/close.jpg" width="35" height="35" style=" border-radius: 50%;cursor: pointer;"
      					 ng-click="deleteByImage()" id="{{value.id}}"></td>
      		</tr>
		</table>
	</div>
 </body>
</html>