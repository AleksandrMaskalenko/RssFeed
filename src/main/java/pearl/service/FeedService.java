package pearl.service;

import pearl.model.FeedModel;

import java.util.List;

/**
 * Feed Service interface holding service layer methods for dealing with Feed
 *
 */
public interface FeedService {

    /**
     * Retrieves a feed list model based
     *
     * @return feed list model
     */
    List<FeedModel> getListFeeds();

    /**
     * Retrieves a feed model based on its ID
     *
     * @param id
     *           the Id of the feed model
     * @return feed model
     */
    FeedModel getFeedsById(int id);

    /**
     * Save new feed model
     *
     * @param feedModel
     *            new feed model
     *
     */
    void saveFeed(FeedModel feedModel);

    /**
     * Remove a feed based on its ID
     *
     * @param id
     *           the Id of the feed model
     *
     */
    void removeFeed(int id);

}
