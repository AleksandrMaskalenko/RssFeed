package pearl.dao;

import pearl.model.FeedModel;

import java.util.List;

/**
 * Data Access Object for looking up feed related.
 */
public interface FeedDao {

    /**
     * Save the feed model layer
     *
     * @param feedModel feed model
     *
     */
    void saveFeed(FeedModel feedModel);

    /**
     * Retrieves a feed model based on its ID
     *
     * @param id
     *           the Id of the feed model
     * @return feed model
     */
    FeedModel getFeedById(int id);

    /**
     * Retrieves a feed list model based
     *
     * @return feed list model
     */
    List<FeedModel> getListFeeds();

    /**
     * Remove a feed based on its ID
     *
     * @param id
     *           the Id of the feed model
     *
     */
    void removeFeed(int id);
}
