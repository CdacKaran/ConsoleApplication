package com.merchandise.consolepack;

import com.merchandise.entities.Customer;
import com.merchandise.entities.Supplier;
import com.merchandise.services.MerchandiseService;

import java.util.InputMismatchException;
import java.util.Scanner;

public class MerchandiseConsoleApp {
    private static final int MAX_ARRAY_SIZE = 5;
    private static MerchandiseService merchandiseService;

    public static void main(String[] args) {
        merchandiseService = new MerchandiseService();
        Scanner scanner = new Scanner(System.in);

        int choice;
        do {
            displayMenu();
            System.out.print("Enter your choice: ");
            try {
                choice = scanner.nextInt();
                scanner.nextLine();
                System.out.println();

                switch (choice) {
                    case 1:
                        addCustomer(scanner);
                        break;
                    case 2:
                        addSupplier(scanner);
                        break;
                    case 3:
                        displayCustomerReport();
                        break;
                    case 4:
                        displaySupplierReport();
                        break;
                    case 5:
                        searchCustomer(scanner);
                        break;
                    case 6:
                        searchSupplier(scanner);
                        break;
                    case 7:
                        System.out.println("Exiting the application...Thankyou for visiting..");
                        break;
                    default:
                        System.out.println("Invalid choice. Please try again.");
                        break;
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a valid number.");
                scanner.nextLine(); // Consume the invalid input
                choice = 0;
            }

            System.out.println();
        } while (choice != 7);

        scanner.close();
    }

    private static void displayMenu() {
        System.out.println("** Application for Merchandise Partner Tracking **");
        System.out.println("1. Add Customer");
        System.out.println("2. Add Supplier");
        System.out.println("3. Display Customer Report");
        System.out.println("4. Display Supplier Report");
        System.out.println("5. Search Customer");
        System.out.println("6. Search Supplier");
        System.out.println("7. Exit");
    }

    private static void addCustomer(Scanner scanner) {
        if (merchandiseService.getAllCustomers().size() >= MAX_ARRAY_SIZE) {
            System.out.println("Maximum limit reached. Cannot add more customers.");
            return;
        }

        Customer customer = new Customer();

        System.out.println("Enter Customer Details:");
        System.out.print("Partner ID: ");
        customer.setPartnerId(scanner.nextInt());
        scanner.nextLine(); // Consume the newline character

        System.out.print("Partner Name: ");
        customer.setPartnerName(scanner.nextLine());

        System.out.print("City: ");
        customer.setCity(scanner.nextLine());

        System.out.print("State: ");
        customer.setState(scanner.nextLine());

        System.out.print("Credit Limit: ");
        customer.setCreditLimit(scanner.nextDouble());
        scanner.nextLine(); // Consume the newline character

        System.out.print("Phone Number: ");
        customer.setPhoneNumber(scanner.nextLine());

        System.out.print("Email: ");
        customer.setEmail(scanner.nextLine());

        merchandiseService.saveCustomerDetails(customer);
        //System.out.println("Customer added successfully.");
    }

    private static void addSupplier(Scanner scanner) {
        if (merchandiseService.getAllSuppliers().size() >= MAX_ARRAY_SIZE) {
            System.out.println("Maximum limit reached. Cannot add more suppliers.");
            return;
        }

        Supplier supplier = new Supplier();

        System.out.println("Enter Supplier Details:");
        System.out.print("Partner ID: ");
        supplier.setPartnerId(scanner.nextInt());
        scanner.nextLine(); // Consume the newline character

        System.out.print("Partner Name: ");
        supplier.setPartnerName(scanner.nextLine());

        System.out.print("City: ");
        supplier.setCity(scanner.nextLine());

        System.out.print("State: ");
        supplier.setState(scanner.nextLine());

        System.out.print("Credit Balance: ");
        supplier.setCreditBalance(scanner.nextDouble());
        scanner.nextLine(); // Consume the newline character

        System.out.print("Driving License Number: ");
        supplier.setDrivingLicenseNumber(scanner.nextLine());

        merchandiseService.saveSupplierDetails(supplier);
        //System.out.println("Supplier added successfully.");
    }

    private static void displayCustomerReport() {
        System.out.println("Customer Report:");
        System.out.println("-------------------------------------------------------");
        for (Customer customer : merchandiseService.getAllCustomers()) {
            System.out.println("Partner ID: " + customer.getPartnerId());
            System.out.println("Partner Name: " + customer.getPartnerName());
            System.out.println("City: " + customer.getCity());
            System.out.println("State: " + customer.getState());
            System.out.println("Credit Limit: " + customer.getCreditLimit());
            System.out.println("Phone Number: " + customer.getPhoneNumber());
            System.out.println("Email: " + customer.getEmail());
            System.out.println("-------------------------------------------------------");
        }
    }

    private static void displaySupplierReport() {
        System.out.println("Supplier Report:");
        System.out.println("-------------------------------------------------------");
        for (Supplier supplier : merchandiseService.getAllSuppliers()) {
            System.out.println("Partner ID: " + supplier.getPartnerId());
            System.out.println("Partner Name: " + supplier.getPartnerName());
            System.out.println("City: " + supplier.getCity());
            System.out.println("State: " + supplier.getState());
            System.out.println("Credit Balance: " + supplier.getCreditBalance());
            System.out.println("Driving License Number: " + supplier.getDrivingLicenseNumber());
            System.out.println("-------------------------------------------------------");
        }
    }

    private static void searchCustomer(Scanner scanner) {
        System.out.print("Enter Customer ID to search: ");
        int customerId = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character

        Customer customer = merchandiseService.getCustomerById(customerId);
        if (customer != null) {
            System.out.println("Customer Details:");
            System.out.println("-------------------------------------------------------");
            System.out.println("Partner ID: " + customer.getPartnerId());
            System.out.println("Partner Name: " + customer.getPartnerName());
            System.out.println("City: " + customer.getCity());
            System.out.println("State: " + customer.getState());
            System.out.println("Credit Limit: " + customer.getCreditLimit());
            System.out.println("Phone Number: " + customer.getPhoneNumber());
            System.out.println("Email: " + customer.getEmail());
            System.out.println("-------------------------------------------------------");
        } else {
            System.out.println("Customer not found with ID: " + customerId);
        }
    }

    private static void searchSupplier(Scanner scanner) {
        System.out.print("Enter Supplier ID to search: ");
        int supplierId = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character

        Supplier supplier = merchandiseService.getSupplierById(supplierId);
        if (supplier != null) {
            System.out.println("Supplier Details:");
            System.out.println("-------------------------------------------------------");
            System.out.println("Partner ID: " + supplier.getPartnerId());
            System.out.println("Partner Name: " + supplier.getPartnerName());
            System.out.println("City: " + supplier.getCity());
            System.out.println("State: " + supplier.getState());
            System.out.println("Credit Balance: " + supplier.getCreditBalance());
            System.out.println("Driving License Number: " + supplier.getDrivingLicenseNumber());
            System.out.println("-------------------------------------------------------");
        } else {
            System.out.println("Supplier not found with ID: " + supplierId);
        }
    }
}