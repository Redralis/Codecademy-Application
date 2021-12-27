package database;

import javafx.scene.control.TableView;
import userdata.Enrollment;
import java.sql.*;

public class GetEnrollments {

    public static TableView<Enrollment> enrollments() {
        TableView<Enrollment> table = new TableView<Enrollment>();

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
            String SQL = "SELECT * FROM Inschrijving";
            stmt = con.createStatement();
            // Executing the query in the database
            rs = stmt.executeQuery(SQL);

            // If there are results in the ResultSet we go through them here and print them.
            while (rs.next()) {
                // Getting the columns per row
                String dateOfEnrollment = rs.getString("InschrijfDatum");

                table.getItems().add(new Enrollment(dateOfEnrollment));
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