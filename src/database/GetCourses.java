package database;

import userdata.Course;
import userdata.Level;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class GetCourses {

    public static List<Course> coursesList() {
        //Connecting to the database...
        DatabaseConnection connect = new DatabaseConnection();
        Connection con = connect.connect();
        List<Course> listOfCourses = new ArrayList<Course>();

        //Statement lets us use SQL query's.
        Statement stmt = null;

        //ResultSet is the table we get from the database.
        //We can iterate through the rows.
        ResultSet rs = null;

        try {

            //Making a SQL query.
            String SQL = "SELECT * FROM Cursus";
            stmt = con.createStatement();
            //Executing the query in the database
            rs = stmt.executeQuery(SQL);

            //If there are results in the ResultSet we go through them here and use them.
            while (rs.next()) {
                //Getting the columns per row
                String name = rs.getString("Naam");
                String subject = rs.getString("Onderwerp");
                String introductionText = rs.getString("IntroductieTekst");
                String level = rs.getString("Niveau");

                //Converting level to an enum value.
                Level level1 = Level.valueOf(level);

                listOfCourses.add(new Course(name, subject, introductionText, level1));
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

        return listOfCourses;

    }

    public static List<String> listOfCourseNames() {
        //Connecting to the database...
        DatabaseConnection connect = new DatabaseConnection();
        Connection con = connect.connect();
        List<String> courses = new ArrayList<String>();

        //Statement lets us use SQL query's.
        Statement stmt = null;

        //ResultSet is the table we get from the database.
        //We can iterate through the rows.
        ResultSet rs = null;

        try {
            //Making a SQL query.
            String SQL = "SELECT * FROM Cursus";

            stmt = con.createStatement();
            //Executing the query in the database
            rs = stmt.executeQuery(SQL);

            //If there are results in the ResultSet we go through them here and use them.
            while (rs.next()) {
                //Getting the columns per row
                String name = rs.getString("Naam");

                //Adding each individual row into the table.
                courses.add(name);
            }

        }

        //Handle any errors that may have occurred.
        catch (Exception e) {
            e.printStackTrace();
        }
        finally {
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
        //Returning the table.
        return courses;

    }

}