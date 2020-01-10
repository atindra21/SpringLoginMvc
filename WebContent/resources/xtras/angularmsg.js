var myapp = angular.module("myApp",[]);
myapp.controller("userCtrl",['$scope', '$http', function($scope,$http){
	$scope.displayUserDetails = function(){
		$http.get('userdetails',
			function (response) { 
				alert("this is "+response+"hdhg");
				$scope.results = response; 
			}
		);
	}
	alert('End');
}]);