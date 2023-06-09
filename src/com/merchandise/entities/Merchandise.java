package com.merchandise.entities;

import java.util.ArrayList;
import java.util.List;

public abstract class Merchandise {
	protected int partnerId;
    protected String partnerName;
    protected String city;
    protected String state;

    public Merchandise(int partnerId, String partnerName, String city, String state) {
        this.partnerId = partnerId;
        this.partnerName = partnerName;
        this.city = city;
        this.state = state;
    }

    public int getPartnerId() {
        return partnerId;
    }

    public Merchandise() {
		super();
		// TODO Auto-generated constructor stub
	}

	public void setPartnerId(int partnerId) {
        this.partnerId = partnerId;
    }

    public String getPartnerName() {
        return partnerName;
    }

    public void setPartnerName(String partnerName) {
        this.partnerName = partnerName;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

  /*  public String[] Validate() {
        // Validation logic
    	if(partnerId<=0)
    	{
    		System.out.println("Enter a valid Partner ID Number...");
    	}
    	else if(partnerName.length()<=5)
    	{
    		System.out.println("Enter a Partner Name with minimum 5 characters..");
    	}
    	else if(city.length()<=3)
    	{
    		System.out.println("Enter a City Name with minimum 3 characters..");
    	}	
    	else if(state.length()<=3)
    	{
    		System.out.println("Enter a State Name with minimum 3 characters..");
    	}	
    	
        // ...
        return new String[0];
        
        
    }*/
    public abstract String[] validate();

    // Constructors, getters, and setters

    public String[] commonValidate() {
        // Common validation logic for partnerName, city, and state
        List<String> errors = new ArrayList<>();

        if (partnerName == null || partnerName.length() < 5) {
            errors.add("Partner Name should be at least 5 characters long.");
        }

        if (city == null || city.length() < 3) {
            errors.add("City should be at least 3 characters long.");
        }

        if (state == null || state.length() < 3) {
            errors.add("State should be at least 3 characters long.");
        }

        return errors.toArray(new String[0]);
    }

    public void Print() {
        // Print logic
        // ...
    }
}
