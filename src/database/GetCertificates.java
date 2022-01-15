package database;

import userdata.Certificate;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class GetCertificates {

    public static List<Certificate> certificatesList() {
        //Connecting to the database...
        DatabaseConnection connect = new DatabaseConnection();
        Connection con = connect.connect();
        List<Certificate> certificates = new ArrayList<Certificate>();

        //Statement lets us use SQL query's.
        Statement stmt = null;

        //ResultSet is the table we get from the database.
        //We can iterate through the rows.
        ResultSet rs = null;

        try {
            //Making a SQL query.
            String SQL = "SELECT * FROM Certificaat";
            stmt = con.createStatement();
            //Executing the query in the database
            rs = stmt.executeQuery(SQL);

            //If there are results in the ResultSet we go through them here and use them.
            while (rs.next()) {
                //Getting the columns per row
                int id = Integer.parseInt(rs.getString("CertificaatId"));
                double rating = Double.parseDouble(rs.getString("Beoordeling"));
                String nameEmployee = rs.getString("NaamMedewerker");

                certificates.add(new Certificate(id, rating, nameEmployee));
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

        return certificates;

    }

    public static int latestId() {
        //Connecting to the database... //Connecting to the database...
        DatabaseConnection connect = new DatabaseConnection();
        Connection con = connect.connect();
        int biggestId = 0;

        //Statement lets us use SQL query's.
        Statement stmt = null;

        //ResultSet is the table we get from the database.
        //We can iterate through the rows.
        ResultSet rs = null;

        try {

            //Making a SQL query.
            String SQL = "SELECT * FROM Certificaat";
            stmt = con.createStatement();
            //Executing the query in the database
            rs = stmt.executeQuery(SQL);

            //If there are results in the ResultSet we go through them here and use them.
            while (rs.next()) {
                //Getting the columns per row
                int id = Integer.parseInt(rs.getString("CertificaatId"));
                if (id > biggestId) {
                    biggestId = id;
                }
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

        return biggestId++;

    }


}