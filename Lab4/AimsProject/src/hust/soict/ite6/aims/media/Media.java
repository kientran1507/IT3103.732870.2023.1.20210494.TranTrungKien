//TranTrungKien-20210494

package hust.soict.ite6.aims.media;

import java.util.Objects;
import java.util.Comparator;

public abstract class Media {
	protected int ID;
	protected String title; 
	protected String category;
	protected float cost;
	
	// Getter methods for media
	public int getID() {
		return ID;
	}
	public String getTitle() {
		return title;
	}
	public String getCategory() {
		return category;
	}
	public float getCost() {
		return cost;
	}

	public void setTitle(String title) {
		this.title = title;
	}
	public Media() {
		// TODO Auto-generated constructor stub
	}
	
	// Override equals method for Media class
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Media media = (Media) obj;
        return Objects.equals(title, media.title);
    }
    
    public static final Comparator<Media> COMPARE_BY_TITLE_COST = new MediaComparatorByTitleCost();
    public static final Comparator<Media> COMPARE_BY_COST_TITLE = new MediaComparatorByCostTitle();
}
