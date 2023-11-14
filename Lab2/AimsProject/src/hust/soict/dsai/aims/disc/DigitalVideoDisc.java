//TranTrungKien-20210494

package hust.soict.dsai.aims.disc;

public class DigitalVideoDisc {
	private static int nbDigitalVideoDiscs = 0; // Class attribute to keep track of the number of DVDs
    private int ID;
    private String title;
    private String category;
    private String director;
    private int length;
    private float cost;
    
    // Getter methods to retrieve the properties of the DVD
    public int getID() {
        return ID;
    }

    public String getTitle() {
        return title;
    }
    
    public String getCategory() {
        return category;
    }

    public String getDirector() {
        return director;
    }

    public int getLength() {
        return length;
    }

    public float getCost() {
        return cost;
    }
    
    // Setter method to set the title of the DVD
    public void setTitle(String title) {
        this.title = title;
    }

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
    
}
