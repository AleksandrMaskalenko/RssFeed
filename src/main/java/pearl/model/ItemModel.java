package pearl.model;

import javax.persistence.*;
import java.util.Date;

/**
 *  Defined Model class for type Item.
 */

@Entity
@Table(name = "items")
public class ItemModel {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "title")
    private String title;

    @Column(name = "link")
    private String link;

    @Column(name = "description")
    private String description;

    @Column(name = "published")
    private Date published;

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name = "feed_id")
    private FeedModel feedModel;

    public ItemModel(String title, String link, String description, Date published, FeedModel feedModel) {
        this.title = title;
        this.link = link;
        this.description = description;
        this.published = published;
        this.feedModel = feedModel;
    }

    public ItemModel() {
    }

    @Override
    public String toString() {
        return "Title: " + getTitle() + " Link: " + getLink() + " Description: " + getDescription() + " Published: " + getPublished() + " " + getFeedModel();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getPublished() {
        return published;
    }

    public void setPublished(Date published) {
        this.published = published;
    }

    public FeedModel getFeedModel() {
        return feedModel;
    }

    public void setFeedModel(FeedModel feedModel) {
        this.feedModel = feedModel;
    }
}
