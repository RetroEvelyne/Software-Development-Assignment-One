public abstract class Vehicle {
    protected String make;
    protected String model;
    protected int year;
    protected String registrationNumber;
    protected String customerLicenseNumber;
    protected boolean available = true;
    protected int dailyRate;

    public Vehicle(String make, String model, int year, String registrationNumber) {
        this.make = make;
        this.model = model;
        this.year = year;
        this.registrationNumber = registrationNumber;
    }

    public String getRegistrationNumber() { return registrationNumber; }

    public String getMake() { return make; }

    public void setCustomerLicenseNumber(String customerLicenseNumber) {
        this.customerLicenseNumber = customerLicenseNumber;
    }

    public void setCustomerLicenseNumber() {
        this.customerLicenseNumber = null;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    public abstract int getDailyRate();

    @Override
    public String toString() {
        return "Vehicle{" +
                "available=" + available +
                ", make='" + make + "'" +
                ", model='" + model + "'" +
                ", year=" + year +
                ", registrationNumber='" + registrationNumber + "'" +
                '}';
    }

}
