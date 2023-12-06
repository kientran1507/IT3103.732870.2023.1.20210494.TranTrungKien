//TranTrungKien-20210494

package hust.soict.ite6.aims.cart;

import java.util.Collections;
import java.util.ArrayList;

import hust.soict.ite6.aims.media.DigitalVideoDisc;
import hust.soict.ite6.aims.media.Media;

public class Cart {
    // Maximum number of DVDs that can be added to the cart
    public static final int MAX_NUMBERS_ORDERED = 20;
    
    // ArrayList to store the ordered items
    private ArrayList<Media> itemsOrdered = new ArrayList<Media>();
    
    // Constructor to initialize the cart with no items
    public Cart() {}

    // Method to add media to the cart
    public void addMedia(Media media) {
        if (itemsOrdered.size() < MAX_NUMBERS_ORDERED) {
            itemsOrdered.add(media);
            System.out.println("Added to cart: " + media.getTitle());
        } else {
            System.out.println("The cart is full. Cannot add more items.");
        }
    }

    // Method to remove media from the cart
    public void removeMedia(Media media) {
        if (itemsOrdered.remove(media)) {
            System.out.println("Removed from cart: " + media.getTitle());
        } else {
            System.out.println("Item not found in the cart: " + media.getTitle());
        }
    }
    
    // Method to remove media from the cart by title
    public void removeMediaByTitle(String title) {
        for (Media media : itemsOrdered) {
            if (media.getTitle().equalsIgnoreCase(title)) {
                removeMedia(media);
                System.out.println("Removed from cart: " + title);
                return;
            }
        }
        System.out.println("No media found with title \"" + title + "\" in the cart.");
    }
    
    // Method to print the list of ordered items, their prices, and total cost
    public void printOrder() {
        System.out.println("***********************CART***********************");
        System.out.println("Ordered Items:");

        for (Media media : itemsOrdered) {
            System.out.println(media.toString());
        }

        System.out.println("Total cost is: " + totalCost() + " $");
        System.out.println("***************************************************");
    }

    // Method to search for DVDs in the cart by ID and display the results
    public void searchByID(int id) {
    	for (Media media : itemsOrdered) {
    		if (media instanceof DigitalVideoDisc) {
    	        if (media.getID() == id) {
    	            System.out.println("Found media with ID " + id + ": " + media);
    	            return;
    			}
    		}
    	}
        System.out.println("No DVD found with ID " + id + " in the cart.");
    }

    // Method to search for DVDs in the cart by title and display the results
    public void searchByTitle(String title) {
    	for (Media media : itemsOrdered) {
    		if (media instanceof DigitalVideoDisc) {
    	        if (media.getTitle() == title) {
    				System.out.println("Found media with title \"" + title + "\": " + media);
    				return;
                }
            }
    	}
        System.out.println("No DVD found with title \"" + title + "\" in the cart.");
    }

    // Method to calculate the total cost of items in the cart
    public float totalCost() {
    	float totalCost = 0.0f;
    	for (Media media : itemsOrdered) {
    		totalCost += media.getCost();
        }
        return totalCost;
    }
    
    // Method to sort media items in the cart by title then cost
    public void sortMediaByTitleCost() {
        Collections.sort(itemsOrdered, Media.COMPARE_BY_TITLE_COST);
    }
    
    // Method to sort media items in the cart by cost then title
    public void sortMediaByCostTitle() {
        Collections.sort(itemsOrdered, Media.COMPARE_BY_COST_TITLE);
    }
    
    // Method to clear the cart
    public void clearCart() {
        itemsOrdered.clear();
        System.out.println("Cart cleared.");
    }
}
