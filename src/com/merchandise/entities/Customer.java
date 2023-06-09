package com.merchandise.entities;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Customer extends Merchandise{
	 private double creditLimit;
	    private String phoneNumber;
	    private String email;

	    public Customer(int partnerId, String partnerName, String city, String state,
	                    int creditLimit, String phoneNumber, String email) {
	        super(partnerId, partnerName, city, state);
	        this.creditLimit = creditLimit;
	        this.phoneNumber = phoneNumber;
	        this.email = email;
	    }

	    public double getCreditLimit() {
	        return creditLimit;
	    }

	    public void setCreditLimit(double d) {
	        this.creditLimit = d;
	    }

	    public String getPhoneNumber() {
	        return phoneNumber;
	    }

	    public void setPhoneNumber(String phoneNumber) {
	        this.phoneNumber = phoneNumber;
	    }

	    public String getEmail() {
	        return email;
	    }

	    public void setEmail(String email) {
	        this.email = email;
	    }

	    
	    @Override
	    public String[] validate() {
	        List<String> errors = new ArrayList<>();

	        errors.addAll(Arrays.asList(super.commonValidate()));

	        if (creditLimit > 50000) {
	            errors.add("Credit Limit cannot exceed 50,000.");
	        }

	        if (phoneNumber == null || phoneNumber.length() != 10) {
	            errors.add("Phone Number should be 10 digits long.");
	        }

	        // Add email validation logic

	        return errors.toArray(new String[0]);
	    }

	    public Customer(int partnerId, String partnerName, String city, String state) {
			super(partnerId, partnerName, city, state);
			// TODO Auto-generated constructor stub
		}

		public Customer() {
			// TODO Auto-generated constructor stub
			super();
		}

		
		public void print() {
	        System.out.println("Customer Details:");
	        System.out.println("Partner ID: " + getPartnerId());
	        System.out.println("Partner Name: " + getPartnerName());
	        System.out.println("City: " + getCity());
	        System.out.println("State: " + getState());
	        System.out.println("Credit Limit: " + getCreditLimit());
	        System.out.println("Phone Number: " + getPhoneNumber());
	        System.out.println("Email: " + getEmail());
	        System.out.println();
	    }
		
	    
	

}
