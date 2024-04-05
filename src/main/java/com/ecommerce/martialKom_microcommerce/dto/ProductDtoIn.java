package com.ecommerce.martialKom_microcommerce.dto;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

public class ProductDtoIn {

	@NotBlank(message = "Please fill the label correctly")
	@NotNull(message = "The label is mandatory")
	@NotEmpty(message = "Please fill a correct value for the label")
	private String label;
	
	
	private String description;
	

	@NotNull(message = "The price is mandatory")
	private double price;
	
	@NotNull(message = "The quantity is mandatory")
	private int quantity;

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public ProductDtoIn(String label, String description, double price, int quantity) {
		this.label = label;
		this.description = description;
		this.price = price;
		this.quantity = quantity;
	}
	
	
}
