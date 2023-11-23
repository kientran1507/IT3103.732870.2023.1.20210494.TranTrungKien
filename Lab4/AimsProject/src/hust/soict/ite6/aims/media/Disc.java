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
	
	public Disc(String director, int length) {
		super();
		this.director = director;
		this.length = length;
	}
	public Disc() {
		// TODO Auto-generated constructor stub
	}
}
