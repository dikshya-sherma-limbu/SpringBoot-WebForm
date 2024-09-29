package com.example.view.model;

import java.util.ArrayList;
import java.util.List;

public class Validation {

	Order order = new Order();

	// method to validate the input field- shouldn't be empty or null
	// input type will be validate thru getter and setter
	public boolean checkValidation(Order order) {

		List<String> fieldsToValidate = new ArrayList<>();

		// Adding fields to the list
		fieldsToValidate.add(order.getFirstName());
		fieldsToValidate.add(order.getMiddleName());
		fieldsToValidate.add(order.getLastName());
		fieldsToValidate.add(order.getEmail());

		fieldsToValidate.add(order.getStreetAddress());
		fieldsToValidate.add(order.getCity());
		fieldsToValidate.add(order.getState());
		fieldsToValidate.add(order.getPostalCode());
		fieldsToValidate.add(order.getCountry());
		
		fieldsToValidate.add(order.getProduct());
		fieldsToValidate.add(order.getProductBrand());
		fieldsToValidate.add(order.getProductModel());

		// Loop through all fields and check if any are null or empty
		for (String field : fieldsToValidate) {
			if (field == null || field.isEmpty()) {
				System.out.println("Validation failed for field: " + field);
				return false;
			}
		}

		// Validate integer fields
		if (order.getAreaCode() <= 0 || order.getPhoneNumber() <= 0 || order.getQuantity() <= 0) {
			System.out.println("Validation failed for Integer");
			return false;
		}
		assignPrice(order);

		return true; // If All fields are valid
	}
	// Method to assign price based on phone model
    private void assignPrice(Order order) {
        String phoneModel = order.getProductModel();

        switch (phoneModel) {
            case "iphone 16":
                order.setPhonePrice(1450.00);
                break;
            case "iphone 15":
                order.setPhonePrice(1200.00);
                break;
            case "iphone 15 Pro Max":
                order.setPhonePrice(1400.00);
                break;
            case "Samsung S21":
                order.setPhonePrice(800.00);
                break;
            case "Samsung S21 Ultra":
                order.setPhonePrice(1000.00);
                break;
            case "Samsung Galaxy A 71":
            	 order.setPhonePrice(900.00);
            	 break;
            case "Pixel 8a":
                order.setPhonePrice(700.00);
                break;
            case "Pixel 6a":
                order.setPhonePrice(500.00);
                break;
            default:
                order.setPhonePrice(0.00); // Default price
                break;
        }
    }

}
