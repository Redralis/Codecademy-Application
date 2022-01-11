package userdata;

public class CertificateAndStudent {

    private final String fk_cursus;
    private final String fk_cursist;
    private final double rating;
    private final String nameEmployee;

    public CertificateAndStudent(String fk_cursus, String fk_cursist, double rating, String nameEmployee) {
        this.fk_cursus= fk_cursus;
        this.fk_cursist = fk_cursist;
        this.rating = rating;
        this.nameEmployee = nameEmployee;
    }

    @Override
    public String toString() {
        return "Cursist: " + this.fk_cursist + "\t\t" + "Cursus: " + this.fk_cursus + "\t\t" + "Rating: " + this.rating + "\t\t" + "Medewerker: " + this.nameEmployee;
    }
}
