package content;

import java.time.LocalDate;

public class Webcast extends ContentItem{
    private int duration;
    private String url;
    private String nameLecturer;
    private String organisation;
    
    public Webcast(int contentItemId, String title, LocalDate publicationDate, Status status , String description, int duration, String url, String nameLecturer, String organisation){
        super(contentItemId,title,publicationDate,status,description);
        this.duration = duration;
        this.url = url;
        this.nameLecturer = nameLecturer;
        this.organisation = organisation;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getNameLecturer() {
        return nameLecturer;
    }

    public void setNameLecturer(String nameLecturer) {
        this.nameLecturer = nameLecturer;
    }

    public String getOrganisation() {
        return organisation;
    }

    public void setOrganisation(String organisation) {
        this.organisation = organisation;
    }
    
    
}
