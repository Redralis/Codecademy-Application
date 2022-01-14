package database;

import java.sql.*;

public class Overviews {

    public static String amountOfCompletions(String course) {


        //These are the settings for the connection.
        String connectionUrl = "jdbc:sqlserver://localhost;databaseName=Codecademy;integratedSecurity=true;";

        //Connection controls information about the connection to the database.
        Connection con = null;

        //Statement lets us use SQL query's.
        Statement stmt = null;

        //ResultSet is the table we get from the database.
        //We can iterate through the rows.
        ResultSet rs = null;

        String amountOfCertificatedBySelectedStudent = "0";


        try {
            //Importing driver...
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            //Connecting to the database...
            con = DriverManager.getConnection(connectionUrl);

            //Making a SQL query.
            String SQL = "SELECT Count(*) AS Aantal FROM Certificaat AS C JOIN Inschrijving AS I ON C.CertificaatId = I.FK_Certificaat JOIN Cursus ON I.FK_Cursus = Cursus.Naam WHERE Cursus.Naam = '" + course + "'";

            stmt = con.createStatement();
            //Executing the query in the database
            rs = stmt.executeQuery(SQL);

            while (rs.next()) {

                amountOfCertificatedBySelectedStudent = rs.getString("Aantal");

            }

        }

        //Handle any errors that may have occurred.
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

        return amountOfCertificatedBySelectedStudent;
    }
}