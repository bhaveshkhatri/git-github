var app = angular.module("temperatureMonitor", []);
app.controller("TemperatureCtrl", TemperatureCtrl);

function TemperatureCtrl() {

    var listOfTemperatures = [];
    var length = 0;
    var median = "";
    var position = 0;
    var errorMessage = "", successMessage = "";

    //To add the temperature to the list.
    this.recordTemperature = function (temperature) {
        //To validate weather the entered data is a number or not.
        if (isNaN(temperature) || temperature === undefined) {
            this.successMessage = "";
            this.errorMessage = "You entered wrong input!";
            return this.errorMessage;
        }

        //To verify weather the entered a temperature that is already exists in the list.
        for (var i = 0; i < listOfTemperatures.length; i++) {
            if (listOfTemperatures[i] === parseInt(temperature)) {
                this.successMessage = "";
                this.errorMessage = "You entered the same temperature again!";
                return this.errorMessage;
            }
        }

        //Adding the temperature to the list and sorting the list.
        listOfTemperatures.push(parseInt(temperature));
        this.listOfTemperatures = listOfTemperatures.sort(function (a, b) { return a - b });
        this.temperature = undefined;
        this.median = "";
        this.errorMessage = "";
        this.successMessage = "Temperature added successfully";
        return this.successMessage;
    }

    //To caleculate the median of the temperatures.
    this.getCurrentMedian = function () {

        length = listOfTemperatures.length;

        if (length === 0) {
            this.errorMessage = "Invalid action!";
            this.median = "";
            return this.errorMessage;
        }

        //When the list contains even number of temperatures.
        if (length % 2 === 0) {
            position = length / 2 - 1;
            this.median = (listOfTemperatures[position] + listOfTemperatures[position + 1]) / 2;
            this.successMessage = "";
            this.errorMessage = "";
            return this.median;
        }
        //When the list contians odd number of temparatures.
        else {
            position = (length + 1) / 2 - 1;
            this.median = listOfTemperatures[position];
            this.successMessage = "";
            this.errorMessage = "";
            return this.median;
        }
    }

}