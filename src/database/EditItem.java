package database;

import java.sql.*;
import java.time.LocalDate;

public class EditItem {

    public static void coupleCertificate(int id, String student, String course) {
        //Connecting to the database...
        DatabaseConnection connect = new DatabaseConnection();
        Connection con = connect.connect();
        LocalDate date = LocalDate.now();

        //Statement lets us use SQL query's.
        Statement stmt = null;

        //ResultSet is the table we get from the database.
        //We can iterate through the rows.
        ResultSet rs = null;

        try {
            //Making a SQL query.
            String SQL = "UPDATE Inschrijving SET FK_Certificaat = " + id + " WHERE FK_Cursist = '" + student + "' AND " +
                    "FK_Cursus = '" + course + "';";
            stmt = con.createStatement();
            //Executing the query in the database
            rs = stmt.executeQuery(SQL);

        }

        //Handle any errors that may have occurred.
        catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            if (rs != null) try { rs.close(); } catch(Exception e) {}
            if (stmt != null) try { stmt.close(); } catch(Exception e) {}
            if (con != null) try { con.close(); } catch(Exception e) {}
        }
    }

    public static void editCourse(String previousName, String name, String subject, String introductionText, String level) {
        //Connecting to the database...
        DatabaseConnection connect = new DatabaseConnection();
        Connection con = connect.connect();
        LocalDate date = LocalDate.now();

        //Statement lets us use SQL query's.
        Statement stmt = null;

        //ResultSet is the table we get from the database.
        //We can iterate through the rows.
        ResultSet rs = null;

        try {
            //Making a SQL query.
            String SQL = "UPDATE Cursus SET Naam = '" + name + "', Onderwerp = '" + subject + "', IntroductieTekst = '"
                    + introductionText + "', Niveau = '" + level + "' WHERE Naam = '" + previousName + "'";
            stmt = con.createStatement();
            //Executing the query in the database
            rs = stmt.executeQuery(SQL);

        }

        //Handle any errors that may have occurred.
        catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            if (rs != null) try { rs.close(); } catch(Exception e) {}
            if (stmt != null) try { stmt.close(); } catch(Exception e) {}
            if (con != null) try { con.close(); } catch(Exception e) {}
        }
    }

    public static void editStudent(String previousEmail, String email, String name, String dateOfBirth, String gender,
                                   String address, String city, String country, String postalCode) {
        //Connecting to the database...
        DatabaseConnection connect = new DatabaseConnection();
        Connection con = connect.connect();
        LocalDate date = LocalDate.now();

        //Statement lets us use SQL query's.
        Statement stmt = null;

        //ResultSet is the table we get from the database.
        //We can iterate through the rows.
        ResultSet rs = null;

        try {
            //Formatting gender...
            if (gender.equals("M")) {
                gender = "Man";
            } else {
                gender = "Vrouw";
            }

            //Making a SQL query.
            String SQL = "UPDATE Cursist SET Email = '" + email + "', Naam = '" + name + "', GeboorteDatum = '"
                    + dateOfBirth + "', Geslacht = '" + gender + "', Adres = '" + address + "', Woonplaats = '" + city +
                     "', Land = '" + country + "', PostCode = '" + postalCode + "' WHERE email = '" + previousEmail
                    + "'";
            stmt = con.createStatement();
            //Executing the query in the database
            rs = stmt.executeQuery(SQL);

        }

        //Handle any errors that may have occurred.
        catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            if (rs != null) try { rs.close(); } catch(Exception e) {}
            if (stmt != null) try { stmt.close(); } catch(Exception e) {}
            if (con != null) try { con.close(); } catch(Exception e) {}
        }
    }

    public static void editEnrollment(String previousDateOfEnrollment, String previousStudent, String previousCourse,
                                      String dateOfEnrollment, String student, String course) {
        //Connecting to the database...
        DatabaseConnection connect = new DatabaseConnection();
        Connection con = connect.connect();
        LocalDate date = LocalDate.now();

        //Statement lets us use SQL query's.
        Statement stmt = null;

        //ResultSet is the table we get from the database.
        //We can iterate through the rows.
        ResultSet rs = null;

        try {
            //Making a SQL query.
            String SQL = "UPDATE Inschrijving SET InschrijfDatum = '" + dateOfEnrollment + "', FK_Cursist = '"
                    + student + "', FK_Cursus = '" + course + "' WHERE InschrijfDatum = '" + previousDateOfEnrollment +
                    "' AND FK_Cursist = '" + previousStudent + "' AND FK_Cursus = '" + previousCourse + "'";
            stmt = con.createStatement();
            //Executing the query in the database
            rs = stmt.executeQuery(SQL);

        }

        //Handle any errors that may have occurred.
        catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            if (rs != null) try { rs.close(); } catch(Exception e) {}
            if (stmt != null) try { stmt.close(); } catch(Exception e) {}
            if (con != null) try { con.close(); } catch(Exception e) {}
        }
    }

    public static void editCertificate(String id, String rating, String nameEmployee) {
        //Connecting to the database...
        DatabaseConnection connect = new DatabaseConnection();
        Connection con = connect.connect();
        LocalDate date = LocalDate.now();

        //Statement lets us use SQL query's.
        Statement stmt = null;

        //ResultSet is the table we get from the database.
        //We can iterate through the rows.
        ResultSet rs = null;

        try {

            //Making a SQL query.
            String SQL = "UPDATE Certificaat SET Beoordeling = '" + rating + "', NaamMedewerker = '" + nameEmployee +
                    "' WHERE CertificaatId = '" + id + "'";
            stmt = con.createStatement();
            //Executing the query in the database
            rs = stmt.executeQuery(SQL);

        }

        //Handle any errors that may have occurred.
        catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            if (rs != null) try { rs.close(); } catch(Exception e) {}
            if (stmt != null) try { stmt.close(); } catch(Exception e) {}
            if (con != null) try { con.close(); } catch(Exception e) {}
        }
    }

}