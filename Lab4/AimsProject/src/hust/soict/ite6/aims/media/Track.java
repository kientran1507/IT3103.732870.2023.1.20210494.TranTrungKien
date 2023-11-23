//TranTrungKien-20210494

package hust.soict.ite6.aims.media;

import java.util.Objects;

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
    // Override equals method for Track class
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Track track = (Track) obj;
        return Objects.equals(title, track.title) && length == track.length;
    }
}
