//TranTrungKien-20210494

package hust.soict.ite6.aims.media;

import hust.soict.ite6.aims.exception.PlayerException;

public class DigitalVideoDisc extends Disc implements Playable {
    private static int nbDigitalVideoDiscs = 0; // Class attribute to keep track of the number of DVDs
    private int id;
    // Constructor with only title
    public DigitalVideoDisc(String title) {
        super(title);
        this.id= ++nbDigitalVideoDiscs;
    }

    // Constructor with title, category, and cost
    public DigitalVideoDisc(String title, String category, float cost) {
        super(title, category, cost);
        this.id = ++nbDigitalVideoDiscs;
    }
    
 // Constructor with ID, title, category, and cost
    public DigitalVideoDisc(int id, String title, String category, float cost) {
        super(id, title, category, cost);
        this.id = ++nbDigitalVideoDiscs;
    }

    // Constructor with ID, title, category, director, and cost
    public DigitalVideoDisc(String title, String category, String director, float cost) {
        super(title, category, cost);
        this.director = director;
        this.id = ++nbDigitalVideoDiscs;
    }

    // Constructor with ID, title, category, director, length, and cost
    public DigitalVideoDisc(String title, String category, String director, int length, float cost) {
        super(title, category, cost);
        this.director = director;
        this.length = length;
        this.id = ++nbDigitalVideoDiscs;
    }

    // Override the toString method
    @Override
    public String toString() {
        return "[" + getTitle() + "] - [" + getCategory() + "] - [" + getDirector() + "] - [" + getLength() + "]: " + getCost() + " $";
    }
    
    @Override
    public void play() throws PlayerException {
        if (this.getLength() <= 0) {
            System.err.println("Error: Cannot play the Digital Video Disc. Length is not set or invalid.");
            throw new PlayerException("Invalid length for Digital Video Disc.");
        }
        System.out.println("Playing Digital Video Disc " + getTitle());
        System.out.println("DVD length: " + getLength());
    }
}
