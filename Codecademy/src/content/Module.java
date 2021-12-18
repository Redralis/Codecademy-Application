package content;

import java.time.LocalDate;

public class Module extends ContentItem{
    private String version;
    private String nameContact;
    private String emailContact;
    private int followNumber;
    
    public Module(int contentItemId, String title, LocalDate publicationDate, Status status , String description, String version, String nameContact, String emailContact, int followNumber){
        super(contentItemId,title,publicationDate,status,description);
        this.version = version;
        this.nameContact = nameContact;
        this.emailContact = emailContact;
        this.followNumber = followNumber;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getNameContact() {
        return nameContact;
    }

    public void setNameContact(String nameContact) {
        this.nameContact = nameContact;
    }

    public String getEmailContact() {
        return emailContact;
    }

    public void setEmailContact(String emailContact) {
        this.emailContact = emailContact;
    }

    public int getFollowNumber() {
        return followNumber;
    }

    public void setFollowNumber(int followNumber) {
        this.followNumber = followNumber;
    }
    
}
