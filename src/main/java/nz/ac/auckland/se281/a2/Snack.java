package nz.ac.auckland.se281.a2;
import nz.ac.auckland.se281.a2.cli.Menu.SIZE;

// Snack class, child of Food class
public class Snack extends Food {
	
	SIZE size; // instantiate size instance variable
	
	public Snack(int id, String name, float price, SIZE size) { // Snack Constructor
		
		// calls parent Food constructor
		super(id, name, price);
		
		this.size = size; // assigns value to size instance variable
	}
}
