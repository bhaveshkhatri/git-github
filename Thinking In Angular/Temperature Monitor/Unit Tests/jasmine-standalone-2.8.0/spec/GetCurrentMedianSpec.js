//1. When the end user have not passed any temperatures to the list but, trying to get the median.
describe("TemperatureCtrl.getCurrentMedian(): 1. when we have no values in the list", function () {

    ctrl2 = new TemperatureCtrl();
    it("should return Temperature added successfully", function () {
        expect(ctrl2.getCurrentMedian()).toEqual('Invalid action!');
    });
});


//2. When we have even number of temperatures in the list.s
describe("TemperatureCtrl.getCurrentMedian(): 2. when we have even number of temperature values in the list",
    function () {

        ctrl3 = new TemperatureCtrl();
        ctrl3.recordTemperature(10);
        ctrl3.recordTemperature(20);
        ctrl3.recordTemperature(30);
        ctrl3.recordTemperature(40);

        it("should return 25", function () {
            expect(ctrl3.getCurrentMedian()).toEqual(25);
        });
    });
    

//3. When we have odd number of temperatures in the list.s
describe("TemperatureCtrl.getCurrentMedian(): 3. when we have odd number of temperature values in the list",
    function () {

        ctrl4 = new TemperatureCtrl();
        ctrl4.recordTemperature(-10);
        ctrl4.recordTemperature(20);
        ctrl4.recordTemperature(30);
        ctrl4.recordTemperature(40);
        ctrl4.recordTemperature(50);
       

        it("should return 30", function () {
            expect(ctrl4.getCurrentMedian()).toEqual(30);
        });
    });