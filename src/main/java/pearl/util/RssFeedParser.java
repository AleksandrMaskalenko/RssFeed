package pearl.util;

import com.rometools.rome.feed.synd.SyndEntry;
import com.rometools.rome.feed.synd.SyndFeed;
import com.rometools.rome.io.SyndFeedInput;
import com.rometools.rome.io.XmlReader;
import org.apache.log4j.Logger;
import pearl.model.FeedModel;
import pearl.model.ItemModel;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 *
 * XML Feed parser implementation from url
 *
 */
public class RssFeedParser {
    private static final Logger LOG = Logger.getLogger(RssFeedParser.class);
    private final URL url;

    public RssFeedParser(String url) {
        try {
            this.url = new URL(url);
        } catch (MalformedURLException e) {
            throw new RuntimeException();
        }
    }

    /**
     * Read rss feed from url.
     *
     * @return comparison result
     */
    public SyndFeed read() {
        try {
            SyndFeedInput input = new SyndFeedInput();
            return input.build(new XmlReader(url.openConnection()));
        } catch (Exception e) {
            LOG.error("Can't connect to url" + getUrl());
            return null;
        }
    }

    /**
     * Parse form SyndFeed to FeedModel
     *
     * @param feed SyndFeed
     *
     * @return parsed Feed model
     */
    public static FeedModel parseFeed(SyndFeed feed) {

        FeedModel feedModel;

        try {
            feedModel = new FeedModel(feed.getTitle(), feed.getPublishedDate(), null, null, new ArrayList());

            List entries = feed.getEntries();
            Iterator iterator = entries.iterator();

            while (iterator.hasNext()) {
                SyndEntry entry = (SyndEntry) iterator.next();
                ItemModel item = new ItemModel();
                item.setTitle(entry.getTitle());
                item.setLink(entry.getLink());
                item.setDescription(entry.getDescription().getValue());
                item.setPublished(entry.getPublishedDate());
                feedModel.getItemList().add(item);
            }

        } catch (Exception e) {
            LOG.error("An error occurred wile trying to parse Feed!", e);
            return null;
        }

        return feedModel;
    }


    public URL getUrl() {
        return url;
    }
}
