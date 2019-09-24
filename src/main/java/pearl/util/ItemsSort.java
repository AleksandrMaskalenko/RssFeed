package pearl.util;

import pearl.model.ItemModel;

import java.util.Comparator;

public class ItemsSort implements Comparator<ItemModel> {

    @Override
    public int compare(ItemModel it1, ItemModel it2) {

        if (it1.getPublished() == null && it2.getPublished() == null) {
            return 0;
        } else if (it1.getPublished() == null) {
            return 1;
        } else if (it2.getPublished() == null) {
            return -1;
        }

        return dateCompare(it1, it2);

    }

    private int dateCompare(ItemModel it1, ItemModel it2) {
        if (it1.getPublished().after(it2.getPublished())) {
            return -1;
        } else if (it1.getPublished().before(it2.getPublished())) {
            return 1;
        }
        return 0;
    }
}
