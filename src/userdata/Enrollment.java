package userdata;

import java.time.LocalDate;

public class Enrollment {
    private final LocalDate dateOfEnrollment;
    private Certificate certificate;

    public Enrollment(String dateOfEnrollment) {
        this.dateOfEnrollment = LocalDate.now();
    }

    public LocalDate getDateOfEnrollment() {
        return dateOfEnrollment;
    }

    public Certificate getCertificate() {
        return certificate;
    }

}
