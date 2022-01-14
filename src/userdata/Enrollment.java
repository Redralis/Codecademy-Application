package userdata;

public class Enrollment {
    private final String dateOfEnrollment;
    private String certificate;
    private String student;
    private String course;

    public Enrollment(String dateOfEnrollment, String student, String course, String certificate) {
        this.dateOfEnrollment = dateOfEnrollment;
        this.student = student;
        this.course = course;
        this.certificate = certificate;
    }

    public String getDateOfEnrollment() {
        return dateOfEnrollment;
    }

    public String getStudent() {
        return student;
    }

    public String getCourse() {
        return course;
    }

    public String getCertificate() {
        return certificate;
    }
}
