package pearl.dto;

import java.util.Date;

/**
 *  Defined Data transfer object for type Feed
 */

public class FeedData {
    private int id;
    private String url;
    private String feedName;
    private Date lastUpdate;
    private int articleCount;

    public FeedData(int id, String url, String feedName, Date lastUpdate, int articleCount) {
        this.id = id;
        this.url = url;
        this.feedName = feedName;
        this.lastUpdate = lastUpdate;
        this.articleCount = articleCount;
    }

    public FeedData() {
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getFeedName() {
        return feedName;
    }

    public void setFeedName(String feedName) {
        this.feedName = feedName;
    }

    public Date getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(Date lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getArticleCount() {
        return articleCount;
    }

    public void setArticleCount(int articleCount) {
        this.articleCount = articleCount;
    }
}
