package nz.ac.auckland.se281.a2;

abstract class Food { // Food abstract class (parent of Burger, Snack, Drink child classes)

	// Initializing instance variables
	protected int id;
	protected String name;
	protected float price;

	// Food constructor - takes ID, name, and price as parameters
	protected Food(int id, String name, float price) {

		// assigns values to instance variables
		this.id = id;
		this.name = name;
		this.price = price;
	}

	abstract int getId(); // child classes need getId method

	abstract void setId(int newId); // child classes need setId method
}
