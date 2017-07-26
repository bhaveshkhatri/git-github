 var module = angular.module("myApp", []);
        module.controller("MainCtrl", Mainfun);

        function Mainfun($scope) {

            var currentTime = new Date();
            $scope.userName = "";
            $scope.timeString = currentTime.toTimeString();            
            $scope.updateTime = function() {
                console.log("Button Clicked");
                var currentTime = new Date();  
                $scope.timeString = currentTime.toTimeString();
            }
        }
    
    