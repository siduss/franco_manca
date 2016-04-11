package main;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.junit.Test;

import main.Commander;
import main.Pizza;
import main.Product;

public class TestMethods {
	private List<Product> p;
	private Commander m;
	private Product mozzarella80;
	private Product tomatoSauce60;
	private Product basil;
	private Product garlic;
	private Product origano;
	private Product mozzarella75;
	private Product sausage;
	private Product mushroom;
	private Product tomatoSauce100;
	private Product olio;
	private Pizza p3;
	private Pizza p2;
	private Pizza p1;
//	private Starter s1;
//	private Starter s2;
//	private Starter s3;

	public TestMethods() {
		init();
	}

	public void init() {
		p = new ArrayList<Product>();
		m = new Commander();
		olio = new Product("Olio", 3.0);
		olio.setHidden(true);
		mozzarella80 = new Product("Mozzarella", 80.0);
		mozzarella80.setPricePerKilo(4.42);
		tomatoSauce60 = new Product("Tomato Sauce", 60.0);
		tomatoSauce60.setPricePerKilo(0.80);
		basil = new Product("Basil", 2.0);
		basil.setPricePerKilo(8.75);
		garlic = new Product("Garlic", 4.0);
		garlic.setPricePerKilo(5);
		origano = new Product("Origano", 5.0);
		origano.setPricePerKilo(3.3);
		mozzarella75 = new Product("Mozzarella", 75.0);
		mozzarella75.setPricePerKilo(4.42);
		sausage = new Product("Sausage", 70.0);
		sausage.setPricePerKilo(5);
		mushroom = new Product("Mushroom", 40.0);
		mushroom.setPricePerKilo(4.42);
		tomatoSauce100 = new Product("Tomato Sauce", 100.0);
		tomatoSauce100.setPricePerKilo(0.80);

		p.add(mozzarella80);
		p.add(tomatoSauce60);
		p.add(basil);
		p.add(olio);

		p1 = new Pizza("N1", p);
		p1.setCustomerPrice(4.9);

		p = new ArrayList<Product>();
		p.add(tomatoSauce100);
		p.add(origano);
		p.add(garlic);
		p.add(basil);
		p.add(olio);
		p2 = new Pizza("N2", p);
		p2.setCustomerPrice(3.9);

		p = new ArrayList<Product>();
		p.add(mozzarella75);
		p.add(tomatoSauce60);
		p.add(sausage);
		p.add(mushroom);
		p.add(olio);
		p3 = new Pizza("N3", p);
		p3.setCustomerPrice(6.1);

		m.addPizza(p1);
		m.addPizza(p2);
		m.addPizza(p3);
	}

	@Test
	public void checkTotalPizzas() {
		assertEquals(3, m.getPizzas().size());
	}

	@Test
	public void deletePizza() {
		m.deletePizza(p1);
		assertEquals(2, m.getPizzas().size());
		assertEquals(null, m.deletePizza(p1));

	}

	@Test
	public void addPizza() {
		List<Product> tempProducts = new ArrayList<Product>();
		Pizza pizzaTemp = new Pizza("Capricciosa", tempProducts);
		m.addPizza(pizzaTemp);
		assertEquals(4, m.getPizzas().size());

		m.addPizza(pizzaTemp);
		assertEquals(4, m.getPizzas().size());

		assertEquals(null, m.addPizza(pizzaTemp));
	}

	@Test
	public void renameAllProductWithSameName() {
		int size = m.renameAllProductWithSameName("Mozzarella", "Franco & Loyd Mozzarella").size();
		assertEquals(2, size);

		size = m.renameAllProductWithSameName("Basil", "Fresh Basil").size();
		assertEquals(2, size);

		size = m.renameAllProductWithSameName("Olio", "Olio from Oliverilli").size();
		assertEquals(3, size);
	}

	@Test
	public void addProductToPizza() {
		Product temp = new Product("Ricotta", 50.0);
		assertEquals(4, p1.getProducts().size());

		m.addProductToPizza(p1, temp);
		assertEquals(5, p1.getProducts().size());

		m.deleteProductToComponent(p1, temp);
		assertEquals(4, p1.getProducts().size());

	}

	@Test
	public void getProduct() {
		assertEquals(10, m.getProducts().size());
	}

	@Test
	public void getProductsNotDuplicated() {
		assertEquals(8, m.getProductsNotDuplicated().size());
	}

	@Test
	public void product2Pizza() {
		Set<Product> keySet = m.product2Pizza().keySet();
		assertEquals(8, keySet.size());
		assertEquals(false, keySet.isEmpty());
	}
	
	
	@Test
	public void generateDocument(){
		m.generateDocument();
	}
}
