//TranTrungKien-20210494

package hust.soict.ite6.aims.cart;
import hust.soict.ite6.aims.disc.DigitalVideoDisc;

public class Cart {
    // Maximum number of DVDs that can be added to the cart
    public static final int MAX_NUMBERS_ORDERED = 20;
    
    // Array to store DigitalVideoDisc objects
    private DigitalVideoDisc itemsOrdered[] = new DigitalVideoDisc[MAX_NUMBERS_ORDERED];
    
    // Quantity of DigitalVideoDiscs currently in the cart
    private int qtyOrdered;

    // Constructor to initialize the cart with no items
    public Cart() {
        qtyOrdered = 0;
    }

    // Method to add a DigitalVideoDisc to the cart
    public void addDigitalVideoDisc(DigitalVideoDisc disc) {
        if (qtyOrdered <= MAX_NUMBERS_ORDERED) {
            itemsOrdered[qtyOrdered] = disc;
            qtyOrdered++;
            System.out.println("The disc has been added!");
        } else {
            System.out.println("The cart is full. You cannot add another one!");
        }
    }

    // Method to add a list of DigitalVideoDisc to the cart
    public void addDigitalVideoDisc(DigitalVideoDisc[] dvdList) {
        if (qtyOrdered + dvdList.length <= MAX_NUMBERS_ORDERED) {
            for (DigitalVideoDisc disc : dvdList) {
                itemsOrdered[qtyOrdered] = disc;
                qtyOrdered++;
            }
            System.out.println("The discs have been added!");
        } else {
            System.out.println("The cart is full. You cannot add another one!");
        }
    }
    
    // Method to add 2 DigitalVideoDisc to the cart
    public void addDigitalVideoDisc(DigitalVideoDisc dvd1, DigitalVideoDisc dvd2) {
    	if (qtyOrdered + 2 <= MAX_NUMBERS_ORDERED) {
    		itemsOrdered[qtyOrdered] = dvd1;
    		itemsOrdered[qtyOrdered+1] = dvd2;
    		qtyOrdered+=2;
    		System.out.println("Two discs have been added!");
    	} else {
    		System.out.println("The cart is full. You cannot add another one!");
    	}
    }

    // Method to remove a DigitalVideoDisc from the cart
    public void removeDigitalVideoDisc(DigitalVideoDisc disc) {
        for (int i = 0; i < qtyOrdered; i++) {
            if (itemsOrdered[i] == disc) {
                // Shift elements to fill the gap created by removing the disc
                for (int j = i; j < qtyOrdered - 1; j++) {
                    itemsOrdered[j] = itemsOrdered[j + 1];
                }
                itemsOrdered[qtyOrdered - 1] = null; // Remove the last element
                qtyOrdered--;
                System.out.println("The disc has been removed.");
                return;
            }
        }
        System.out.println("The disc is not in the cart.");
    }
    
    // Method to print the list of ordered items, their prices, and total cost
    public void printOrder() {
        System.out.println("***********************CART***********************");
        System.out.println("Ordered Items:");

        for (int i = 0; i < qtyOrdered; i++) {
            DigitalVideoDisc dvd = itemsOrdered[i];
            System.out.println((i + 1) + ". DVD - " + dvd);
        }

        System.out.println("Total cost is: " + totalCost() + " $");
        System.out.println("***************************************************");
    }

    // Method to search for DVDs in the cart by ID and display the results
    public void searchByID(int id) {
        for (DigitalVideoDisc dvd : itemsOrdered) {
            if (dvd != null && dvd.getID() == id) {
                System.out.println("Found DVD with ID " + id + ": " + dvd);
                return;
            }
        }
        System.out.println("No DVD found with ID " + id + " in the cart.");
    }

    // Method to search for DVDs in the cart by title and display the results
    public void searchByTitle(String title) {
        for (DigitalVideoDisc dvd : itemsOrdered) {
            if (dvd != null && dvd.getTitle() == title) {
                System.out.println("Found DVD with title \"" + title + "\": " + dvd);
                return;
            }
        }
        System.out.println("No DVD found with title \"" + title + "\" in the cart.");
    }

    // Method to calculate the total cost of items in the cart
    public float totalCost() {
        float totalCost = 0.0f;
        for (int i = 0; i < qtyOrdered; i++) {
            totalCost += itemsOrdered[i].getCost();
        }
        return totalCost;
    }
}
