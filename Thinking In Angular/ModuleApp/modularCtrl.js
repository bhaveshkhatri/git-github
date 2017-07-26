var myApp = angular.module("myModule", []);
myApp.controller("modularCtrl", modFun);

function modFun() {

    this.message = "Hello!, this is modular programming!";
}