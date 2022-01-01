package database;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TableView;
import userdata.Certificate;
import userdata.Course;
import userdata.Level;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class GetCertificates {

    public static TableView<Certificate> certificates() {

        TableView<Certificate> table = new TableView<Certificate>();

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
            String SQL = "SELECT * FROM Certificaat";
            stmt = con.createStatement();
            // Executing the query in the database
            rs = stmt.executeQuery(SQL);

            // If there are results in the ResultSet we go through them here and print them.
            while (rs.next()) {
                // Getting the columns per row
                int id = Integer.parseInt(rs.getString("CertificaatId"));
                double rating = Double.parseDouble(rs.getString("Beoordeling"));
                String nameEmployee = rs.getString("NaamMedewerker");

                table.getItems().add(new Certificate(id, rating, nameEmployee));
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