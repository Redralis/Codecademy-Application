package userdata;

import java.time.LocalDate;

public class Enrollment {
    private LocalDate dateOfEnrollment;
    private Certificate certificate;

    public Enrollment() {
        this.dateOfEnrollment = LocalDate.now();
    }

    public LocalDate getDateOfEnrollment() {
        return dateOfEnrollment;
    }

    public void setDateOfEnrollment(LocalDate dateOfEnrollment) {
        this.dateOfEnrollment = dateOfEnrollment;
    }

}
