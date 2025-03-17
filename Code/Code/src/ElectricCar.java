public class ElectricCar extends Car {
    private int milesPerCharge;

    public ElectricCar(String make, String model, int year, String registrationNumber, int numberOfDoors, int milesPerCharge) {
        super(make, model, year, registrationNumber, numberOfDoors);
        this.milesPerCharge = milesPerCharge;

    }

    public int getDailyRate() { return 120; }

    @Override
    public String toString() {
        return "ElectricCar{" +
                "available=" + available +
                ", milesPerCharge=" + milesPerCharge +
                ", numberOfDoors=" + numberOfDoors +
                ", make='" + make + "'" +
                ", model='" + model + "'" +
                ", year=" + year +
                ", registrationNumber='" + registrationNumber + "'" +
                '}';
    }
}
