package database;

import userdata.Enrollment;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class GetEnrollments {

    public static List<Enrollment> enrollmentsList() {
        //Connecting to the database...
        DatabaseConnection connect = new DatabaseConnection();
        Connection con = connect.connect();
        List<Enrollment> listOfEnrollments = new ArrayList<Enrollment>();

        //Statement lets us use SQL query's.
        Statement stmt = null;

        //ResultSet is the table we get from the database.
        //We can iterate through the rows.
        ResultSet rs = null;

        try {

            //Making a SQL query.
            String SQL = "SELECT * FROM Inschrijving";
            stmt = con.createStatement();
            //Executing the query in the database
            rs = stmt.executeQuery(SQL);

            //If there are results in the ResultSet we go through them here and use them.
            while (rs.next()) {
                //Getting the columns per row
                String dateOfEnrollment = rs.getString("InschrijfDatum");
                String student = rs.getString("FK_Cursist");
                String course = rs.getString("FK_Cursus");
                String certificate = rs.getString("FK_Certificaat");

                listOfEnrollments.add(new Enrollment(dateOfEnrollment, student, course, certificate));
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

        return listOfEnrollments;

    }

    public static List<String> enrollmentsStudentAndCourseList() {
        //Connecting to the database...
        DatabaseConnection connect = new DatabaseConnection();
        Connection con = connect.connect();
        List<String> enrollments = new ArrayList<String>();

        //Statement lets us use SQL query's.
        Statement stmt = null;

        //ResultSet is the table we get from the database.
        //We can iterate through the rows.
        ResultSet rs = null;

        try {

            //Making a SQL query.
            String SQL = "SELECT * FROM Inschrijving";
            stmt = con.createStatement();
            //Executing the query in the database
            rs = stmt.executeQuery(SQL);

            //If there are results in the ResultSet we go through them here and use them.
            while (rs.next()) {
                //Getting the columns per row
                String student = rs.getString("FK_Cursist");
                String course = rs.getString("FK_Cursus");

                //Adding each individual row into the table.
                enrollments.add(student + ", " + course);
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

        //Returning the table.
        return enrollments;

    }

}