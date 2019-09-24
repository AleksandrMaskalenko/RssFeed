package pearl.util.populator;

import org.junit.Test;
import pearl.dto.ItemData;
import pearl.model.ItemModel;

import java.util.Date;

import static org.junit.Assert.*;

public class ItemPopulatorTest {

    @Test
    public void populate() {
        Date date = new Date();
        ItemModel itemModel = new ItemModel("testTitle", "testLink", "testDescription", date, null);
        ItemData itemData = new ItemData();

        new ItemPopulator().populate(itemModel, itemData);
        assertNotNull(itemData);
        assertEquals(itemData.getTitle(), "testTitle");
        assertEquals(itemData.getLink(), "testLink");
        assertEquals(itemData.getDescription(), "testDescription");
        assertEquals(itemData.getPublished(), date);
    }
}