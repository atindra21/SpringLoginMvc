var app = angular.module("myApp",[]);
app.controller("myController",function($scope,$http){
	$scope.isDisabledChangePassword = true;
	//fetching user details and password
	$http({
		method : "GET",
        url : "userdetails"
	}).then(function mysuccess(response) {
	        var userdetails = response.data;
	        console.log('res new '+userdetails);
	        angular.forEach(userdetails,function(key){
	    		$scope.gotPassword = key.password;
	    		console.log('this is '+$scope.gotPassword);
	        });
	  },function myerror(xhr,error) {
			alert('error - '+xhr+error);
			console.log("this is "+error);
	});
	
	//matching password details
	$scope.$watch("confirmPassword", function(value) {
		if(value.length>0){
			if ($scope.confirmPassword === $scope.newPassword ) {
				$scope.isDisabledChangePassword = false;
				$scope.isMatched="Password Matched";
			}
			else {
				$scope.isDisabledChangePassword = true;
				$scope.isMatched ="";
			}
		}
	 });

	//show and hide forms on click
	$scope.showhidepassform = function () {
		$scope.isVisiblePassForm = !$scope.isVisiblePassForm;
    }
	
	//change password 
	$scope.changePassword = function(){
		if($scope.oldPassword != '' | $scope.newPassword !='' | $scope.confirmPassword != '' ){
			$scope.isDisabledChangePassword = false;
			if ($scope.oldPassword === $scope.gotPassword){
				var newPassword =$scope.confirmPassword;
				$http({
					method:'POST',
					url:'updatepassword',
					params:{
						newPassword: newPassword
					}
				}).then(function successCallback(response) {
					console.log('password changed');
					$scope.isVisiblePassForm = !$scope.isVisiblePassForm;
					alert('password changed');
				},function myerror(xhr,error) {
					alert('error - '+xhr+error);
					console.log("this is "+error);
				});
			}
			else{
				alert('Incorrect password');
			}
		}
		else{
			$scope.isDisabledChangePassword = true;
		}
	};
});
/*
 * 
 	//binding the user details to elements
	var	details= $scope.userdetails;
	angular.forEach(details, function(value, key){
		$scope.firstname = value.firstname;
		$scope.lastname = value.lastname;
		$scope.phone = value.phone;
		gotPassword = value.password;
	});
	
	//update user details
	$scope.saveUser= function(){
		var dataObj ={
				firstname: $scope.firstname,
				lastname : $scope.lastname,
				phone: $scope.phone
		}
		var res = $http.post('/updateuser', dataObj);
		res.success(function(data, status, headers, config) {
			console.log(data+ 'sent');
		});
		res.error(function(data, status, headers, config) {
			alert( "failure message: " + JSON.stringify({data: data}));
		});
	}
	
	
	$scope.showhideuserform = function () {
		$scope.isVisibleProfile = !$scope.isVisibleProfile;
    }
	
	
	//reset the user details
	$scope.resetUser = function(){
		var elements = [] ;
	    elements = document.getElementsByClassName("userrow");

	    for(var i=0; i<elements.length ; i++){
	       elements[i].value = "" ;
	    }
	}
	$scope.reset = function(){
		var elements = [] ;
	    elements = document.getElementsByClassName("passrow");

	    for(var i=0; i<elements.length ; i++){
	       elements[i].value = "" ;
	    }
	}
*/