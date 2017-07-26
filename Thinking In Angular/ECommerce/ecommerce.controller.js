(function() {

   var app = angular.module("ECommerceApp");
   app.controller("ECommerceCtrl", ECommerceCtrl);


   function ECommerceCtrl(ECommerceDataSvc) {

        
         var self = this;

        this.login = function() {
            var loginid = this.lid;
            var password = this.pwd;
            ECommerceDataSvc.getCustomer(loginid, password)
                                .then(function(data) {
                                    self.customer = data;
                                   
                                    if(self.customer.cid!=undefined) 
                                        self.logged = true;
                                        else 
                                        self.logged = false;
                                        console.log(self.logged);
                                        console.log(self.customer.cid);
                                });
        }

   }


})();