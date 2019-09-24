package pearl.util.populator;

import org.junit.Test;
import pearl.dto.FeedData;
import pearl.model.FeedModel;

import java.util.Date;

import static org.junit.Assert.*;

public class FeedPopulatorTest {

    @Test
    public void populate() {
        Date date = new Date();
        FeedModel feedModel = new FeedModel(null, date, "testFeedName", "testUrl", null);
        FeedData feedData = new FeedData();

        new FeedPopulator().populate(feedModel, feedData);
        assertNotNull(feedData);
        assertEquals(feedData.getUrl(), "testUrl");
        assertEquals(feedData.getFeedName(), "testFeedName");
        assertEquals(feedData.getLastUpdate(), date);
    }
}