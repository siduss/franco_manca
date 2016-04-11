package main;

import java.util.List;

public class Recipe extends Component {

	public Recipe(String recipeName, List<Product> products) {
		super(recipeName, products);
		setCustomerPrice(0);
	}

}
