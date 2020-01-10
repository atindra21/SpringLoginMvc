var myapp = angular.module("regapp",[]);
myapp.controller("regcontroller",function($scope,$http){	
	$scope.$watch("myUserName", function () {
        	$http({
    			method : "GET",
    	    	url : "getusers"
    		}).then	(function successCallback(response) {
    			console.log('success');
    			var userlist = response.data;
    			console.log(userlist);
    			var condition = true; 
    			angular.forEach(userlist,function(key){
    		    	console.log('this is '+key);
    		    	if(condition){
    		    		if($scope.myUserName == key){
    		    			console.log('used '+key);
    		    			$scope.isUserNameDisabled = true;
    		    			$scope.message = 'Username already in use';
    		    			condition = false;
    		    		}
    		    		else{
    		    			console.log('unused '+key);
    		    			$scope.isUserNameDisabled = false;
    		    			$scope.message = '';
    		    		}
    		    	}
    		    	else{
    		    		console.log('faliure in outer if condition');
    		    	}
    		    });
    		}, function errorCallback(xhr,error) {
    			alert('error - '+xhr+error);
    			console.log("this is "+error);
    		});
    });
});