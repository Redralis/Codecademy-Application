package database;

import userdata.Gender;
import userdata.Student;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class GetStudents {

    public static List<Student> studentsList() {

        List<Student> students = new ArrayList<Student>();

        //These are the settings for the connection.
        String connectionUrl = "jdbc:sqlserver://localhost;databaseName=Codecademy;integratedSecurity=true;";

        //Connection controls information about the connection to the database.
        Connection con = null;

        //Statement lets us use SQL query's.
        Statement stmt = null;

        //ResultSet is the table we get from the database.
        //We can iterate through the rows.
        ResultSet rs = null;

        try {
            //Importing driver...
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            //Connecting to the database...
            con = DriverManager.getConnection(connectionUrl);

            //Making a SQL query.
            String SQL = "SELECT * FROM Cursist";
            stmt = con.createStatement();
            //Executing the query in the database
            rs = stmt.executeQuery(SQL);

            //If there are results in the ResultSet we go through them here and use them.
            while (rs.next()) {
                //Getting the columns per row
                String email = rs.getString("Email");
                String name = rs.getString("Naam");
                String dateOfBirth = rs.getString("GeboorteDatum");
                String gender = rs.getString("Geslacht");
                String address = rs.getString("Adres");
                String city = rs.getString("Woonplaats");
                String country = rs.getString("Land");
                String postalCode = rs.getString("PostCode");

                //Converting gender to an enum value
                Gender gender1;
                if (gender.equals("Man")) {
                    gender1 = Gender.valueOf("M");
                } else {
                    gender1 = Gender.valueOf("F");
                }

                //Adding each individual row into the table.
                students.add(new Student(email, name, dateOfBirth, gender1, address, city,
                        country, postalCode));
            }

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

        //Returning the table.
        return students;

    }

    public static List<String> listOfStudentEmails() {

        List<String> students = new ArrayList<String>();

        //These are the settings for the connection.
        String connectionUrl = "jdbc:sqlserver://localhost;databaseName=Codecademy;integratedSecurity=true;";

        //Connection controls information about the connection to the database.
        Connection con = null;

        //Statement lets us use SQL query's.
        Statement stmt = null;

        //ResultSet is the table we get from the database.
        //We can iterate through the rows.
        ResultSet rs = null;

        try {
            //Importing driver...
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            //Connecting to the database...
            con = DriverManager.getConnection(connectionUrl);

            //Making a SQL query.
            String SQL = "SELECT * FROM Cursist";
            stmt = con.createStatement();
            //Executing the query in the database
            rs = stmt.executeQuery(SQL);

            //If there are results in the ResultSet we go through them here and use them.
            while (rs.next()) {
                //Getting the columns per row
                String email = rs.getString("Email");

                //Adding each individual row into the table.
                students.add(email);
            }

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

        //Returning the table.
        return students;

    }

}