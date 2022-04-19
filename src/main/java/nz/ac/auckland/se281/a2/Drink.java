package nz.ac.auckland.se281.a2;
import nz.ac.auckland.se281.a2.cli.Menu.SIZE;

// Drink class, child of Food class
public class Drink extends Food {
	
	SIZE size; // instantiate size instance variable
	
	public Drink(int id, String name, float price, SIZE size) { // Drink Constructor
		
		// calls parent Food constructor
		super(id, name, price);
		
		this.size = size; // assigns value to size instance variable
	}
}
