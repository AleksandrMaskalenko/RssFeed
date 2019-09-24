package pearl.util;

import org.junit.Test;
import pearl.model.ItemModel;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class ItemsSortTest {

    @Test
    public void compareTest() throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("dd-M-yyyy hh:mm:ss");
        List<ItemModel> list = new ArrayList<>();
        list.add(new ItemModel(null, null, null, sdf.parse("23-09-2015 10:20:56"), null));
        list.add(new ItemModel(null, null, null, sdf.parse("20-09-2015 10:20:56"), null));
        list.add(new ItemModel(null, null, null, null, null));
        list.add(new ItemModel(null, null, null, sdf.parse("24-09-2015 10:20:56"), null));

        list.sort(new ItemsSort());

        assertEquals(sdf.parse("24-09-2015 10:20:56"), list.get(0).getPublished());
        assertEquals(sdf.parse("23-09-2015 10:20:56"), list.get(1).getPublished());
        assertEquals(sdf.parse("20-09-2015 10:20:56"), list.get(2).getPublished());
        assertSame(list.get(3).getPublished(), null);

    }
}