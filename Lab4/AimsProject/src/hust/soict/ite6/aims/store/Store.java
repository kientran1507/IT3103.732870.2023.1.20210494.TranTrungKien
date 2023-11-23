//TranTrungKien-20210494

package hust.soict.ite6.aims.store;
import java.util.ArrayList;

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
}

