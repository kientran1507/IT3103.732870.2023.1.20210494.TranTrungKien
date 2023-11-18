package hust.soict.ite6.aims.media;

public class Track {
    private String title;
    private int length;

    // Constructor for Track
    public Track(String title, int length) {
        this.title = title;
        this.length = length;
    }

    // Getter methods for the fields
    public String getTitle() {
        return title;
    }

    public int getLength() {
        return length;
    }
}
