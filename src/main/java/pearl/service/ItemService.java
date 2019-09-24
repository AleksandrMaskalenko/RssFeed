package pearl.service;

import pearl.model.ItemModel;

import java.util.List;

/**
 * Item Service interface holding service layer methods for dealing with Item
 *
 */
public interface ItemService {

    /**
     * Retrieves a item list model based
     *
     * @return item list model
     */
    List<ItemModel> getListItems(int id);

    /**
     * Save new item model
     *
     * @param itemModel
     *            new item model
     *
     */
    void saveItem(ItemModel itemModel);

    /**
     * Remove a item based on its ID
     *
     * @param id
     *           the Id of the item model
     *
     */
    void removeItem(int id);
}
