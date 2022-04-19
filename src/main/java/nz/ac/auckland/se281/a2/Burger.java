package nz.ac.auckland.se281.a2;

// Burger class, child of Food class
public class Burger extends Food {
	
	public Burger(int id, String name, float price) { // Burger constructor
		
		// calls parent Food constructor
		super(id, name, price);
	}


	public static void main(String []args) {
	      Burger cheeseBurger = new Burger(0, "Cheese Burger", (float) 15.5);
	      Burger avoBurger = new Burger(0, "Avocado Burger", (float) 17);
	      Burger veganBurger = new Burger(0, "Vegan Burger", (float) 18.5);
	      Burger fisherBurger = new Burger(0, "Fisherman Burger", (float) 17);
	      Burger buffaloBurger = new Burger(0, "Buffalo Chicken Burger", (float) 13);
	      Burger truffleBurger = new Burger(0, "Black Truffle Burger", (float) 27.5);
	      Burger foieGrasBurger = new Burger(0, "Crispy Foie Gras Burger", (float) 34);
	      
	      
	}
}
