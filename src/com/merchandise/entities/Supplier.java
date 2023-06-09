package com.merchandise.entities;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Supplier extends Merchandise {
	
	private double creditBalance;
    private String drivingLicenseNumber;

    public Supplier(int partnerId, String partnerName, String city, String state,
                    int creditBalance, String drivingLicenseNumber) {
        super(partnerId, partnerName, city, state);
        this.creditBalance = creditBalance;
        this.drivingLicenseNumber = drivingLicenseNumber;
    }

    public double getCreditBalance() {
        return creditBalance;
    }

    public Supplier() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Supplier(int partnerId, String partnerName, String city, String state) {
		super(partnerId, partnerName, city, state);
		// TODO Auto-generated constructor stub
	}

	public void setCreditBalance(double d) {
        this.creditBalance = d;
    }

    public String getDrivingLicenseNumber() {
        return drivingLicenseNumber;
    }

    public void setDrivingLicenseNumber(String drivingLicenseNumber) {
        this.drivingLicenseNumber = drivingLicenseNumber;
    }

   
    @Override
    public String[] validate() {
        List<String> errors = new ArrayList<>();

        errors.addAll(Arrays.asList(super.commonValidate()));

        if (creditBalance > 175000) {
            errors.add("Credit Balance cannot exceed 1,75,000.");
        }        
        return errors.toArray(new String[0]);
    }
  
   
        
    	public void print() {
            System.out.println("Supplier Details:");
            System.out.println("Partner ID: " + getPartnerId());
            System.out.println("Partner Name: " + getPartnerName());
            System.out.println("City: " + getCity());
            System.out.println("State: " + getState());
            System.out.println("Credit Balance: " + getCreditBalance());
            System.out.println("Driving License Number: " + getDrivingLicenseNumber());
            System.out.println();
        }
    

}
