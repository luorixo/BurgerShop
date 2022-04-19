package nz.ac.auckland.se281.a2;

// Drink class, child of Food class
public class Drink extends Food {
	
	public Drink(int id, String name, float price) { // Drink Constructor
		
		// calls parent Food constructor
		super(id, name, price);
	}
}
