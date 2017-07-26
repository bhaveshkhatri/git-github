var app = angular.module("MyApp", []);

app.controller("PostsCtrl", function($scope, $http) {
  $http.get('http://localhost:8080/Calender/webapi/appointments')
    .then(function(response) {
      $scope.posts = response.data;
          
    }).
    error(function(data, status, headers, config) {
      // log error
    });
});