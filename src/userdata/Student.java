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

    //This code checks whether an email matches the input: <1OrMoreLetters@1OrMoreLetters.1OrMoreLetters>
    public boolean validateEmail(String email) {
        return email.matches("^[a-zA-Z]+@[a-zA-Z]+.[a-zA-Z]+$");
    }

    //This code checks whether the day and month are 2 characters long and the year is 4 characters long.
    public boolean validateDateOfBirth(int day, int month, int year) {
        return day > 9 & month > 9 & year > 999;
    }

    //This code checks whether the postal code is a valid Dutch postal code. 4 numbers, a space and then 2 letters.
    //The first number must not be 0, and the letters must be capitalized.
    public boolean validatePostalCode(String postalCode) {
        return postalCode.matches("^[1-9][0-9]{3} [A-Z]{2}$");
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
