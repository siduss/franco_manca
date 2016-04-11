package main;

import java.util.List;

public class Pizza extends Component {
	private boolean isVegetarian;
	private boolean isMeat;

	public Pizza(String pizzaName, List<Product> products) {
		super(pizzaName, products);
		initMeatOrVeg(pizzaName, products);
//		if (!products.contains("Tomato Sauce")) {
//			setName(pizzaName + " NO TOMATO");
//		}
	}

	private void initMeatOrVeg(String pizzaName, List<Product> products) {
		if (pizzaName.contains("Meat") || pizzaName.contains("M")) {
			setMeat(true);
			setVegetarian(false);
		} else if (pizzaName.contains("Vegetarian") || pizzaName.contains("Veg") || pizzaName.contains("V")) {
			setVegetarian(true);
			setMeat(false);
		} else {
			setVegetarian(false);
			setMeat(false);
		}
	}
	
	public boolean isVegetarian() {
		return this.isVegetarian;
	}

	public void setVegetarian(boolean isVegetarian) {
		this.isVegetarian = isVegetarian;
	}

	public boolean isMeat() {
		return this.isMeat;
	}

	public void setMeat(boolean isMeat) {
		this.isMeat = isMeat;
	}
	
}
