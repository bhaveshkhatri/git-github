ctrl1 = new TemperatureCtrl();


//1. When an end user enter a number into the list .
describe("TemperatureCtrl.recordTemperature(): 1. when we pass correct input as a number", function () {

    it("should return Temperature added successfully", function () {
        expect(ctrl1.recordTemperature(2)).toEqual('Temperature added successfully');
    });
});

//2. When the end user enters a String instead of a number.
describe("TemperatureCtrl.recordTemperature(): 2. when we pass a String instead of a number", function () {

    it("should return You entered wrong input!", function () {
        expect(ctrl1.recordTemperature('chinna')).toEqual('You entered wrong input!');
    });
});

//3. When the end user enter nothing in the text box
describe("TemperatureCtrl.recordTemperature(): 3. when we pass nothind or 'undefined' instead of a number", function () {

    it("should return You entered wrong input!", function () {
        expect(ctrl1.recordTemperature()).toEqual('You entered wrong input!');
    });
});

//4. When the end user enter the temperature which is already existed in the list.
describe("TemperatureCtrl.recordTemperature(): 4. when we pass a number which is already existed in the list", function () {

    ctrl1.recordTemperature(11);
    it("should return You entered the same temperature again!", function () {
        expect(ctrl1.recordTemperature(11)).toEqual('You entered the same temperature again!');
    });
});  