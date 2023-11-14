//TranTrungKien-20210494
public class DigitalVideoDisc {
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

    // Constructor with only ID and title
    public DigitalVideoDisc(int iD, String title) {
        super();
        ID = iD;
        this.title = title;
    }

    // Constructor with ID, title, category, and cost
    public DigitalVideoDisc(int iD, String title, String category, float cost) {
        super();
        ID = iD;
        this.title = title;
        this.category = category;
        this.cost = cost;
    }

    // Constructor with ID, title, category, director, and cost
    public DigitalVideoDisc(int iD, String title, String category, String director, float cost) {
        super();
        ID = iD;
        this.title = title;
        this.category = category;
        this.director = director;
        this.cost = cost;
    }

    // Constructor with ID, title, category, director, length, and cost
    public DigitalVideoDisc(int iD, String title, String category, String director, int length, float cost) {
        super();
        ID = iD;
        this.title = title;
        this.category = category;
        this.director = director;
        this.length = length;
        this.cost = cost;
    }
}