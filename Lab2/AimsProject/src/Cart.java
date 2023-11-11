//TranTrungKien-20210494
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

    // Method to calculate the total cost of items in the cart
    public float totalCost() {
        float totalCost = 0.0f;
        for (int i = 0; i < qtyOrdered; i++) {
            totalCost += itemsOrdered[i].getCost();
        }
        return totalCost;
    }
}
