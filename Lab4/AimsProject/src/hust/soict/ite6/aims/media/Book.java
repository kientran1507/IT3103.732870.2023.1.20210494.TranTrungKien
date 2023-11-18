package hust.soict.ite6.aims.media;

import java.util.ArrayList;
import java.util.List;

public class Book {
	private int ID;
	private String title;
	private String category;
	private float cost;
	private List<String> authors = new ArrayList<String>();
	
	// Getter methods to retrieve the properties of a book
	public int getID() {
		return ID;
	}


	public String getTitle() {
		return title;
	}


	public String getCategory() {
		return category;
	}


	public float getCost() {
		return cost;
	}

	// Method to add an author
    public void addAuthor(String authorName) {
        // Ensure that the author is not already in the ArrayList before adding
        if (!authors.contains(authorName)) {
            authors.add(authorName);
            System.out.println(authorName + " added as an author for " + title);
        } else {
            System.out.println(authorName + " is already an author for " + title);
        }
    }

    // Method to remove an author
    public void removeAuthor(String authorName) {
        // Ensure that the author is present in the ArrayList before removing
        if (authors.contains(authorName)) {
            authors.remove(authorName);
            System.out.println(authorName + " removed as an author for " + title);
        } else {
            System.out.println(authorName + " is not an author for " + title);
        }
    }
	public Book() {
		// TODO Auto-generated constructor stub
	}

}
