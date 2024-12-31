
public class Main {

public static void main(String[] args) {
    System.out.println("Welcome to Advance Courier Service!");

    // Initialize the courier service
    CourierService courierService = new CourierService();

    // Add some sample data
    courierService.addPackage(new Package("123", "New York", "Los Angeles", 5.0));
    courierService.addPackage(new Package("456", "Chicago", "Houston", 10.0));

    // Display all packages
    courierService.displayAllPackages();
}
}