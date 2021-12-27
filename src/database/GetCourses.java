package database;

import javafx.scene.control.TableView;
import userdata.Course;

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
                Level level1 = Level.valueOf(level);

                Course course = new Course(name, subject, introductionText, level1);
                table.getItems().add(new Course(course.getName(), course.getSubject(), course.getIntroductionText(), course.getLevel()));
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
}