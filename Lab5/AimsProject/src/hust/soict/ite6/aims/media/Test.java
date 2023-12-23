package hust.soict.ite6.aims.media;

import java.util.ArrayList;

public class Test {
    public static void main(String[] args) {
        // Create an ArrayList of Media
        ArrayList<Media> mediaList = new ArrayList<>();

        // Add some media (CD, DVD, or Book) into the list
        mediaList.add(new DigitalVideoDisc("Harry Potter and the Deathly Hallows - Part 1", "Fantasy", "J. K. Rowling", 146, 30.95f));
        mediaList.add(new CompactDisc("My Way", "Pop", 15.99f, 276, "Frank Sinatra"));
        mediaList.add(new Book("Lord of the ring", "Fantasy", "J. R. R. Tolkien", 29.99f));

        // Iterate through the list and print out the information of the media using toString()
        for (Media media : mediaList) {
            System.out.println(media.toString());
        }
    }
}
