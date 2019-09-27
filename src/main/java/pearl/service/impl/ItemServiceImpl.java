package pearl.service.impl;

import org.springframework.beans.factory.annotation.Required;
import org.springframework.stereotype.Service;
import pearl.dao.ItemDao;
import pearl.model.ItemModel;
import pearl.service.ItemService;

import java.util.List;

/**
 *
 * Concrete implementation for the Item service interface {@link ItemService}
 *
 */
public class ItemServiceImpl implements ItemService {

    private ItemDao itemDao;

    @Override
    public List<ItemModel> getListItems(int id) {

        return getItemDao().getListItemsById(id);
    }

    @Override
    public void saveItem(ItemModel itemModel) {
        getItemDao().saveItem(itemModel);
    }

    @Override
    public void removeItem(int id) {
        getItemDao().removeItem(id);
    }

    public ItemDao getItemDao() {
        return itemDao;
    }

    @Required
    public void setItemDao(ItemDao itemDao) {
        this.itemDao = itemDao;
    }
}
