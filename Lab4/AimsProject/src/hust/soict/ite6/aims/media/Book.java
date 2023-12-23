//TranTrungKien-20210494

package hust.soict.ite6.aims.media;

import java.util.ArrayList;
import java.util.List;

public class Book extends Media{
	private List<String> authors = new ArrayList<String>();
	
	// Method to add an author
    public void addAuthor(String authorName) {
        // Ensure that the author is not already in the ArrayList before adding
        if (!authors.contains(authorName)) {
            authors.add(authorName);
            System.out.println(authorName + " added as an author for " + getTitle());
        } else {
            System.out.println(authorName + " is already an author for " + getTitle());
        }
    }

    // Method to remove an author
    public void removeAuthor(String authorName) {
        // Ensure that the author is present in the ArrayList before removing
        if (authors.contains(authorName)) {
            authors.remove(authorName);
            System.out.println(authorName + " removed as an author for " + getTitle());
        } else {
            System.out.println(authorName + " is not an author for " + getTitle());
        }
    }

    public Book(String title, String category, String author, float cost) {
    	super(title, category, cost); 
		authors.add(author);
	}
    
	public Book(int id, String title, String category, float cost) {
		super(id, title, category, cost); 
	}
	
	public Book(String title, String category, float cost) {
		super(title, category, cost); 
	}

	// Override the toString method
    @Override
    public String toString() {
        return "[" + getTitle() + "] - [" + getCategory() + "] - [" + authors + "]: " + getCost() + " $";
    }
}
