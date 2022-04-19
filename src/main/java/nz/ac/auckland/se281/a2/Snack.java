package nz.ac.auckland.se281.a2;
import nz.ac.auckland.se281.a2.cli.Menu.SIZE;

// Snack class, child of Food class
public class Snack extends Food {
	SIZE size; // declare size instance variable
	
	public Snack(int id, String name, float price, SIZE size) { // Snack Constructor
		
		// calls parent Food constructor
		super(id, name, price);
		// assigns value to size instance variable
		this.size = size;
	}
}
