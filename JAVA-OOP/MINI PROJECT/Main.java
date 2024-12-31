import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    static class Product {
        private String name;
        private double price;
        private int quantity;

        public Product(String name, double price, int quantity) {
            this.name = name;
            this.price = price;
            this.quantity = quantity;
        }

        public String getName() {
            return name;
        }

        public double getPrice() {
            return price;
        }

        public int getQuantity() {
            return quantity;
        }

        public void setQuantity(int quantity) {
            this.quantity = quantity;
        }
    }

    static class Customer {
        private String name;
        private String address;
        private String phoneNumber;

        public Customer(String name, String address, String phoneNumber) {
            this.name = name;
            this.address = address;
            this.phoneNumber = phoneNumber;
        }

        public String getName() {
            return name;
        }

        public String getAddress() {
            return address;
        }

        public String getPhoneNumber() {
            return phoneNumber;
        }
    }

    static class Order {
        private Customer customer;
        private ArrayList<Product> products;
        private double totalCost;
        private String deliveryAddress;
        private String deliveryDate;

        public Order(Customer customer, ArrayList<Product> products, String deliveryAddress, String deliveryDate) {
            this.customer = customer;
            this.products = products;
            this.deliveryAddress = deliveryAddress;
            this.deliveryDate = deliveryDate;
            calculateTotalCost();
        }

        public Customer getCustomer() {
            return customer;
        }

        public ArrayList<Product> getProducts() {
            return products;
        }

        public double getTotalCost() {
            return totalCost;
        }

        public String getDeliveryAddress() {
            return deliveryAddress;
        }

        public String getDeliveryDate() {
            return deliveryDate;
        }

        private void calculateTotalCost() {
            totalCost = 0;
            for (Product product : products) {
                totalCost += product.getPrice() * product.getQuantity();
            }
        }

        public void displayOrder() {
            System.out.println("Order Details:");
            System.out.println("Customer Name: " + customer.getName());
            System.out.println("Delivery Address: " + deliveryAddress);
            System.out.println("Delivery Date: " + deliveryDate);
            System.out.println("Products:");
            for (Product product : products) {
                System.out.println("- " + product.getName() + " (Quantity: " + product.getQuantity() + ")");
            }
            System.out.println("Total Cost: " + totalCost);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Create a list to store available products
        ArrayList<Product> availableProducts = new ArrayList<>();
        availableProducts.add(new Product("Laptop", 1200, 5));
        availableProducts.add(new Product("Smartphone", 800, 10));
        availableProducts.add(new Product("Tablet", 300, 20));

        // Create a list to store orders
        ArrayList<Order> orders = new ArrayList<>();

        int choice;
        do {
            System.out.println("\nAdvanced Courier Service Menu:");
            System.out.println("1. Place an Order");
            System.out.println("2. View Orders");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");

            choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character

            switch (choice) {
                case 1:
                    // Get customer details
                    System.out.println("\nEnter Customer Details:");
                    System.out.print("Name: ");
                    String customerName = scanner.nextLine();
                    System.out.print("Address: ");
                    String customerAddress = scanner.nextLine();
                    System.out.print("Phone Number: ");
                    String customerPhoneNumber = scanner.nextLine();
                    Customer customer = new Customer(customerName, customerAddress, customerPhoneNumber);

                    // Get order details
                    ArrayList<Product> orderProducts = new ArrayList<>();
                    do {
                        System.out.println("\nAvailable Products:");
                        for (int i = 0; i < availableProducts.size(); i++) {
                            System.out.println((i + 1) + ". " + availableProducts.get(i).getName() + " (Price: "
                                    + availableProducts.get(i).getPrice() + ")");
                        }

                        System.out.print("Select a product (enter 0 to finish): ");
                        int productChoice = scanner.nextInt();
                        scanner.nextLine(); // Consume the newline character

                        if (productChoice == 0) {
                            break;
                        } else if (productChoice > 0 && productChoice <= availableProducts.size()) {
                            Product selectedProduct = availableProducts.get(productChoice - 1);

                            System.out.print("Enter quantity: ");
                            int quantity = scanner.nextInt();
                            scanner.nextLine(); // Consume the newline character

                            if (quantity > 0 && quantity <= selectedProduct.getQuantity()) {
                                orderProducts.add(
                                        new Product(selectedProduct.getName(), selectedProduct.getPrice(), quantity));
                                selectedProduct.setQuantity(selectedProduct.getQuantity() - quantity);
                            } else {
                                System.out.println("Invalid quantity. Please enter a valid quantity.");
                            }
                        } else {
                            System.out.println("Invalid product choice.");
                        }
                    } while (true);

                    // Get delivery details
                    System.out.print("Enter delivery address: ");
                    String deliveryAddress = scanner.nextLine();
                    System.out.print("Enter delivery date (YYYY-MM-DD): ");
                    String deliveryDate = scanner.nextLine();

                    // Create the order
                    Order order = new Order(customer, orderProducts, deliveryAddress, deliveryDate);
                    orders.add(order);

                    // Display order summary
                    System.out.println("\nOrder placed successfully!");
                    order.displayOrder();
                    break;

                case 2:
                    if (orders.isEmpty()) {
                        System.out.println("No orders placed yet.");
                    } else {
                        System.out.println("\nAll Orders:");
                        for (int i = 0; i < orders.size(); i++) {
                            System.out.println((i + 1) + ".");
                            orders.get(i).displayOrder();
                            System.out.println("-----");
                        }
                    }
                    break;

                case 3:
                    System.out.println("Exiting...");
                    break;

                default:
                    System.out.println("Invalid choice.");
            }
        } while (choice != 3);

        scanner.close();
    }
}