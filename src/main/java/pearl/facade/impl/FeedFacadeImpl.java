package pearl.facade.impl;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.beans.factory.annotation.Value;
import pearl.dto.FeedData;
import pearl.dto.ItemData;
import pearl.facade.FeedFacade;
import pearl.model.FeedModel;
import pearl.model.ItemModel;
import pearl.service.FeedService;
import pearl.service.ItemService;
import pearl.util.ItemsSort;
import pearl.util.RssFeedParser;
import pearl.util.populator.FeedPopulator;
import pearl.util.populator.ItemPopulator;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Implementation of {@link FeedFacade}
 */
public class FeedFacadeImpl implements FeedFacade {
    private static final Logger LOG = Logger.getLogger(FeedFacadeImpl.class);

    @Value("${article.count}")
    private String articleCount;

    private FeedService feedService;
    private FeedPopulator feedPopulator;
    private ItemService itemService;
    private ItemPopulator itemPopulator;

    @Override
    public void addFeed(FeedData feedData) {

        if(feedData.getUrl() != null || feedData.getFeedName() != null) {
            FeedModel feedModel =  downloadFeed(feedData.getUrl());

            if (feedModel != null) {
                feedModel.setFeedName(feedData.getFeedName());
                feedModel.setUrl(feedData.getUrl());

                getFeedService().saveFeed(feedModel);
            }
        }
    }

    /**
     * Download rss feed by url and parse to FeedModel
     *
     * @param url
     *           The url of the Feed for which to retrieve them.
     * @return Feed Model
     */
    private FeedModel downloadFeed(String url) {

        try {
            RssFeedParser rssFeedParser = new RssFeedParser(url);
            return RssFeedParser.parseFeed(rssFeedParser.read());

        } catch (Exception e) {
            LOG.error("Can't set url " + url + "for parser.");
            return null;
        }

    }

    @Override
    public List<FeedData> getListFeeds() {
        List<FeedModel> feedModelList = getFeedService().getListFeeds();
        List<FeedData> feedDataList = new ArrayList<>();

        for (FeedModel feedModel: feedModelList) {
            FeedData feedData = new FeedData();
            getFeedPopulator().populate(feedModel, feedData);
            feedDataList.add(feedData);
        }

        return feedDataList;
    }

    @Override
    public FeedData getFeedById(int id) {
        FeedData feedData = new FeedData();
        getFeedPopulator().populate(getFeedService().getFeedsById(id), feedData);
        feedData.setArticleCount(getItemService().getListItems(id).size());

        return feedData;
    }

    @Override
    public void removeFeed(int id) {
        List<ItemModel> listItems = getItemService().getListItems(id);

        listItems.forEach(i -> getItemService().removeItem(i.getId()));
        getFeedService().removeFeed(id);
    }

    @Override
    public List<ItemData> getListItems(int id) {
        List<ItemModel> itemModelList = getFiveRecentArticles(getItemService().getListItems(id));
        List<ItemData> itemDataList = new ArrayList<>();

        for (ItemModel itemModel: itemModelList) {
            ItemData itemData = new ItemData();
            getItemPopulator().populate(itemModel, itemData);
            itemDataList.add(itemData);
        }

        return itemDataList;
    }

    /**
     * Sort and get latest list of item model.
     *
     * @param listItems
     *           The total list of item for current feed.
     * @return total list of item model
     */
    private List<ItemModel> getFiveRecentArticles(List<ItemModel> listItems) {
        listItems.sort(new ItemsSort());
        return listItems.stream().limit(Integer.parseInt(articleCount)).collect(Collectors.toList());
    }

    @Override
    public FeedData updateFeed(int id) {
        FeedModel feedModel = getFeedService().getFeedsById(id);
        FeedModel updatedFeed =  downloadFeed(feedModel.getUrl());

        if (updatedFeed != null) {
            updatedFeed.setFeedName(feedModel.getFeedName());
            updatedFeed.setUrl(feedModel.getUrl());
            removeFeed(feedModel.getId());

            getFeedService().saveFeed(updatedFeed);

            return getFeedById(updatedFeed.getId());
        } else {
            return getFeedById(feedModel.getId());
        }
    }

    @Required
    public void setFeedService(FeedService feedService) {
        this.feedService = feedService;
    }

    public FeedService getFeedService() {
        return feedService;
    }

    public FeedPopulator getFeedPopulator() {
        return feedPopulator;
    }

    @Required
    public void setFeedPopulator(FeedPopulator feedPopulator) {
        this.feedPopulator = feedPopulator;
    }

    public ItemService getItemService() {
        return itemService;
    }

    @Required
    public void setItemService(ItemService itemService) {
        this.itemService = itemService;
    }

    public ItemPopulator getItemPopulator() {
        return itemPopulator;
    }

    @Required
    public void setItemPopulator(ItemPopulator itemPopulator) {
        this.itemPopulator = itemPopulator;
    }
}
