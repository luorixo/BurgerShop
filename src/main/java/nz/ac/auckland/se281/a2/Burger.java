package nz.ac.auckland.se281.a2;

// Burger class, child of Food class
public class Burger extends Food {
	
	public Burger(int id, String name, float price) { // Burger constructor
		
		// calls parent Food constructor
		super(id, name, price);
	}
	
	@Override
	public int getId() { // id getter method
		return id;
	}

	@Override
	public void setId(int newId) { // id setter method
		this.id = newId;
	}
}
