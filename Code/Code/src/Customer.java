import java.util.ArrayList;

public class Customer {
    private String licenceNumber;
    private ArrayList<Vehicle> currentRentedVehicles = new ArrayList<>();
    private ArrayList<Vehicle> previousRentedVehicles = new ArrayList<>();

    public Customer(String licenceNumber) {
        this.licenceNumber = licenceNumber;
    }

    public String getLicenceNumber() {
        return licenceNumber;
    }

    public ArrayList<Vehicle> getCurrentRentedVehicles() {
        return currentRentedVehicles;
    }

    public ArrayList<Vehicle> getPreviousRentedVehicles() {
        return previousRentedVehicles;
    }

    public void rentVehicle(Vehicle vehicle) {
        currentRentedVehicles.add(vehicle);
    }

    public void returnVehicle(Vehicle vehicle) {
        try {
            currentRentedVehicles.remove(vehicle);
            previousRentedVehicles.add(vehicle);
        } catch (Exception e) {
            System.out.println("Vehicle not found in current rented vehicles");
        }
    }
}
