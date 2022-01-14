package database;

import userdata.CertificateAndStudent;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class GetPercentageByGender {

        public static String percentageByGender(String gender) {

            String gender2 = "";

            if (gender.equals("Male")) {
                gender2 = "Man";
            }
            if (gender.equals("Female")) {
                gender2 = "Vrouw";
            }

            //Creates a list for the result of the query.
            List<CertificateAndStudent> listOfCertificatesByStudent = new ArrayList<>();

            //These are the settings for the connection.
            String connectionUrl = "jdbc:sqlserver://localhost;databaseName=Codecademy;integratedSecurity=true;";

            //Connection controls information about the connection to the database.
            Connection con = null;

            //Statement lets us use SQL query's.
            Statement stmt = null;

            //ResultSet is the table we get from the database.
            //We can iterate through the rows.
            ResultSet rs = null;

            //In this variable, the result percentage of the SQL query will be stored.
            String percentage = "";

            try {
                //Importing driver...
                Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
                //Connecting to the database...
                con = DriverManager.getConnection(connectionUrl);

                //Making a SQL query.
                String SQL = "SELECT COUNT(FK_Certificaat) * 100 / COUNT(*) AS PercentageOfCompletion FROM Inschrijving AS I JOIN Cursist AS C ON I.FK_Cursist = C.Email WHERE Geslacht = '" + gender2 + "'";

                stmt = con.createStatement();
                //Executing the query in the database
                rs = stmt.executeQuery(SQL);

                //Putting the result of the SQL query in the return string
                while (rs.next()) {

                    percentage = rs.getString("PercentageOfCompletion");

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

            //Returns the percentage of the completion rate by gender.
            return percentage + "%";

        }






























}
