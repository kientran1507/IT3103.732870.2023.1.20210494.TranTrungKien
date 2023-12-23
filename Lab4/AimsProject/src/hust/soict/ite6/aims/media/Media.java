//TranTrungKien-20210494

package hust.soict.ite6.aims.media;

import java.util.Objects;
import java.util.Comparator;

public abstract class Media {
	private int ID;
	private String title; 
	private String category;
	private float cost;
	
	// Getter methods for media
	public int getID() {
		return ID;
	}
	public int getId() {
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
	// Setter methods for media
	public void setId(int nextID) {
		this.ID = nextID;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	

	public void setCategory(String category) {
		this.category = category;
	}
	public void setCost(float cost) {
		this.cost = cost;
	}
	
	public Media(String title) {
        super();
        this.title = title;
    }
	
	public Media(int iD, String title, String category, float cost) {
		super();
		ID = iD;
		this.title = title;
		this.category = category;
		this.cost = cost;
	}
	
	public Media(String title, String category, float cost) {
		super();
		this.title = title;
		this.category = category;
		this.cost = cost;
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
