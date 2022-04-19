package nz.ac.auckland.se281.a2;

// Burger class, child of Food class
public class Burger extends Food {
	
	public Burger(int id, String name, float price) { // Burger constructor
		
		// calls parent Food constructor
		super(id, name, price);
	}


	public static void main(String []args) {
	      Burger cheeseBurger = new Burger(0, "Cheese Burger", (float) 15.5);
	}
}
