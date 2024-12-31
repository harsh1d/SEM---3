import java.io.*;
import java.util.*;

enum Status {
    IN_TRANSIT, DELIVERED, PENDING, RETURNED;
}

class Courier {
    private String trackingNumber;
    private String sender;
    private String receiver;
    private Status status;

    public Courier(String trackingNumber, String sender, String receiver, Status status) {
        this.trackingNumber = trackingNumber;
        this.sender = sender;
        this.receiver = receiver;
        this.status = status;
    }

    public String getTrackingNumber() {
        return trackingNumber;
    }

    public String getSender() {
        return sender;
    }

    public String getReceiver() {
        return receiver;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Tracking Number: " + trackingNumber + ", Sender: " + sender + ", Receiver: " + receiver + ", Status: "
                + status;
    }
}

class CourierService {
    private List<Courier> couriers;
    private final String FILE_NAME = "couriers.txt";

    public CourierService() {
        couriers = new ArrayList<>();
        loadCouriers();
    }

    public void addCourier(Courier courier) {
        couriers.add(courier);
        saveCouriers();
    }

    public Courier trackCourier(String trackingNumber) {
        for (Courier courier : couriers) {
            if (courier.getTrackingNumber().equals(trackingNumber)) {
                return courier;
            }
        }
        return null;
    }

    public void updateStatus(String trackingNumber, Status status) {
        Courier courier = trackCourier(trackingNumber);
        if (courier != null) {
            courier.setStatus(status);
            saveCouriers();
        } else {
            System.out.println("Courier not found!");
        }
    }

    public void displayAllCouriers() {
        if (couriers.isEmpty()) {
            System.out.println("No couriers available.");
        } else {
            for (Courier courier : couriers) {
                System.out.println(courier);
            }
        }
    }

    public void searchBySender(String sender) {
        boolean found = false;
        for (Courier courier : couriers) {
            if (courier.getSender().equalsIgnoreCase(sender)) {
                System.out.println(courier);
                found = true;
            }
        }
        if (!found) {
            System.out.println("No couriers found for sender: " + sender);
        }
    }

    public void searchByReceiver(String receiver) {
        boolean found = false;
        for (Courier courier : couriers) {
            if (courier.getReceiver().equalsIgnoreCase(receiver)) {
                System.out.println(courier);
                found = true;
            }
        }
        if (!found) {
            System.out.println("No couriers found for receiver: " + receiver);
        }
    }

    private void saveCouriers() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME))) {
            for (Courier courier : couriers) {
                writer.write(courier.getTrackingNumber() + "," + courier.getSender() + "," + courier.getReceiver() + ","
                        + courier.getStatus());
                writer.newLine();
            }
        } catch (IOException e) {
            System.out.println("Error saving couriers: " + e.getMessage());
        }
    }

    private void loadCouriers() {
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 4) {
                    String trackingNumber = parts[0];
                    String sender = parts[1];
                    String receiver = parts[2];
                    Status status = Status.valueOf(parts[3]);
                    Courier courier = new Courier(trackingNumber, sender, receiver, status);
                    couriers.add(courier);
                }
            }
        } catch (IOException e) {
            System.out.println("Error loading couriers: " + e.getMessage());
        } catch (IllegalArgumentException e) {
            System.out.println("Invalid status in file: " + e.getMessage());
        }
    }
}

public class Main {
    private static boolean authenticateUser() {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("Enter username: ");
            String username = scanner.nextLine();
            System.out.print("Enter password: ");
            String password = scanner.nextLine();
            // Add your authentication logic here
            return username.equals("admin") && password.equals("password");
        }
    }

    private static void displayMenu() {
        System.out.println("1. Add Courier");
        System.out.println("2. Track Courier");
        System.out.println("3. Update Courier Status");
        System.out.println("4. Display All Couriers");
        System.out.println("5. Search by Sender");
        System.out.println("6. Search by Receiver");
        System.out.println("7. Exit");
        System.out.print("Enter your choice: ");
    }

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            CourierService service = new CourierService();

            if (authenticateUser()) {
                System.out.println("Authentication successful!");
                boolean exit = false;
                while (!exit) {
                    displayMenu();
                    int choice = -1;
                    try {
                        choice = Integer.parseInt(scanner.nextLine());
                    } catch (NumberFormatException e) {
                        System.out.println("Invalid input! Please enter a number.");
                        continue;
                    }

                    switch (choice) {
                        case 1:
                            System.out.print("Enter tracking number: ");
                            String trackingNumber = scanner.nextLine();
                            System.out.print("Enter sender: ");
                            String sender = scanner.nextLine();
                            System.out.print("Enter receiver: ");
                            String receiver = scanner.nextLine();
                            System.out.print("Enter status (IN_TRANSIT, DELIVERED, PENDING, RETURNED): ");
                            Status status;
                            try {
                                status = Status.valueOf(scanner.nextLine().toUpperCase());
                            } catch (IllegalArgumentException e) {
                                System.out.println("Invalid status! Please enter one of the following: IN_TRANSIT, DELIVERED, PENDING, RETURNED.");
                                break;
                            }
                            service.addCourier(new Courier(trackingNumber, sender, receiver, status));
                            System.out.println("Courier added successfully!");
                            break;
                        case 2:
                            System.out.print("Enter tracking number to track: ");
                            trackingNumber = scanner.nextLine();
                            Courier courier = service.trackCourier(trackingNumber);
                            if (courier != null) {
                                System.out.println(courier);
                            } else {
                                System.out.println("Courier not found!");
                            }
                            break;
                        case 3:
                            System.out.print("Enter tracking number to update: ");
                            trackingNumber = scanner.nextLine();
                            System.out.print("Enter new status (IN_TRANSIT, DELIVERED, PENDING, RETURNED): ");
                            try {
                                status = Status.valueOf(scanner.nextLine().toUpperCase());
                            } catch (IllegalArgumentException e) {
                                System.out.println("Invalid status! Please enter one of the following: IN_TRANSIT, DELIVERED, PENDING, RETURNED.");
                                break;
                            }
                            service.updateStatus(trackingNumber, status);
                            System.out.println("Courier status updated successfully!");
                            break;
                        case 4:
                            service.displayAllCouriers();
                            break;
                        case 5:
                            System.out.print("Enter sender to search: ");
                            sender = scanner.nextLine();
                            service.searchBySender(sender);
                            break;
                        case 6:
                            System.out.print("Enter receiver to search: ");
                            receiver = scanner.nextLine();
                            service.searchByReceiver(receiver);
                            break;
                        case 7:
                            exit = true;
                            System.out.println("Exiting the system. Goodbye!");
                            break;
                        default:
                            System.out.println("Invalid choice! Please try again.");
                    }
                }
            } else {
                System.out.println("Authentication failed!");
            }
        }
    }
}
