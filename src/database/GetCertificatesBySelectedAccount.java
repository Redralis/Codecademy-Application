package database;

import userdata.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class GetCertificatesBySelectedAccount {

    public static List<CertificateAndStudent> certificatesBySelectedAccount(String student) {

        // Creates a list for the result of the query.
        List<CertificateAndStudent> listOfCertificatesByStudent = new ArrayList<>();

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
            String SQL = "SELECT FK_Cursus, FK_Cursist, Beoordeling, NaamMedewerker FROM Certificaat AS C JOIN Inschrijving AS I ON C.CertificaatId = I.FK_Certificaat JOIN Cursus ON I.FK_Cursus = Cursus.Naam WHERE FK_Cursist = '" + student + "'";

            stmt = con.createStatement();
            // Executing the query in the database
            rs = stmt.executeQuery(SQL);

            // Adds the 4 result values to the result list.
            while (rs.next()) {

                String fk_cursus = rs.getString("FK_Cursus");
                String fk_cursist = rs.getString("FK_Cursist");
                double rating = Double.parseDouble(rs.getString("Beoordeling"));
                String nameEmployee = rs.getString("NaamMedewerker");

                listOfCertificatesByStudent.add(new CertificateAndStudent(fk_cursus, fk_cursist, rating, nameEmployee));

            }

        }

        // Handle any errors that may have occurred.
        catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (rs != null) try {
                rs.close();
            } catch (Exception e) {
            }
            if (stmt != null) try {
                stmt.close();
            } catch (Exception e) {
            }
            if (con != null) try {
                con.close();
            } catch (Exception e) {
            }
        }

        return listOfCertificatesByStudent;

    }




}
