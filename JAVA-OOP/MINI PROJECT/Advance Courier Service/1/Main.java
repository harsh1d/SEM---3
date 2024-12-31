import java.util.ArrayList;
import java.util.Scanner;

class Courier {
    private String trackingNumber;
    private String sender;
    private String recipient;
    private String status;

    public Courier(String trackingNumber, String sender, String recipient) {
        this.trackingNumber = trackingNumber;
        this.sender = sender;
        this.recipient = recipient;
        this.status = "In Transit";
    }

    public String getTrackingNumber() {
        return trackingNumber;
    }

    public String getSender() {
        return sender;
    }

    public String getRecipient() {
        return recipient;
    }

    public String getStatus() {
        return status;
    }

    public void updateStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Tracking Number: " + trackingNumber + ", Sender: " + sender + ", Recipient: " + recipient + ", Status: " + status;
    }
}

class CourierService {
    private ArrayList<Courier> couriers;

    public CourierService() {
        couriers = new ArrayList<>();
    }

    public void addCourier(Courier courier) {
        couriers.add(courier);
    }

    public Courier findCourier(String trackingNumber) {
        for (Courier courier : couriers) {
            if (courier.getTrackingNumber().equals(trackingNumber)) {
                return courier;
            }
        }
        return null;
    }

    public void updateCourierStatus(String trackingNumber, String status) {
        Courier courier = findCourier(trackingNumber);
        if (courier != null) {
            courier.updateStatus(status);
        } else {
            System.out.println("Courier not found.");
        }
    }

    public void listAllCouriers() {
        for (Courier courier : couriers) {
            System.out.println(courier);
        }
    }
}

public class Main {
    public static void main(String[] args) {
        System.out.println("Welcome to Advance Courier Service");
        Scanner scanner = new Scanner(System.in);
        CourierService courierService = new CourierService();

        while (true) {
            System.out.println("\n1. Add Courier");
            System.out.println("2. Update Courier Status");
            System.out.println("3. List All Couriers");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter Tracking Number: ");
                    String trackingNumber = scanner.nextLine();
                    System.out.print("Enter Sender: ");
                    String sender = scanner.nextLine();
                    System.out.print("Enter Recipient: ");
                    String recipient = scanner.nextLine();
                    Courier courier = new Courier(trackingNumber, sender, recipient);
                    courierService.addCourier(courier);
                    break;
                case 2:
                    System.out.print("Enter Tracking Number: ");
                    trackingNumber = scanner.nextLine();
                    System.out.print("Enter New Status: ");
                    String status = scanner.nextLine();
                    courierService.updateCourierStatus(trackingNumber, status);
                    break;
                case 3:
                    courierService.listAllCouriers();
                    break;
                case 4:
                    System.out.println("Exiting...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}