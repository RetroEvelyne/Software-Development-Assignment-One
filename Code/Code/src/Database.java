import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Database {
    private static final String URL = "jdbc:mysql://localhost:3306/vehicledb";

    public static ArrayList<Vehicle> returnAllVehicles() {
        ArrayList<Vehicle> vehicles = new ArrayList<>();
        ArrayList<String> addedRegNums = new ArrayList<>();
        ResultSet resultVehicles = executeQuery("SELECT * FROM vehicle");
        ResultSet resultCars = executeQuery("SELECT * FROM car");
        ResultSet resultMotorbikes = executeQuery("SELECT * FROM motorbike");

        Map<Integer, Map<String, Object>> resultCarsMap = mapByVehicleId(resultCars);
        Map<Integer, Map<String, Object>> resultMotorbikesMap = mapByVehicleId(resultMotorbikes);

        try {
            while (resultVehicles.next()) {
                int vehicleid = resultVehicles.getInt("vehicleid");
                if (addedRegNums.contains(resultVehicles.getString("reg_num"))) {
                    continue;
                }
                switch (resultVehicles.getString("type")) {
                    case "Car":
                        Map<String, Object> car = resultCarsMap.get(vehicleid);
                        if (car == null) {
                            // System.out.println("Car not found"); // Commented out debug message
                            break;
                        }
                        switch ((String) car.get("category")) {
                            case "Electric":
                                vehicles.add(new ElectricCar(
                                    resultVehicles.getString("make"),
                                    resultVehicles.getString("model"),
                                    resultVehicles.getInt("year"),
                                    resultVehicles.getString("reg_num"),
                                    (Integer) car.get("num_doors"),
                                    (Integer) car.get("battery_range")
                                ));
                                addedRegNums.add(resultVehicles.getString("reg_num"));
                                break;
                            case "NonElectric":
                                vehicles.add(new NonElectricCar(
                                    resultVehicles.getString("make"),
                                    resultVehicles.getString("model"),
                                    resultVehicles.getInt("year"),
                                    resultVehicles.getString("reg_num"),
                                    (Integer) car.get("num_doors"),
                                    (String) car.get("fuel_type")
                                ));
                                addedRegNums.add(resultVehicles.getString("reg_num"));
                                break;
                            default:
                                System.out.println("Invalid value for car category");
                                System.exit(1);
                        }
                        break;
                    case "Motorbike":
                        Map<String, Object> motorbike = resultMotorbikesMap.get(vehicleid);
                        if (motorbike == null) {
                            //System.out.println("Motorbike not found"); // Commented out debug message
                            break;
                        }
                        boolean has_sidecar = (boolean) motorbike.get("has_sidecar");
                        vehicles.add(new Motorbike(
                            resultVehicles.getString("make"),
                            resultVehicles.getString("model"),
                            resultVehicles.getInt("year"),
                            resultVehicles.getString("reg_num"),
                            has_sidecar
                        ));
                        addedRegNums.add(resultVehicles.getString("reg_num"));
                        break;
                    default:
                        System.out.println("Invalid value for vehicle type");
                        System.exit(1);
                }
            }
        } catch (Exception e) { System.out.println("AAAAA"+e); }

        return vehicles;
    }

    private static Map<Integer, Map<String, Object>> mapByVehicleId(ResultSet rs) {
        // Map the result set by vehicleid
        HashMap<Integer, Map<String, Object>> map = new HashMap<>();
        try {
            while (rs.next()) {
                Map<String, Object> row = new HashMap<>();
                for (int i = 1; i <= rs.getMetaData().getColumnCount(); i++) {
                    row.put(rs.getMetaData().getColumnName(i), rs.getObject(i));
                }

                map.put(rs.getInt("vehicleid"), row);
            }
        } catch (Exception e) { System.out.println("mapByVehicleId "+e); }

        return map;
    }

    private static ResultSet executeQuery(String query) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection conn = DriverManager.getConnection(URL, "root", "");
            return conn.createStatement().executeQuery(query);
        } catch (Exception e) {
            System.out.println(e);
            System.exit(1);
        }
        return null; // Unhappy that this is necessary
    }
}
