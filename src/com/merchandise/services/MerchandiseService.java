/*package com.merchandise.services;



import com.merchandise.entities.Customer;
import com.merchandise.entities.Supplier;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class MerchandiseService {
    private List<Customer> customers;
    private List<Supplier> suppliers;

    public MerchandiseService() {
        customers = new ArrayList<>();
        suppliers = new ArrayList<>();
    }

    public void saveCustomerDetails(Customer cust) {
        customers.add(cust);
    }

    public List<Customer> getAllCustomers() {
        return customers;
    }

    public Customer getCustomerById(int customerId) {
        return customers.stream()
                .filter(c -> c.getPartnerId() == customerId)
                .findFirst()
                .orElse(null);
    }

    public void saveSupplierDetails(Supplier supp) {
        suppliers.add(supp);
    }

    public List<Supplier> getAllSuppliers() {
        return suppliers;
    }

    public Supplier getSupplierById(int supplierId) {
        return suppliers.stream()
                .filter(s -> s.getPartnerId() == supplierId)
                .findFirst()
                .orElse(null);
    }
}
*/
package com.merchandise.services;

import java.util.ArrayList;
import java.util.List;

import com.merchandise.entities.Customer;
import com.merchandise.entities.Supplier;

public class MerchandiseService {
    private List<Customer> customers;
    private List<Supplier> suppliers;

    public MerchandiseService() {
        customers = new ArrayList<>();
        suppliers = new ArrayList<>();
    }

    public void saveCustomerDetails(Customer customer) {
        if (customers.size() < 5) {
            String[] validationErrors = customer.validate();
            if (validationErrors.length == 0) {
                customers.add(customer);
                System.out.println("Customer added successfully.");
            } else {
                System.out.println("Validation errors:");
                for (String error : validationErrors) {
                    System.out.println("- " + error);
                }
            }
        } else {
            System.out.println("Maximum number of customers reached. Cannot add more customers.");
        }
    }

    public List<Customer> getAllCustomers() {
        return customers;
    }

    public Customer getCustomerById(int customerId) {
        return customers.stream()
                .filter(customer -> customer.getPartnerId() == customerId)
                .findFirst()
                .orElse(null);
    }

    public void saveSupplierDetails(Supplier supplier) {
        if (suppliers.size() < 5) {
            String[] validationErrors = supplier.validate();
            if (validationErrors.length == 0) {
                suppliers.add(supplier);
                System.out.println("Supplier added successfully.");
            } else {
                System.out.println("Validation errors:");
                for (String error : validationErrors) {
                    System.out.println("- " + error);
                }
            }
        } else {
            System.out.println("Maximum number of suppliers reached. Cannot add more suppliers.");
        }
    }

    public List<Supplier> getAllSuppliers() {
        return suppliers;
    }

    public Supplier getSupplierById(int supplierId) {
        return suppliers.stream()
                .filter(supplier -> supplier.getPartnerId() == supplierId)
                .findFirst()
                .orElse(null);
    }
}