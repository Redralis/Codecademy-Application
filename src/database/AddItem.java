package database;

import java.sql.*;
import java.time.LocalDate;

public class AddItem {

    public static void addCourse(String name, String subject, String introductionText, String level) {
        //Connecting to the database...
        DatabaseConnection connect = new DatabaseConnection();
        Connection con = connect.connect();
        
        //Statement lets us use SQL query's.
        Statement stmt = null;

        //ResultSet is the table we get from the database.
        //We can iterate through the rows.
        ResultSet rs = null;

        try {
            //Making a SQL query.
            String SQL = "INSERT Cursus VALUES ('" + name + "', '" + subject + "', '" + introductionText + "', '"
                    + level + "', NULL)";
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

    public static void addStudent(String email, String name, String dateOfBirth, String gender, String address,
                                  String city, String country, String postalCode) {
        //Connecting to the database...
        DatabaseConnection connect = new DatabaseConnection();
        Connection con = connect.connect();
        //Statement lets us use SQL query's.
        Statement stmt = null;

        //ResultSet is the table we get from the database.
        //We can iterate through the rows.
        ResultSet rs = null;

        try {
            //Making a SQL query.
            String SQL = "INSERT Cursist VALUES ('" + email + "', '" + name + "', '" + dateOfBirth + "', '"
                    + gender + "', '" + address + "', '" + city + "', '" + country + "', '" + postalCode + "')";
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

    public static void addEnrollment(String student, String course) {
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
            String SQL = "INSERT Inschrijving VALUES ('" + date + "', '" + student + "', NULL, '" + course + "')";
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

    public static void addCertificate(double rating, String nameEmployee) {
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
            String SQL = "INSERT Certificaat VALUES ('" + rating + "', '" + nameEmployee + "')";
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