public class Store {
    private DigitalVideoDisc itemsInStore[]; // Array of DVDs available in the store

    public Store(int capacity) {
        itemsInStore = new DigitalVideoDisc[capacity];
    }

    // Method to add a DVD to the store
    public void addDVD(DigitalVideoDisc dvd) {
        for (int i = 0; i < itemsInStore.length; i++) {
            if (itemsInStore[i] == null) {
                itemsInStore[i] = dvd;
                System.out.println("DVD \"" + dvd.getTitle() + "\" added to the store.");
                return;
            }
        }
        System.out.println("The store is full. Cannot add another DVD.");
    }

    // Method to remove a DVD from the store
    public void removeDVD(int id) {
        for (int i = 0; i < itemsInStore.length; i++) {
            if (itemsInStore[i] != null && itemsInStore[i].getID() == id) {
                System.out.println("DVD \"" + itemsInStore[i].getTitle() + "\" removed from the store.");
                itemsInStore[i] = null;
                return;
            }
        }
        System.out.println("No DVD found with ID " + id + " in the store.");
    }
}

