import java.util.ArrayList;

public class PrettyPrint {
    public static void printVehicles(ArrayList<Vehicle> vehicles) {
        if (vehicles.isEmpty()) {
            System.out.println("No vehicles found");
            return;
        }
        if (vehicles.size() == 1) {
            System.out.println("01. ─ "+vehicles.getFirst());
            return;
        }
        if (vehicles.size() == 2) {
            System.out.println("01. ╭─ "+vehicles.getFirst());
            System.out.println("02. ╰─ "+vehicles.getLast());
            return;
        }
        System.out.println("01. ╭─ "+vehicles.getFirst());
        for (int i = 1; i < vehicles.size()-1; i++) { System.out.println("0"+(i+1)+". ├─ "+vehicles.get(i)); }
        System.out.println((vehicles.size()+1)+". ╰─ "+vehicles.getLast());

        // I understand that this is a terrible function that will not work in any other case
        // I repent for my sins.
    }


}
