import java.util.ArrayList;

public class CherryCars {
    private ArrayList<Vehicle> vehicles;

    public CherryCars() {
        vehicles = Database.returnAllVehicles();
        makeAllVehiclesAvailable();
    }

    public void makeAllVehiclesAvailable() {
        for (Vehicle vehicle : vehicles) {
            vehicle.setAvailable(true);
        }
    }

    public ArrayList<Vehicle> getAllVehicles() {
        return vehicles;
    }

    public ArrayList<Vehicle> getAllAvailableVehicles() {
        ArrayList<Vehicle> availableVehicles = new ArrayList<>();
        for (Vehicle vehicle : vehicles) {
            if (vehicle.available) {
                availableVehicles.add(vehicle);
            }
        }
        return availableVehicles;
    }

    public int calculateCostOfRental(Vehicle vehicle, int days) {
        return vehicle.getDailyRate() * days;
    }

    public ArrayList<Vehicle> searchVehiclesByMake(String make) {
        ArrayList<Vehicle> searchResults = new ArrayList<>();
        for (Vehicle vehicle : vehicles) {
            if (vehicle.getMake().equalsIgnoreCase(make)) {
                searchResults.add(vehicle);
            }
        }
        return searchResults;
    }

    public ArrayList<Vehicle> searchVehicles(String searchTerm) {
        ArrayList<Vehicle> searchResults = new ArrayList<>();
        for (Vehicle vehicle : vehicles) {
            if (vehicle.toString().toLowerCase().contains(searchTerm.toLowerCase())) {
                searchResults.add(vehicle);
            }
        }
        return searchResults;
    }
}
