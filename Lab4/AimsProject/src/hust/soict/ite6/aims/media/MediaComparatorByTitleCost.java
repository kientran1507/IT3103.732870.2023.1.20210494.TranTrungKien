//TranTrungKien-20210494

package hust.soict.ite6.aims.media;

import java.util.Comparator;

public class MediaComparatorByTitleCost implements Comparator<Media> {
    @Override
    public int compare(Media media1, Media media2) {
        int titleComparison = media1.getTitle().compareTo(media2.getTitle());
        if (titleComparison == 0) {
            // If titles are the same, sort by higher cost first
            return Float.compare(media2.getCost(), media1.getCost());
        }
        return titleComparison;
    }
}