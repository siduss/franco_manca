package main;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;
import org.apache.poi.xwpf.usermodel.XWPFTable;

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
		List<Pizza> result = getPizzasFromNameProduct(oldName);
		for (Pizza pizza : this.pizzas) {
			for (Product p : pizza.getProducts()) {
				if (p.getName().equals(oldName)) {
					p.setName(newName);
				}
			}
		}
		return result;
	}

	private List<Pizza> getPizzasFromNameProduct(String oldName) {
		/** Return all the pizzas that contains the argument 'oldName' **/
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

	public Component deleteProductToComponent(Component component, Product product) {
		return component.deleteProduct(product);

	}

	public Component addProductToPizza(Component component, Product product) {
		return component.addProduct(product);
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

	public Map<Product, List<Pizza>> product2Pizza() {
		Set<Product> products = getProductsNotDuplicated();
		Map<Product, List<Pizza>> result = new HashMap<Product, List<Pizza>>();
		for (Product p : products) {
			result.put(p, getPizzasFromNameProduct(p.getName()));
		}
		return result;
	}

	public void generateDocument() {
		List<Pizza> lp = pizzas;
		XWPFDocument doc = new XWPFDocument();
		XWPFParagraph paragrafo = doc.createParagraph();
		XWPFRun run = paragrafo.createRun();
		for (Pizza pizza : lp) {
			// run.setBold(true);
			// run.setTextPosition(1);
			run.setText(pizza.getName() + "\n");
			run.setText("\n");
			// run.setBold(false);
			for (Product product : pizza.getProducts()) {
				if (!product.isHidden()) {
					run.setText(product.getName() + " \t\t " + product.getGram() + " \n");
				}
			}
			run.setText("Profit: " + pizza.getProfit() + "\n");
			run.setText("Costo: " + pizza.getPrice() + "\n");
			run.setFontSize(30);
			try {
				doc.write(new FileOutputStream(new File(pizza.getName() + ".docx")));
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
