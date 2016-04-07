package main;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Menu {
	private List<Pizza> list_pizzas;

	public Menu() {
		list_pizzas = new ArrayList<>();
	}

	public Menu(Pizza p_n1) {
		list_pizzas = new ArrayList<>();
		this.list_pizzas.add(p_n1);
	}

	public void printPizzas() {
		for (Pizza p : list_pizzas) {
			List<Product> li = p.getListProducts();
			System.out.println(p.getNome());
			for (Product i : li) {
				System.out.println("\t " + i.getName() + ", " + i.getQuantity() + " gr");
			}
			System.out.println();
		}

	}

	public Pizza addPizza(Pizza p_n1) {
		this.list_pizzas.add(p_n1);
		return p_n1;
	}

	public void renameProduct(String oldName, String newName) {
		List<Product> li;
		for (Pizza p : this.list_pizzas) {
			li = p.getListProducts();
			for (Product i : li) {
				if (i.getName().equals(oldName)) {
					i.setName(newName);
				}
			}

		}
	}

	public Pizza deletePizza(Pizza pizza) {
		int i = 0;
		List<Pizza> lp = this.list_pizzas;
		for (Pizza p : lp) {
			if (i < list_pizzas.size()) {
				if (p.getNome().equals(pizza.getNome())) {
					lp.remove(i);
					return p;
				}
			}
			i++;
		}
		return null;
	}

	public Pizza deleteProductToPizza(Pizza pizza, Product product) {
		// funziona solo se il nome del prodotto e i grammi sono inseriti
		int i = 0;
		List<Product> lp = pizza.getListProducts();
		for (Product p : lp) {
			if (p.getName().equals(product.getName()) && p.getQuantity() == product.getQuantity()) {
				lp.remove(i);
				return pizza;
			}
			i++;
		}
		return null;

	}

	public Pizza addProductToPizza(Pizza pizza, Product product) {
		if (!checkProductIfExist(pizza, product)) {
			pizza.getListProducts().add(product);
			return pizza;
		}
		return null;
	}

	private boolean checkProductIfExist(Pizza pizza, Product product) {
		List<Product> lp = pizza.getListProducts();
		return lp.contains(product);
	}

	public List<Product> checkProductHowManyTimeExist() {
		// controlla quante volte esiste il prodotto e ritorna il prodotto con
		// associato le pizze che lo contengono
		// List<Pizza> lp = this.list_pizzas;
		// Map<Product,ArrayList<Pizza>> r = new
		// HashMap<Product,ArrayList<Pizza>>();
		//
		// List<Product> l;
		//
		// ArrayList<Pizza> newPizzas = new ArrayList<Pizza>();
		// for (Pizza pizza : lp){
		// l = pizza.getListProducts();
		// for (Product product : l ){
		// if (!r.containsKey(product.getName())){
		// newPizzas.add(pizza);
		// r.put(product, newPizzas);
		// } else {
		// r.get(product).add(pizza);
		// }
		// }
		// newPizzas = new ArrayList<Pizza>();
		// }
		// return r;
		List<Pizza> listPizzas = this.list_pizzas;
		List<Product> products = new ArrayList<Product>(); //ci vanno tutti prodotti non duplicati
		for (Pizza pizza : listPizzas) {
			List<Product> lp = pizza.getListProducts();
			for (Product p : lp) {
				if (!products.contains(p.getName())) {
					products.add(p);
				}
			}
		}
		return products;

	}
}
