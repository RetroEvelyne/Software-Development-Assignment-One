import java.util.ArrayList;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        // Create a new rental company
        // Create a new customer
        // Get all vehicle data from database
        // Get all customer data from database??
        // List all vehicles

        CherryCars cherryCars = new CherryCars();
        Customer customer = new Customer("123ABC");

        while (true) {
            System.out.println("--- Cherry Rental Company ---");
            System.out.println("1. List all vehicles");
            System.out.println("2. Search for a vehicle by make");
            System.out.println("3. Search for a vehicle using a search term");
            System.out.println("4. Rent a vehicle");
            System.out.println("5. Return a vehicle");
            System.out.println("6. Calculate cost of a rental");
            System.out.println("7. List all currently rented vehicles");
            System.out.println("8. List all previously rented vehicles");
            System.out.println("9. Exit");
            System.out.println("-----------------------------");
            String userInput = input("Enter a number to select an option:");

            switch (userInput) {
                case "1": // Print all vehicles
                    PrettyPrint.printVehicles(cherryCars.getAllVehicles());
                    input();
                    break;
                case "2": // Search for a vehicle by make
                    PrettyPrint.printVehicles(cherryCars.searchVehiclesByMake(input("Enter a make:")));
                    input();
                    break;
                case "3": // Search for a vehicle using a search term
                    PrettyPrint.printVehicles(cherryCars.searchVehicles(input("Enter a search term:")));
                    input();
                    break;
                case "4": // Rent a vehicle
                    boolean rentSuccess = false;
                    PrettyPrint.printVehicles(cherryCars.getAllAvailableVehicles());
                    String regNumToRent = input("Enter the registration number of the vehicle you want to rent:");
                    ArrayList<Vehicle> availableVehicles = cherryCars.getAllAvailableVehicles();
                    for (Vehicle vehicle : availableVehicles) {
                        if (vehicle.getRegistrationNumber().equalsIgnoreCase(regNumToRent)) {
                            customer.rentVehicle(vehicle);
                            vehicle.setAvailable(false);
                            vehicle.setCustomerLicenseNumber(customer.getLicenceNumber());
                            System.out.println("Vehicle rented successfully");
                            rentSuccess = true;
                            break;
                        }
                    }
                    if (!rentSuccess) System.out.println("Vehicle not found");
                    input();
                    break;
                case "5": // Return a vehicle
                    boolean returnSuccess = false;
                    PrettyPrint.printVehicles(customer.getCurrentRentedVehicles());
                    String regNumToReturn = input("Enter the registration number of the vehicle you want to return:");
                    ArrayList<Vehicle> rentedVehicles = customer.getCurrentRentedVehicles();
                    for (Vehicle vehicle : rentedVehicles) {
                        if (vehicle.getRegistrationNumber().equalsIgnoreCase(regNumToReturn)) {
                            customer.returnVehicle(vehicle);
                            vehicle.setAvailable(true);
                            vehicle.setCustomerLicenseNumber();
                            System.out.println("Vehicle returned successfully");
                            returnSuccess = true;
                            break;
                        }
                    }
                    if (!returnSuccess) System.out.println("Vehicle not found");
                    input();
                    break;
                case "6": // Calculate cost of a rental
                    PrettyPrint.printVehicles(cherryCars.getAllVehicles());
                    String regNumToCalculate = input("Enter the registration number of the vehicle you want to calculate the cost of:");
                    ArrayList<Vehicle> rentedVehiclesToCalculate = cherryCars.getAllVehicles();
                    for (Vehicle vehicle : rentedVehiclesToCalculate) {
                        if (vehicle.getRegistrationNumber().equalsIgnoreCase(regNumToCalculate)) {
                            int days = Integer.parseInt(input("Enter the number of days you want to rent the vehicle for:"));
                            System.out.println("The cost of renting this vehicle for "+days+" days is: £"+ cherryCars.calculateCostOfRental(vehicle, days));
                            break;
                        }
                    }
                    input();
                    break;
                case "7": // List all currently rented vehicles
                    PrettyPrint.printVehicles(customer.getCurrentRentedVehicles());
                    input();
                    break;
                case "8": // List all previously rented vehicles
                    PrettyPrint.printVehicles(customer.getPreviousRentedVehicles());
                    input();
                    break;
                case "9": // Exit
                    System.out.println("Exiting..."); // If we were to update the data at all, we could add a save function here
                    System.exit(-1);
                default:
                    System.out.println("Invalid input");
                    input();
                    break;
            }
        }
    }

    public static void input() {
        System.out.println("Press enter to continue...");
        Scanner scanner = new Scanner(System.in);
        scanner.nextLine();
    }

    public static String input(String msg) {
        System.out.println(msg);
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }
}
