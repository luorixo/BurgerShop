package nz.ac.auckland.se281.a2;

import nz.ac.auckland.se281.a2.cli.Menu.SIZE;
import nz.ac.auckland.se281.a2.cli.MessagesCLI;
import java.util.ArrayList;

public class BurgerShop {
	
	int id = 0;
	ArrayList<Food> cartItems = new ArrayList<Food>(); // Create cartItems array list containing Food instance references
	
	public static void main(String []args) {
		
		// initializing all burgers on the menu
		Burger cheeseBurger = new Burger(0, "Cheese Burger", (float) 15.5);
	    Burger avoBurger = new Burger(1, "Avocado Burger", (float) 17);
	    Burger veganBurger = new Burger(2, "Vegan Burger", (float) 18.5);
	    Burger fisherBurger = new Burger(3, "Fisherman Burger", (float) 17);
	    Burger buffaloBurger = new Burger(4, "Buffalo Chicken Burger", (float) 13);
	    Burger truffleBurger = new Burger(5, "Black Truffle Burger", (float) 27.5);
	    Burger foieGrasBurger = new Burger(6, "Crispy Foie Gras Burger", (float) 34);
	    
	    // initializing all snacks on the menu
	    Snack chips = new Snack(7, "Chips", (float) 7.5);
	    Snack sweetPotatoChips = new Snack(8, "Sweet Potato Chips", (float) 10);
	    Snack onionRings = new Snack(9, "Onion Rings", (float) 5);
	    Snack buffaloWings = new Snack(10, "Buffalo Chicken Wings", (float) 12);
	    Snack fishFingers = new Snack(11, "Fish Fingers", (float) 8);
	    
	    // Initializing all drinks on the menu
	    Drink coke = new Drink(12, "Coke", (float) 2);	
	    Drink sprite = new Drink(13, "Sprite", (float) 2);
	    Drink fanta = new Drink(14, "Fanta", (float) 2);
	    Drink milkshake = new Drink(15, "Milkshake", (float) 4);
	}
	
	public BurgerShop() {
	
	}

	/**
	 * Add a burger in the cart
	 * 
	 * @param name
	 * @param price
	 */
	public void addBurger(String name, float price) {
		cartItems.add(new Burger(id, name, price)); // adds burger to cart (creates burger instance)
		id++; // increments id
	}

	/**
	 * add a snack in the cart, if size is L the price should be incremented by $3
	 * if the size is XL the price should be incremented by $4 (@see
	 * nz.ac.auckland.se281.a2.cli.Menu.SIZE)
	 * 
	 * 
	 * @param name
	 * @param price
	 * @param size
	 */
	public void addSnack(String name, float price, SIZE size) {
		
		// checks if size is L or XL
		if(size == SIZE.L) {
			price += 3; // increments price by $3
		} else if(size == SIZE.XL) {
			price += 4; // increments price by $4
		}
		
		name = name + " (" + size + ")"; // reformats name to include size
		cartItems.add(new Snack(id, name, price)); // adds snack to cart (creates snack instance)
		id++; // increments id
	}

	/**
	 * 
	 * add a drink in the cart
	 * 
	 * if size is L the price should be incremented by $3 if the size is XL the
	 * price should be incremented by $4 (@see
	 * nz.ac.auckland.se281.a2.cli.Menu.SIZE)
	 * 
	 *
	 * @param name
	 * @param price
	 * @param size
	 */
	public void addDrink(String name, float price, SIZE size) {
		// checks if size is L or XL
		if(size == SIZE.L) {
			price += 3; // increments price by $3
		} else if(size == SIZE.XL) {
			price += 4; // increments price by $4
		}

		name = name + " (" + size + ")"; // reformats name to include size
		cartItems.add(new Drink(id, name, price)); // adds drink to cart (creates drink instance)
		id++; // increments id
	}

	/**
	 * print the content of the cart, or print MessagesCLI.CART_EMPTY if the cart is
	 * empty
	 *
	 *
	 */
	public void showCart() {
		// checks if cart is empty
		if(cartItems.size() == 0) {
			System.out.println(MessagesCLI.CART_EMPTY); // prints empty cart message
		} else {
			float totalPrice = 0; // initialize total price to 0
			
			for(Food item : cartItems) { // loops through each item in cart
				// prints item id, name, and price
				System.out.print(item.id + " - ");
				System.out.print(item.name + ": $");
				System.out.print(String.format("%.02f", item.price));
				System.out.println();
				
				totalPrice += item.price; // adds current item's price to the total
			}
			System.out.print("Total: $" + String.format("%.02f", totalPrice)); // prints total
			System.out.println();
		}
			
		
	}

	/**
	 * add a combo in the cart.
	 * 
	 * The price of a combo is the sum of all the items, but the drink would be half
	 * price. Note that in a combo, both snacks and drinks have the same size, and
	 * the combo price must consider the size (@see addSnack and addDrink methods).
	 * 
	 * @param nameBurger
	 * @param priceBurger
	 * @param nameSnack
	 * @param priceSnack
	 * @param nameDrink
	 * @param priceDrink
	 * @param size
	 */
	public void addCombo(String nameBurger, float priceBurger, String nameSnack, float priceSnack, String nameDrink,
			float priceDrink, SIZE size) {
		// TODO TASK2
	}

	/**
	 * remove the item in the cart specified by the position posCart. Note that the
	 * position of the cart start from zero. if postCart is invalid: posCart < 0 OR
	 * posCart >= size of the cart the method prints
	 * MessagesCLI.NOT_VALID_CART_POSITION
	 * 
	 * @param posCart
	 */
	public void removeItem(int posCart) {
		// TODO TASK3
	}

	/**
	 * removes all elements in the cart
	 */
	public void clearCart() {
		// TODO TASK3
	}

	/**
	 * This method confirms the order, showing the estimated pick up time. It also
	 * give a warning if there are missing opportunities for COMBO menus
	 * 
	 */
	public void confirmOrder() {
		// TODO TASK4
	}
}
