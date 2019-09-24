package pearl.util.populator;

import pearl.dto.ItemData;
import pearl.model.ItemModel;

/**
 * Populate the item model with the item data
 */
public class ItemPopulator implements Populator<ItemModel, ItemData> {
    @Override
    public void populate(ItemModel source, ItemData target) {
        target.setTitle(source.getTitle());
        target.setDescription(source.getDescription());
        target.setLink(source.getLink());
        target.setPublished(source.getPublished());
    }

}
