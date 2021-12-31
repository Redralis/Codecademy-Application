package userdata;

import java.time.LocalDate;

public class Enrollment {
    private final String dateOfEnrollment;
    private Certificate certificate;
    private String student;

    public Enrollment(String dateOfEnrollment, String student) {
        this.dateOfEnrollment = dateOfEnrollment;
    }

    public String getDateOfEnrollment() {
        return dateOfEnrollment;
    }

    public String getStudent() {
        return student;
    }

    public Certificate getCertificate() {
        return certificate;
    }

}
