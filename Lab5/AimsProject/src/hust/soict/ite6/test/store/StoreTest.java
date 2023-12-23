//TranTrungKien-20210494

package hust.soict.ite6.test.store;
import hust.soict.ite6.aims.media.DigitalVideoDisc;
import hust.soict.ite6.aims.store.Store;

public class StoreTest {
    public static void main(String[] args) {
        // Create a Store with a capacity of 5 DVDs
        Store myStore = new Store();

        // Add DVDs to the store
        DigitalVideoDisc dvd1 = new DigitalVideoDisc("Inception", "Sci-Fi", "Christopher Nolan", 148, 19.99f);
        DigitalVideoDisc dvd2 = new DigitalVideoDisc("The Shawshank Redemption", "Drama", "Frank Darabont", 142, 15.99f);

        myStore.addMedia(dvd1);
        myStore.addMedia(dvd2);

        // Remove a DVD from the store
        myStore.removeMedia(1);
    }
}