package main;

import java.util.List;

public class Pizza extends Component {
	private boolean isVegetarian;
	private boolean isMeat;

	public Pizza(String pizzaName, List<Product> products) {
		super(pizzaName, products);
//		if (pizzaName.equals("Meat")) {
//			this.isMeat = true;
//			this.isVegetarian = false;
//		} else if (pizzaName.equals("Vegetarian")) {
//			this.isVegetarian = true;
//			this.isMeat = false;
//		} else {
//			this.isVegetarian = false;
//			this.isMeat = false;
//		}
//		if (checkIfIsWithoutTomatoSauce(products)) {
//			this.name = this.name + " (NO TOMATO)";
//		}
	}
	
	private boolean checkIfIsWithoutTomatoSauce(List<Product> products) {
		for (Product p : products) {
			if (p.getName().equals("Tomato Sauce"))
				return false;

		}
		return true;
	}
	
}
