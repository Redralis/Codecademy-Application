package database;

import java.sql.*;
import java.time.LocalDate;

public class EditItem {

    public static void coupleCertificate(int id, String student, String course) {

        LocalDate date = LocalDate.now();

        // These are the settings for the connection.
        String connectionUrl = "jdbc:sqlserver://localhost;databaseName=Codecademy;integratedSecurity=true;";

        // Connection controls information about the connection to the database.
        Connection con = null;

        // Statement lets us use SQL query's.
        Statement stmt = null;

        // ResultSet is the table we get from the database.
        // We can iterate through the rows.
        ResultSet rs = null;

        try {
            // Importing driver...
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            // Connecting to the database...
            con = DriverManager.getConnection(connectionUrl);

            // Making a SQL query.
            String SQL = "UPDATE Inschrijving SET FK_Certificaat = " + id + " WHERE FK_Cursist = '" + student + "' AND " +
                    "FK_Cursus = '" + course + "';";
            stmt = con.createStatement();
            // Executing the query in the database
            rs = stmt.executeQuery(SQL);

        }

        // Handle any errors that may have occurred.
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

        LocalDate date = LocalDate.now();

        // These are the settings for the connection.
        String connectionUrl = "jdbc:sqlserver://localhost;databaseName=Codecademy;integratedSecurity=true;";

        // Connection controls information about the connection to the database.
        Connection con = null;

        // Statement lets us use SQL query's.
        Statement stmt = null;

        // ResultSet is the table we get from the database.
        // We can iterate through the rows.
        ResultSet rs = null;

        try {
            // Importing driver...
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            // Connecting to the database...
            con = DriverManager.getConnection(connectionUrl);

            // Making a SQL query.
            String SQL = "UPDATE Cursus SET Naam = '" + name + "', Onderwerp = '" + subject + "', IntroductieTekst = '"
                    + introductionText + "', Niveau = '" + level + "' WHERE Naam = '" + previousName + "'";
            stmt = con.createStatement();
            // Executing the query in the database
            rs = stmt.executeQuery(SQL);

        }

        // Handle any errors that may have occurred.
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