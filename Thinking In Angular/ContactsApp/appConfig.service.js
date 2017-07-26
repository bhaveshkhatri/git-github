(function () {
    var app = angular.module("ContactsApp");
    app.service("AppDataServvice", function AppConfig(AppNameSvc) {
        //var this = {};
        this.name = AppNameSvc;
        this.author = "Chinna";
        this.buildDate = new Date().toDateString();
        //return this;
    });
})();   