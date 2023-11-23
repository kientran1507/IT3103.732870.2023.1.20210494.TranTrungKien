//TranTrungKien-20210494

package hust.soict.ite6.aims.media;

public class DigitalVideoDisc extends Disc implements Playable{
	private static int nbDigitalVideoDiscs = 0; // Class attribute to keep track of the number of DVDs

    // Constructor with only title
    public DigitalVideoDisc(String title) {
        super();
        this.ID = ++nbDigitalVideoDiscs;
        this.title = title;
    }

    // Constructor with ID, title, category, and cost
    public DigitalVideoDisc(String title, String category, float cost) {
        super();
        this.ID = ++nbDigitalVideoDiscs;
        this.title = title;
        this.category = category;
        this.cost = cost;
    }

    // Constructor with ID, title, category, director, and cost
    public DigitalVideoDisc(String title, String category, String director, float cost) {
        super();
        this.ID = ++nbDigitalVideoDiscs;
        this.title = title;
        this.category = category;
        this.director = director;
        this.cost = cost;
    }

    // Constructor with ID, title, category, director, length, and cost
    public DigitalVideoDisc(String title, String category, String director, int length, float cost) {
        super();
        this.ID = ++nbDigitalVideoDiscs;
        this.title = title;
        this.category = category;
        this.director = director;
        this.length = length;
        this.cost = cost;
    }
    // Override the toString method
    public String toString() {
        return "[" + title + "] - [" + category + "] - [" + director + "] - [" + length + "]: " + cost + " $";
    }
    // Implement to play the DVD
    public void play() {
        System.out.println("Playing DVD: " + getTitle());
        System.out.println("DVD length: " + getLength());
    }
    
}
