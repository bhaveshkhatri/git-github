var app = angular.module("modularApp", ["myModule", "ngTagsInput"]);
app.controller("myCtrl", fun1);

function fun1() {
    
    this.tags =  [
    { text: 'Tag1' },
    { text: 'Tag2' },
    { text: 'Tag3' }
  ];
}