package pearl.facade;

import pearl.dto.FeedData;
import pearl.dto.ItemData;

import java.util.List;

/**
 * Feed facade interface which contains methods for rss feed functionality
 *
 */
public interface FeedFacade {

    /**
     * Add new rss feed by.
     *
     * @param feedData New Feed data.
     *
     */
    void addFeed(FeedData feedData);

    List<FeedData> getListFeeds();

    /**
     * Remove the rss feed by ID.
     *
     * @param id
     *           The id of the Feed for which to retrieve them.
     *
     */
    void removeFeed(int id);

    /**
     * Gets list of item data for feed ID.
     *
     * @param id
     *           The id of the Feed for which to retrieve them.
     * @return list of item data
     */
    List<ItemData> getListItems(int id);

    /**
     * Gets the feed data for ID.
     *
     * @param id
     *           The id of the Feed for which to retrieve them.
     * @return the feed data for GUID
     */
    FeedData getFeedById(int id);

    /**
     * Update the feed by ID.
     *
     * @param id
     *           The id of the Feed for which to retrieve them.
     * @return the feed data for GUID
     */
    FeedData updateFeed(int id);

}
