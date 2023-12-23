//TranTrungKien-20210494

package hust.soict.ite6.aims.media;

import java.util.Objects;

import hust.soict.ite6.aims.exception.PlayerException;

public class Track implements Playable{
    private String title;
    private int length;

    // Constructor for Track
    public Track(String title, int length) {
        this.title = title;
        this.length = length;
    }
    
    @Override
    public void play() throws PlayerException {
        if (getLength() <= 0) {
            System.err.println("Error: Cannot play the Track. Length is not set or invalid.");
            throw new PlayerException("Invalid length for Track.");
        }
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
