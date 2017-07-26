(function() {
     var app = angular.module("ECommerceApp");
     app.service("ECommerceDataSvc", function ($http) {

        var self = this;
        
        self.getCustomer = function(cEmail, cPassword) {
             var promise1 = $http.get("http://localhost:8080/customers/"+cEmail+"/"+cPassword);
             var promise2 = promise1.then(function(response) {
                  console.log("Hello");
                return response.data;
            });
            return promise2;
           
        }


     });


})();