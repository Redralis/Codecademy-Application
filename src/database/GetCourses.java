package database;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TableView;
import userdata.Course;
import userdata.Level;
import java.sql.*;

public class GetCourses {

    public static TableView<Course> courses() {

        TableView<Course> table = new TableView<Course>();

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
            String SQL = "SELECT * FROM Cursus";
            stmt = con.createStatement();
            // Executing the query in the database
            rs = stmt.executeQuery(SQL);

            // If there are results in the ResultSet we go through them here and print them.
            while (rs.next()) {
                // Getting the columns per row
                String name = rs.getString("Naam");
                String subject = rs.getString("Onderwerp");
                String introductionText = rs.getString("IntroductieTekst");
                String level = rs.getString("Niveau");

                // Converting level to an enum value.
                Level level1 = Level.valueOf(level);

                table.getItems().add(new Course(name, subject, introductionText, level1));
            }

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

        return table;

    }

    public static ObservableList<String> coursesList() {

        ObservableList<String> courses = FXCollections.observableArrayList();
        ObservableList<String> percBehaald3 = FXCollections.observableArrayList();

        // These are the settings for the connection.
        String connectionUrl = "jdbc:sqlserver://localhost;databaseName=Codecademy;integratedSecurity=true;";

        // Connection controls information about the connection to the database.
        Connection con = null;

        // Statement lets us use SQL query's.
        Statement stmt = null;

        // ResultSet is the table we get from the database.
        // We can iterate through the rows.
        ResultSet rs = null;
        ResultSet rs2 = null;

        try {
            // Importing driver...
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            // Connecting to the database...
            con = DriverManager.getConnection(connectionUrl);

            // Making a SQL query.
            String SQL = "SELECT * FROM Cursus";

            String SQL2 = "SELECT COUNT(FK_Certificaat) * 100 / COUNT(*) FROM Inschrijving AS I JOIN Cursist AS C ON I.FK_Cursist = C.Email ";

            stmt = con.createStatement();
            // Executing the query in the database
            rs = stmt.executeQuery(SQL);
            rs2 = stmt.executeQuery(SQL2);


            // If there are results in the ResultSet we go through them here and print them.
            while (rs.next()) {
                // Getting the columns per row
                String name = rs.getString("Naam");

                // Adding each individual row into the table.
                courses.add(name);
            }
            while (rs2.next()) {
                String percBehaald2 = rs2.getString("Percentage");
                percBehaald3.add(percBehaald2);
            }

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

        // Returning the table.
        return courses ;

    }

}