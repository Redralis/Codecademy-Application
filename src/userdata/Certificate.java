package userdata;

public class Certificate {
    private int certificateId;
    private double rating;
    private String nameEmployee;

    public Certificate(int certificateId, double rating, String nameEmployee) {
        this.certificateId = certificateId;
        this.rating = rating;
        this.nameEmployee = nameEmployee;
    }

    public int getCertificateId() {
        return certificateId;
    }

    public void setCertificateId(int certificateId) {
        this.certificateId = certificateId;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public String getNameEmployee() {
        return nameEmployee;
    }

    public void setNameEmployee(String nameEmployee) {
        this.nameEmployee = nameEmployee;
    }

}
