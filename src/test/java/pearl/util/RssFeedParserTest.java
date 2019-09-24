package pearl.util;

import org.junit.Test;
import pearl.model.FeedModel;

import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class RssFeedParserTest {

    @Test
    public void readTest() {
        RssFeedParser rssFeedParser1 = new RssFeedParser("https://www.15min.lt/rss");
        assertNotNull(rssFeedParser1.read());

        RssFeedParser rssFeedParser2 = new RssFeedParser("https://test/rss");
        assertSame(rssFeedParser2.read(), null);

        assertThrows(RuntimeException.class, () -> {
            RssFeedParser rssFeedParser3 = new RssFeedParser(null);
            assertSame(rssFeedParser3.read(), null);
        });
    }

    @Test
    public void parseFeedTest() {
        RssFeedParser rssFeedParser = new RssFeedParser("https://www.15min.lt/rss");
        FeedModel feedModel = RssFeedParser.parseFeed(rssFeedParser.read());
        assertNotNull(feedModel);
        assertNotNull(feedModel.getTitle());
        assertSame(feedModel.getFeedName(), null);
    }
}