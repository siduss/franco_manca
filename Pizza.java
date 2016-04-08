package main;

import java.util.List;

public class Pizza {
	private String name;
	private List<Product> products;
	private double customerPrice;
	private String info;
	private String allergenInfo;
	private boolean isVegetarian;
	private boolean isMeat;

	public Pizza(String pizzaName, List<Product> products) {
		this.name = pizzaName;
		this.products = products;
		if (pizzaName.equals("Meat")) {
			this.isMeat = true;
			this.isVegetarian = false;
		} else if (pizzaName.equals("Vegetarian")) {
			this.isVegetarian = true;
			this.isMeat = false;
		} else {
			this.isVegetarian = false;
			this.isMeat = false;
		}
		// if (checkIfIsWithoutTomatoSauce(products)) {
		// this.name = this.name + " (NO TOMATO)";
		// }
	}

	public double getPrice() {
		double price = 0;
		List<Product> lp = this.products;
		for (Product p : lp) {
			price = price + p.getPrice();
		}
		return price;
	}

	private boolean checkIfIsWithoutTomatoSauce(List<Product> products) {
		for (Product p : products) {
			if (p.getName().equals("Tomato Sauce"))
				return false;

		}
		return true;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Product> getProducts() {
		return products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}

	public String getInfo() {
		return info;
	}

	public void setInfo(String info) {
		this.info = info;
	}

	public double getCustomerPrice() {
		return customerPrice;
	}

	public void setCustomerPrice(double customerPrice) {
		this.customerPrice = customerPrice;
	}

	public double getProfit() {
		return ((this.customerPrice - getPrice()) * 100) / this.customerPrice;
	}

	public Pizza addProduct(Product product) {
		List<Product> lp = this.products;
		if (!checkIfProductExsist(lp, product)) {
			lp.add(product);
			return this;
		}
		return null;
	}

	public Pizza deleteProduct(Product product) {
		List<Product> lp = this.products;
		if (checkIfProductExsist(lp, product)) {
			lp.remove(product);
			return this;
		}
		return null;
	}

	private boolean checkIfProductExsist(List<Product> lp, Product product) {
		return lp.contains(product);
	}

}
