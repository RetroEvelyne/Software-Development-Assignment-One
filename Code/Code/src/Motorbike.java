public class Motorbike extends Vehicle {
    private final boolean hasSideCar;

    public Motorbike(String make, String model, int year, String registrationNumber, boolean hasSideCar) {
        super(make, model, year, registrationNumber);
        this.hasSideCar = hasSideCar;
    }

    public int getDailyRate() {
        return 150; }

    @Override
    public String toString() {
        return "Motorbike{" +
                "available=" + available +
                ", hasSideCar=" + hasSideCar +
                ", make='" + make + "'" +
                ", model='" + model + "'" +
                ", year=" + year +
                ", registrationNumber='" + registrationNumber + "'" +
                '}';
    }
}
