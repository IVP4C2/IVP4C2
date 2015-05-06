package nl.edu.avans.ivp4c2.domain;

public class Product {
	private int productNumber;
	private String productName;
	private String brand;
	private Order order;
	
	public Product(int productNumber, String productName, Order order) {
		this.productNumber = productNumber;
		this.productName = productName;
		this.order = order;
	}
	
	public Product(int productNumber, String productName, Order order, String brand) {
		this.productNumber = productNumber;
		this.productName = productName;
		this.order = order;
		this.brand = brand;
	}

	public int getProductNumber() {
		return productNumber;
	}

	public String getProductName() {
		return productName;
	}

	public String getBrand() {
		return brand;
	}
	
	public Order getOrder() {
		return order;
	}
}
