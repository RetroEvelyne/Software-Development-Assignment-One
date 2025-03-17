public class NonElectricCar extends Car {
    private String fuelType;

    public NonElectricCar(String make, String model, int year, String registrationNumber, int numberOfDoors, String fuelType) {
        super(make, model, year, registrationNumber, numberOfDoors);
        this.fuelType = fuelType;
    }

    public int getDailyRate() {
        return 100; }

    @Override
    public String toString() {
        return "NonElectricCar{" +
                "available=" + available +
                ", fuelType='" + fuelType + "'" +
                ", numberOfDoors=" + numberOfDoors +
                ", make='" + make + "'" +
                ", model='" + model + "'" +
                ", year=" + year +
                ", registrationNumber='" + registrationNumber + "'" +
                '}';
    }
}