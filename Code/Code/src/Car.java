public abstract class Car extends Vehicle {
    protected int numberOfDoors;

    public Car(String make, String model, int year, String registrationNumber, int numberOfDoors) {
        super(make, model, year, registrationNumber);
        this.numberOfDoors = numberOfDoors;
    }

    @Override
    public String toString() {
        return "Car{" +
                "available=" + available +
                ", numberOfDoors=" + numberOfDoors +
                ", make='" + make + "'" +
                ", model='" + model + "'" +
                ", year=" + year +
                ", registrationNumber='" + registrationNumber + "'" +
                '}';
    }
}
