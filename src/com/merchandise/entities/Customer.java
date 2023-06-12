package com.merchandise.entities;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
	            errors.add("Credit Limit cannot exceed Rs50,000.");
	        }

	        if (phoneNumber == null || phoneNumber.length() != 10) {
	            errors.add("Enter a valid Phone Number..");
	        } 
	       
	        if (email == null || !isValidEmail(email)) {
	            errors.add("Please enter a valid email address.");
	            	            
	   	        }
	        
	        return errors.toArray(new String[0]);
	        }
	    
	    protected boolean isValidEmail(String email) {
            String emailPattern = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$";
            Pattern pattern = Pattern.compile(emailPattern);
            Matcher matcher = pattern.matcher(email);
            return matcher.matches();
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
