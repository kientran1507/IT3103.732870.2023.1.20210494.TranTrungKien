//TranTrungKien-20210494

package hust.soict.ite6.aims.store;
import java.util.ArrayList;

import hust.soict.ite6.aims.media.Book;
import hust.soict.ite6.aims.media.CompactDisc;
import hust.soict.ite6.aims.media.DigitalVideoDisc;
import hust.soict.ite6.aims.media.Media;

public class Store {
    // ArrayList to store the DVDs available in the store
    private ArrayList<Media> itemsInStore = new ArrayList<Media>();

    // Method to add a DVD to the store
    public void addMedia(Media media) {
        itemsInStore.add(media);
        System.out.println("Media \"" + media.getTitle() + "\" added to the store.");
    }

    // Method to remove a DVD from the store
    public void removeMedia(int id) {
        for (Media media : itemsInStore) {
            if (media != null && media.getID() == id) {
                itemsInStore.remove(media);
                System.out.println("Media \"" + media.getTitle() + "\" removed from the store.");
                return;
            }
        }
        System.out.println("No media found with ID " + id + " in the store.");
    }

    // Method to display the available media in the store
    public void displayStore() {
        if (itemsInStore.isEmpty()) {
            System.out.println("The store is empty.");
        } else {
            System.out.println("Items available in the store:");
            for (Media media : itemsInStore) {
                if (media != null) {
                    System.out.println(media.toString());
                }
            }
        }
    }
    
 // Method to search for any media in the cart by title and display the results
    public Media searchMediaByTitle(String title) {
        for (Media media : itemsInStore) {
            if (media.getTitle().toLowerCase().equals(title)) {
                return media;
            }
        }
        return null;
    }

    // Method to display search results
    public void displaySearchResults(String title, Media foundMedia) {
        if (foundMedia != null) {
            if (foundMedia instanceof DigitalVideoDisc) {
                System.out.println("Found DVD with title \"" + title + "\": " + foundMedia);
            } else if (foundMedia instanceof CompactDisc) {
                System.out.println("Found CD with title \"" + title + "\": " + foundMedia);
            } else if (foundMedia instanceof Book) {
                System.out.println("Found Book with title \"" + title + "\": " + foundMedia);
            }
        } else {
            System.out.println("No media found with title \"" + title + "\" in the cart.");
        }
    }


}

