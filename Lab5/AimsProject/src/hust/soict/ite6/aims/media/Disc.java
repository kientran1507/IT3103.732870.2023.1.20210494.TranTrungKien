//TranTrungKien-20210494

package hust.soict.ite6.aims.media;

public class Disc extends Media{
	protected String director;
	protected int length;
	
	public String getDirector() {
		return director;
	}
	public int getLength() {
		return length;
	}
	
	public Disc(String title) {
        super(title);
    }
	
    public Disc(int id, String title, String category, float cost, String director, int length) {
        super(id, title, category, cost);
        this.director = director;
        this.length = length;
    }
    
    public Disc(String title, String category, float cost, String director, int length) {
        super(title, category, cost);
        this.director = director;
        this.length = length;
    }
    
    public Disc(int id, String title, String category, float cost) {
        super(id, title, category, cost);
    }
    
    public Disc(String title, String category, float cost) {
        super(title, category, cost);
    }
}
