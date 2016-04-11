package main;

import java.util.List;

public abstract class Component {

	private String name;
	private List<Product> products;
	private double customerPrice;
	private String info;
	private String allergenInfo;

	public Component(String componentName, List<Product> products) {
		this.name = componentName;
		this.products = products;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;

	}

	public List<Product> getProducts() {
		return this.products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;

	}

	public double getCustomerPrice() {
		return this.customerPrice;
	}

	public void setCustomerPrice(double customerPrice) {
		this.customerPrice = customerPrice;

	}

	public String getInfo() {
		return this.info;
	}

	public void setInfo(String info) {
		this.info = info;

	}

	public String getAllergenInfo() {
		return this.allergenInfo;
	}

	public void setAllergenInfo(String allergenInfo) {
		this.allergenInfo = allergenInfo;

	}

	public Component addProduct(Product product) {
		List<Product> lp = this.products;
		if (!lp.contains(product)) {
			lp.add(product);
			return this;
		}
		return null;
	}

	public Component deleteProduct(Product product) {
		List<Product> lp = this.products;
		if (lp.contains(product)) {
			lp.remove(product);
			return this;
		}
		return null;
	}

	public double getProfit() {
		return ((this.customerPrice - this.getPrice()) * 100) / this.customerPrice;
	}

	public double getPrice() {
		double price = 0;
		List<Product> lp = this.products;
		for (Product p : lp) {
			price = price + p.getPrice();
		}
		return price;
	}
}
