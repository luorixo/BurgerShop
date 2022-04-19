package nz.ac.auckland.se281.a2;

// Snack class, child of Food class
public class Snack extends Food {
	
	public Snack(int id, String name, float price) { // Snack Constructor
		
		// calls parent Food constructor
		super(id, name, price);
	}
}
