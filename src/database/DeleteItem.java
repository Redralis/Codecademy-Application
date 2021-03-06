package database;

import java.sql.*;

public class DeleteItem {

    public static void deleteItem(String item, String object, String condition) {
        //Connecting to the database...
        DatabaseConnection connect = new DatabaseConnection();
        Connection con = connect.connect();

        //Statement lets us use SQL query's.
        Statement stmt = null;

        //ResultSet is the table we get from the database.
        //We can iterate through the rows.
        ResultSet rs = null;

        try {
            //Making a SQL query.
            String SQL = "DELETE FROM " + object + " WHERE " + condition + "='" + item + "'";
            stmt = con.createStatement();
            //Executing the query in the database
            rs = stmt.executeQuery(SQL);

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

    }

    public static void deleteItem(String item, String item2, String item3, String object, String condition,
                                  String condition2, String condition3) {
        //Connecting to the database...
        DatabaseConnection connect = new DatabaseConnection();
        Connection con = connect.connect();
        //Statement lets us use SQL query's.
        Statement stmt = null;

        //ResultSet is the table we get from the database.
        //We can iterate through the rows.
        ResultSet rs = null;

        try {
            //Making a SQL query.
            String SQL = "DELETE FROM " + object + " WHERE " + condition + "='" + item + "' AND "
                    + condition2 + "='" + item2 + "' AND " + condition3 + "='" + item3 + "'";
            stmt = con.createStatement();
            //Executing the query in the database
            rs = stmt.executeQuery(SQL);

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

    }

}