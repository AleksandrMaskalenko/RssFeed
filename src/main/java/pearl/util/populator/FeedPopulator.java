package pearl.util.populator;

import pearl.dto.FeedData;
import pearl.model.FeedModel;

/**
 * Populate the feed model with the feed data
 */
public class FeedPopulator implements Populator<FeedModel, FeedData> {

    @Override
    public void populate(FeedModel source, FeedData target) {
        target.setId(source.getId());
        target.setUrl(source.getUrl());
        target.setFeedName(source.getFeedName());
        target.setLastUpdate(source.getLastUpdate());
    }
}
