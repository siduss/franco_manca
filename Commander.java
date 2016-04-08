package main;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

public class Commander {
	private List<Pizza> pizzas;

	public Commander() {
		pizzas = new ArrayList<>();
	}

	public Commander(Pizza pizza) {
		pizzas = new ArrayList<>();
		this.pizzas.add(pizza);
	}

	public void printPizzas() {
		for (Pizza p : pizzas) {
			List<Product> li = p.getProducts();
			System.out.println(p.getName());
			for (Product i : li) {
				System.out.println("\t " + i.getName() + ", " + i.getGram() + " gr");
			}
			System.out.println();
		}

	}

	public List<Pizza> renameAllProductWithSameName(String oldName, String newName) {
		/** Return all the pizzas that are changed by name **/
		List<Pizza> result = checkPizzasToChange(oldName);
		for (Pizza pizza : this.pizzas) {
			for (Product p : pizza.getProducts()) {
				if (p.getName().equals(oldName)) {
					p.setName(newName);
				}
			}
		}
		return result;
	}

	private List<Pizza> checkPizzasToChange(String oldName) {
		List<Pizza> result = new ArrayList<Pizza>();
		for (Pizza pizza : this.pizzas) {
			for (Product p : pizza.getProducts()) {
				if (p.getName().equals(oldName)) {
					result.add(pizza);
				}
			}
		}
		return result;
	}

	public Pizza addPizza(Pizza pizza) {
		List<Pizza> lp = pizzas;
		if (!lp.contains(pizza)) {
			lp.add(pizza);
			return pizza;
		}
		return null;
	}

	public Pizza deletePizza(Pizza pizza) {
		List<Pizza> lp = this.pizzas;
		if (lp.contains(pizza)) {
			lp.remove(pizza);
			return pizza;
		}
		return null;
	}

	public Pizza deleteProductToPizza(Pizza pizza, Product product) {
		return pizza.deleteProduct(product);

	}

	public Pizza addProductToPizza(Pizza pizza, Product product) {
		return pizza.addProduct(product);
	}

	public Set<Product> getProducts() {
		/**
		 * Return the Products that are equals by name, but different by grams
		 * NB: DUPLICATE VALOR ARE ALLOWED TODO da ritornare una lista ordinata
		 * dalla A alla Z
		 */
		List<Pizza> lp = this.pizzas;
		Set<Product> result = new HashSet<Product>();

		for (Pizza pizza : lp) {
			List<Product> li = pizza.getProducts();
			for (Product product : li) {
				result.add(product);
			}
		}

		// Collections.sort(result, new ComparatorProduct());
		return result;
	}

	public Set<Product> getProductsNotDuplicated() {
		/**
		 * Return the Product not duplicated. Different from getProducts()
		 */
		List<Pizza> lp = this.pizzas;
		Set<Product> result = new HashSet<Product>();

		for (Pizza pizza : lp) {
			List<Product> li = pizza.getProducts();
			for (Product product : li) {
				result.add(product);
			}
		}

		Set<Product> resultOrder = new TreeSet<Product>(new ComparatorProduct());
		resultOrder.addAll(result);
		return resultOrder;
	}

	public List<Pizza> getPizzas() {
		return this.pizzas;
	}
	
	public Map<Product,List<Pizza>> product2Pizza(){
		Set<Product> products = getProductsNotDuplicated();
		Map<Product,List<Pizza>> result = new HashMap<Product,List<Pizza>>();
		for (Product p : products){
			result.put(p, checkPizzasToChange(p.getName()));
		}
		return result;
	}

}
