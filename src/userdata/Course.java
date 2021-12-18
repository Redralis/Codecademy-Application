package userdata;

public class Course {
    private final String name;
    private final String subject;
    private final String introductionText;
    private final Level level;

    public Course(String name, String subject, String introductionText, Level level) {
        this.name = name;
        this.subject = subject;
        this.introductionText = introductionText;
        this.level = level;
    }

    public String getName() {
        return name;
    }

    public String getSubject() {
        return subject;
    }

    public String getIntroductionText() {
        return introductionText;
    }

    public Level getLevel() {
        return level;
    }

}
