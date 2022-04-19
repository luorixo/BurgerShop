package nz.ac.auckland.se281.a2;

import nz.ac.auckland.se281.a2.cli.Menu.SIZE;

// Drink class, child of Food class
public class Drink extends Food {

	private SIZE size; // instantiate size instance variable

	public Drink(int id, String name, float price, SIZE size) { // Drink Constructor

		// calls parent Food constructor
		super(id, name, price);

		this.size = size; // assigns value to size instance variable
	}

	@Override
	public int getId() { // id getter method
		return id;
	}

	@Override
	public void setId(int newId) { // id setter method
		this.id = newId;
	}

	public SIZE getSize() { // size getter method
		return size;
	}
}
