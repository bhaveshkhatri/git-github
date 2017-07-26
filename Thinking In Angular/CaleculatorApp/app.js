var app = angular.module("caleculatorApp", []);

app.controller("caleculatorCtrl", caleculate);

function caleculate() {

     this.buttonClicked = function (button) {
        this.selectedButton = button;
    }

    this.computeResult = function() {
        console.log("cb");
        var number1 = parseFloat(this.input1);
        var number2 = parseFloat(this.input2);

        if(this.selectedButton === '+') {           
            this.resultValue = number1 + number2;
        }

        if(this.selectedButton === '-') {           
            this.resultValue = number1 - number2;
        }

        if(this.selectedButton === '*') {           
            this.resultValue = number1 * number2;
        }

        if(this.selectedButton === '/') {           
            this.resultValue = number1 / number2;
        }
    }
   
}
