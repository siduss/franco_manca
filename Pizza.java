package main;

import java.util.List;

public class Pizza {
	private String name;
	private List<Product> list_products;
	private String info;

	public Pizza(String np, List<Product> li) {
		this.name = np;
		this.list_products = li;
		if (checkIfIsWhite(li)) {
			this.name = this.name + " (NO TOMATO SAUCE)";
		}
	}


	private boolean checkIfIsWhite(List<Product> products) {
		for (Product p : products){
			if (p.getName().equals("Tomato Sauce")) return false;
			
		}
		return true;
	}


	public String getNome() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Product> getListProducts() {
		return list_products;
	}

	public void setListProducts(List<Product> lista_ingredieti) {
		this.list_products = lista_ingredieti;
	}

	public String getInfo() {
		return info;
	}

	public void setInfo(String info) {
		this.info = info;
	}

}
