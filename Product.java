package main;

public class Product {
	private String name;
	private double gram;
	private String info;
	private double pricePerKilo;
	private double productCost;

	public Product(String nome, Double gram) {
		this.name = nome;
		this.gram = gram;
	}

	public Product(String name) {
		this.name = name;
	}

	public Double getQuantity() {
		return this.gram;
	}

	public void setGram(Double gram) {
		this.gram = gram;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String nome) {
		this.name = nome;
	}

	public double getGram() {
		return gram;
	}

	public void setGram(double gram) {
		this.gram = gram;
	}

	public String getInfo() {
		return info;
	}

	public void setInfo(String info) {
		this.info = info;
	}

	public double getPricePerKilo() {
		return pricePerKilo;
	}

	public void setPricePerKilo(double pricePerKilo) {
		this.pricePerKilo = pricePerKilo;
	}

	public double getProductCost() {
		return productCost;
	}

	public void setProductCost(double productCost) {
		this.productCost = productCost;
	}

}
