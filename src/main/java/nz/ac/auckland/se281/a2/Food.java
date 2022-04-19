package nz.ac.auckland.se281.a2;

abstract class Food {
	
	// Initializing instance variables
	int id;
	String name;
	float price;
	
	// Food constructor - takes ID, name, and price as parameters
	public Food(int id, String name, float price) {
		
		// assigns values to instance variables
		this.id = id;
		this.name = name;
		this.price = price;
	}
}
