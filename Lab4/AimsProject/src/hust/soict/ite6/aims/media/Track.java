//TranTrungKien-20210494

package hust.soict.ite6.aims.media;

public class Track implements Playable{
    private String title;
    private int length;

    // Constructor for Track
    public Track(String title, int length) {
        this.title = title;
        this.length = length;
    }
    // Implement to play the track
    public void play() {
        System.out.println("Playing Track: " + getTitle());
        System.out.println("Track length: " + getLength());
    }
    // Getter methods for the fields
    public String getTitle() {
        return title;
    }

    public int getLength() {
        return length;
    }
}
