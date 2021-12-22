package content;

import java.time.LocalDate;

public class ContentItem {
    private int contentItemId;
    private String title;
    private LocalDate publicationDate;
    private Status status;
    private String description;
    
    public ContentItem(int contentItemId, String title, LocalDate publicationDate, Status status , String description){
        this.contentItemId = contentItemId;
        this.description = description;
        this.publicationDate = publicationDate;
        this.status = status;
        this.title = title;
    }

    public int getContentItemId() {
        return contentItemId;
    }

    public void setContentItemId(int contentItemId) {
        this.contentItemId = contentItemId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public LocalDate getPublicationDate() {
        return publicationDate;
    }

    public void setPublicationDate(LocalDate publicationDate) {
        this.publicationDate = publicationDate;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    
    
}
