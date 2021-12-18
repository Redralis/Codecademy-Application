package userdata;

public class Certificate {
    private final int certificateId;
    private final double rating;
    private final String nameEmployee;

    public Certificate(int certificateId, double rating, String nameEmployee) {
        this.certificateId = certificateId;
        this.rating = rating;
        this.nameEmployee = nameEmployee;
    }

    public int getCertificateId() {
        return certificateId;
    }

    public double getRating() {
        return rating;
    }

    public String getNameEmployee() {
        return nameEmployee;
    }

}
