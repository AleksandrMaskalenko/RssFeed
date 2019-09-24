package pearl.dao;

import pearl.model.ItemModel;

import java.util.List;

/**
 * Data Access Object for looking up items related.
 */
public interface ItemDao {

    /**
     * Save the item model layer
     *
     * @param itemModel item model
     *
     */
    void saveItem(ItemModel itemModel);

    /**
     * Retrieves a item list model based
     *
     * @return item list model
     */
    List<ItemModel> getListItemsById(int id);

    /**
     * Remove a feed based on its ID
     *
     * @param id
     *           the Id of the feed model
     *
     */
    void removeItem(int id);
}
