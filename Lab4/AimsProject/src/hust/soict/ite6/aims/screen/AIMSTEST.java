package hust.soict.ite6.aims.screen;

import hust.soict.ite6.aims.cart.Cart;
import hust.soict.ite6.aims.media.Book;
import hust.soict.ite6.aims.media.CompactDisc;
import hust.soict.ite6.aims.media.DigitalVideoDisc;
import hust.soict.ite6.aims.store.Store;

public class AIMSTEST {
    public static void main(String[] args) {
        Store store = new Store();
        Cart cart = new Cart(); 
        StoreScreen storeScreen = new StoreScreen(store);
    	CartScreen cartScreen = new CartScreen(cart);
    	
        // Create a random CD
        CompactDisc cd = new CompactDisc(1, "Random CD", "Random Category", 120.5f);
        // Create a random DVD
        DigitalVideoDisc dvd = new DigitalVideoDisc(2, "Random DVD", "Random Category", 180.0f);
        // Create a random Book
        Book book = new Book(3, "Random Book", "Random Category", 15.99f);

        // Add items to the store
        store.addMedia(cd);
        store.addMedia(dvd);
        store.addMedia(book);
        
        store.displayStore();
        System.out.println();

        // Add items to the cart
        cart.addMedia(cd);
        cart.addMedia(dvd);
        cart.addMedia(book);
        
    }
}
