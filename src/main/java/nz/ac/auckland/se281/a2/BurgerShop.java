package nz.ac.auckland.se281.a2;

import nz.ac.auckland.se281.a2.cli.Menu.SIZE;
import nz.ac.auckland.se281.a2.cli.MessagesCLI;
import java.util.ArrayList;
import java.util.List;

public class BurgerShop {
	
	int id = 0; // variable for tracking cart item id's
	ArrayList<Food> cartItems = new ArrayList<Food>(); // Create cartItems array list containing Food instance references
	
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
		cartItems.add(new Snack(id, name, price, size)); // adds snack to cart (creates snack instance)
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
		cartItems.add(new Drink(id, name, price, size)); // adds drink to cart (creates drink instance)
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
			MessagesCLI.CART_EMPTY.printMessage(); // prints empty cart message
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
			
			if(totalPrice >= (float) 100) { // applies discount if total is at or above $100
				MessagesCLI.DISCOUNT.printMessage(); // print discount message
				totalPrice *= 0.75; // apply 25% discount
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
		// checks if size is L or XL
		if(size == SIZE.L) {
			// increments price by $3
			priceSnack += 3;
			priceDrink += 3;
		} else if(size == SIZE.XL) {
			// increments price by $4
			priceSnack += 4;
			priceDrink += 4;
		}
		
		// halves drink price
		priceDrink *= 0.5;
		// calculates the sum of the burger, drink, and snack prices
		float comboTotal = priceBurger + priceSnack + priceDrink; 
		// formats the combo name
		String comboName = "COMBO : (" + nameBurger + ", " + nameSnack + " (" + size + "), " + nameDrink + " (" + size + "))";
		
		cartItems.add(new Combo(id, comboName, comboTotal)); // adds combo to cart (creates combo instance)
		id++; // increment id
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
		
		if((posCart < 0) || (posCart >= cartItems.size())) { // checks if item position exists in cart
			MessagesCLI.NOT_VALID_CART_POSITION.printMessage(); // prints error message
			
		} else {
			for(Food item : cartItems) { // loops through each item in cart
				if(item.id > posCart) { // checks if the item in the cart has an ID greater than posCart
					item.id -= 1; // decrements id by one
				}
			}
			
			cartItems.remove(posCart); // remove food item from cart
			id--; // decrements id
		}
	}

	/**
	 * removes all elements in the cart
	 */
	public void clearCart() {
		// clears all items in cart arraylist
		cartItems.clear();
		id = 0; // sets id to 0
	}

	/**
	 * This method confirms the order, showing the estimated pick up time. It also
	 * give a warning if there are missing opportunities for COMBO menus
	 * 
	 */
	public void confirmOrder() {
		if(cartItems.size() == 0) { // check if cart is empty
			MessagesCLI.ORDER_INVALID_CART_EMPTY.printMessage(); // prints empty cart message
		} else {
			int orderTime = 0;
			int burgerCount = 0;
			int drinkCount = 0;
			int snackCount = 0;
			
			int mediumDrinkCount = 0;
			int largeDrinkCount = 0;
			int extraLargeDrinkCount = 0;
			
			int mediumSnackCount = 0;
			int largeSnackCount = 0;
			int extraLargeSnackCount = 0;
			
			for(Food item : cartItems) { // loops through each item in cart
				if(item instanceof Burger) {
					orderTime += 60;
					burgerCount++;
					
				} else if(item instanceof Drink) {
					orderTime += 15;
					drinkCount++;
					
					Drink currentDrink = (Drink) item; // cast from Food to Drink class type
					
					if(currentDrink.size == SIZE.L) {
						largeDrinkCount++;
					} else if(currentDrink.size == SIZE.XL) {
						extraLargeDrinkCount++;
					} else {
						mediumDrinkCount++;
					}
				} else if(item instanceof Snack) {
					orderTime += 30;
					snackCount++;
					
					Snack currentSnack = (Snack) item; // cast from Food to Snack class type
					
					if(currentSnack.size == SIZE.L) {
						largeSnackCount++;
					} else if(currentSnack.size == SIZE.XL) {
						extraLargeSnackCount++;
					} else {
						mediumSnackCount++;
					}
				} else {
					orderTime += 105;
					burgerCount++;
					drinkCount++;
					snackCount++;
				}
				
				if(burgerCount == 1) {
					orderTime += 240;
				}
				if(drinkCount == 1) {
					orderTime += 30;
				}
				if(snackCount == 1) {
					orderTime += 150;
				}
			}
			 
			boolean mediumComboAvailable = ((mediumDrinkCount>0) && (mediumSnackCount>0));
			boolean largeComboAvailable = ((largeDrinkCount>0) && (largeSnackCount>0));
			boolean extraLargeComboAvailable = ((extraLargeDrinkCount>0) && (extraLargeSnackCount>0));
			
			boolean comboAvailable = (mediumComboAvailable || largeComboAvailable || extraLargeComboAvailable);
			if((burgerCount>0) && (comboAvailable)) {
				MessagesCLI.MISSED_COMBO.printMessage();
			} else {
				showCart();
				// code adapted from https://stackoverflow.com/a/6118983
				// converts order time from seconds to HOURS/MINUTES/SECONDS
				int hours = orderTime / 3600;
				int minutes = (orderTime % 3600) / 60;
				int seconds = orderTime % 60;
				
				System.out.println(MessagesCLI.ESTIMATE_WAITING_TIME.getMessage() + String.format("%d hours %d minutes %d seconds", hours, minutes, seconds));
			}
			
			
		}
		
		
	}
}
