package pearl.service.impl;

import org.springframework.stereotype.Service;
import pearl.dao.FeedDao;
import pearl.dao.ItemDao;
import pearl.model.FeedModel;
import pearl.service.FeedService;

import java.util.List;

/**
 *
 * Concrete implementation for the Feed service interface {@link FeedService}
 *
 */
@Service
public class FeedServiceImpl implements FeedService {

    private FeedDao feedDao;
    private ItemDao itemDao;

    @Override
    public List<FeedModel> getListFeeds() {
        return getFeedDao().getListFeeds();
    }

    @Override
    public FeedModel getFeedsById(int id) {
        return getFeedDao().getFeedById(id);
    }

    @Override
    public void saveFeed(FeedModel feedModel) {

        if (feedModel != null) {
            feedModel.getItemList().forEach(item -> getItemDao().saveItem(item));
            getFeedDao().saveFeed(feedModel);
        }
    }

    @Override
    public void removeFeed(int id) {
        getFeedDao().removeFeed(id);
    }

    public void setFeedDao(FeedDao feedDao) {
        this.feedDao = feedDao;
    }

    public FeedDao getFeedDao() {
        return feedDao;
    }

    public ItemDao getItemDao() {
        return itemDao;
    }

    public void setItemDao(ItemDao itemDao) {
        this.itemDao = itemDao;
    }
}
