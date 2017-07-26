(function () {
    var app = angular.module("ContactsApp");
    app.service("ContactDataSvc", function ($http) {

        var self = this;

        self.getContacts = function() {
            var promise1 = $http.get("http://localhost:8080/Calendar/webapi/appointments");
            var promise2 = promise1.then(function(response) {
                return response.data;
            });
            return promise2;
        }

       self.saveUser = function (userData) {

            return $http.put("http://localhost:8080/Calendar/webapi/appointments/"+userData.aid, userData)
                    .then(function(response) {
                        console.log(response);
                    });
        };

        self.createUser = function (userData) {
            userData.adate = userData.adate+"T00:00:00";
            userData.atime = "1970-01-01T"+userData.atime;
            return $http.post("http://localhost:8080/Calendar/webapi/appointments", userData)
                    .then(function(response) {
                        console.log(response);
                    });
        };

        self.deleteAppointment = function(userData) {
            return $http.delete("http://localhost:8080/Calendar/webapi/appointments/"+userData.aid)
                        .then(function(response) {
                            return response.data;
                        });
        };

    });
})();