package pearl.dto;

import java.util.Date;

/**
 *  Defined Data transfer object for type Item
 */

public class ItemData {
    private String title;
    private String link;
    private String description;
    private Date published;

    public ItemData(String title, String link, String description, Date published) {
        this.title = title;
        this.link = link;
        this.description = description;
        this.published = published;
    }

    public ItemData() {
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
}
