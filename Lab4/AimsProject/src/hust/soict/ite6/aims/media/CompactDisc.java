//TranTrungKien-20210494

package hust.soict.ite6.aims.media;

import java.util.ArrayList;

public class CompactDisc extends Disc implements Playable{
    private String artist;
    private ArrayList<Track> tracks = new ArrayList<>();

    // Constructors for CompactDisc
    public CompactDisc(String title, String category, float cost, String director, int length, String artist) {
        super();
        this.artist = artist;
    }

    // Getter method for artist
    public String getArtist() {
        return artist;
    }

    // Methods for managing tracks
    public void addTrack(Track track) {
        if (!tracks.contains(track)) {
            tracks.add(track);
            System.out.println("Track \"" + track.getTitle() + "\" added to the CD.");
        } else {
            System.out.println("Track \"" + track.getTitle() + "\" is already in the CD.");
        }
    }

    public void removeTrack(Track track) {
        if (tracks.contains(track)) {
            tracks.remove(track);
            System.out.println("Track \"" + track.getTitle() + "\" removed from the CD.");
        } else {
            System.out.println("Track \"" + track.getTitle() + "\" is not in the CD.");
        }
    }

    // Method to calculate the total length of the CD
    public int getLength() {
        int totalLength = 0;
        for (Track track : tracks) {
            totalLength += track.getLength();
        }
        return totalLength;
    }
    // Implement to play a CD
    public void play() {
        System.out.println("Playing CD: " + getTitle());
        System.out.println("CD artist: " + getArtist());
        System.out.println("CD length: " + getLength() + " minutes");

        // Loop through each track and call Track's play() method
        for (Track track : tracks) {
            track.play();
        }
    }
}
