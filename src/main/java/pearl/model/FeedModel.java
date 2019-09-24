package pearl.model;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

/**
 *  Defined Model class for type Feed.
 */

@Entity
@Table(name = "feeds")
public class FeedModel {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "url")
    private String url;

    @Column(name = "title")
    private String title;

    @Column(name = "last_update")
    private Date lastUpdate;

    @Column(name = "feed_name")
    private String feedName;

    @OneToMany
    @JoinColumn(name = "feed_id")
    private List<ItemModel> itemList;

    public FeedModel(String title, Date lastUpdate, String feedName, String url, List<ItemModel> itemList) {
        this.title = title;
        this.lastUpdate = lastUpdate;
        this.feedName = feedName;
        this.url = url;
        this.itemList = itemList;
    }

    public FeedModel() {
    }

    @Override
    public String toString() {
        return "Id:" + getId() + " Url:" + getUrl() + " Title:" + getTitle() + " LastUpdate:" + getLastUpdate() + " FeedName:" + getFeedName();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(Date lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

    public String getFeedName() {
        return feedName;
    }

    public void setFeedName(String feedName) {
        this.feedName = feedName;
    }

    public List<ItemModel> getItemList() {
        return itemList;
    }

    public void setItemList(List<ItemModel> itemList) {
        this.itemList = itemList;
    }




}
