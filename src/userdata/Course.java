package userdata;

public class Course {
    private String name;
    private String subject;
    private String introductionText;
    private Level level;

    public Course(String name, String subject, String introductionText, Level level) {
        this.name = name;
        this.subject = subject;
        this.introductionText = introductionText;
        this.level = level;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getIntroductionText() {
        return introductionText;
    }

    public void setIntroductionText(String introductionText) {
        this.introductionText = introductionText;
    }

    public Level getLevel() {
        return level;
    }

    public void setLevel(Level level) {
        this.level = level;
    }
}
