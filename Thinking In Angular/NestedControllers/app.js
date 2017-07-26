var app = angular.module("nestedControllers", []);

app.controller("ctrl1", ctrl1);
app.controller("ctrl2", ctrl2);

function ctrl1() {
    this.testItem = "This is controller 1";
} 

function ctrl2() {
    this.testItem = "This is controller 2";
}
//llkkjfdj