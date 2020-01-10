//using sticky
$(document).ready(function(){
	window.onscroll = function() {
		myFunction()
	};
	var navbar = document.getElementById("page_header");
	var sticky = navbar.offsetTop;

	function myFunction() {
		if (window.pageYOffset > sticky) {
			navbar.classList.add("stickey");
		} else {
		    navbar.classList.remove("stickey");
		}
	}
});
var app = angular.module("newapp",[]);
app.controller("msgcontroller",function($scope,$http){
	$scope.values = [];
	//adding messages
	$scope.addMessage = function(){
		$http({
			method : "POST",
	        url : "save",
	        params :{
	        	name:$scope.name,
	        	message:$scope.message
	        }
		}).then(function mysuccess(responseData) {
			
			
		},function myerror(xhr,error) {
				alert('error - '+xhr+error);
				console.log("this is "+error);
		});
	}
	//viewing all messages in table
	$scope.viewMessages = function(){
		 $http.get("message2").then(function(response) {
		    alert(JSON.stringify(response));
		    var jsonObject = JSON.stringify(response);
			alert(responseGot.name+'my response');
			alert(responseGot.data+'my data');
			$("#row_head").show();
			$('tr.allMessage').remove();
			$("#add_button").removeAttr("disabled");
			$scope.store(responseGot.data);			
		});
	}
	$scope.store = function(data){
		console.log('pushing data');
		alert(data);
		$scope.values.push(data);
		alert('my new'+$scope.values);
	}
	$scope.deleteByImage = function(){
		$http({
			method : "POST",
	        url : "delete"
		}).then(function mysuccess(responseData) {
			
		},function myerror(xhr,error) {
				alert('error - '+xhr+error);
				console.log("this is "+error);
		});
	}
});