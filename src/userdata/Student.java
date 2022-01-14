package userdata;

public class Student {
    private final String email;
    private final String name;
    private final String dateOfBirth;
    private final Gender gender;
    private final String address;
    private final String city;
    private final String country;
    private final String postalCode;

    public Student(String email, String name, String dateOfBirth, Gender gender, String address, String city, String country, String postalCode) {
        this.email = email;
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.gender = gender;
        this.address = address;
        this.city = city;
        this.country = country;
        this.postalCode = postalCode;
    }

    public String getEmail() {
        return email;
    }

    public String getName() {
        return name;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public Gender getGender() {
        return gender;
    }

    public String getAddress() {
        return address;
    }

    public String getCity() {
        return city;
    }

    public String getCountry() {
        return country;
    }

    public String getPostalCode() {
        return postalCode;
    }
}
