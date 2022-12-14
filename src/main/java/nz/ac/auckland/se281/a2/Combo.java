package nz.ac.auckland.se281.a2;

// Combo class, child of Food class
public class Combo extends Food {

	public Combo(int id, String name, float price) { // Combo constructor

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
