package database;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Overviews {

    public static String amountOfCompletions(String course) {
        //Connecting to the database...
        DatabaseConnection connect = new DatabaseConnection();
        Connection con = connect.connect();

        //Statement lets us use SQL query's.
        Statement stmt = null;

        //ResultSet is the table we get from the database.
        //We can iterate through the rows.
        ResultSet rs = null;

        String amountOfCertificatedBySelectedStudent = "0";


        try {

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

    public static List<String> mostViewedWebcasts() {
        //Connecting to the database...
        DatabaseConnection connect = new DatabaseConnection();
        Connection con = connect.connect();

        //Statement lets us use SQL query's.
        Statement stmt = null;

        //ResultSet is the table we get from the database.
        //We can iterate through the rows.
        ResultSet rs = null;

        // In this list will the top 3 most viewed webcasts be stored
        List<String> listOfMostViewedWebcasts = new ArrayList<>();


        try {

            // The query which requests the top 3 most viewed webcasts
            String SQL = "SELECT Titel FROM ContentItem WHERE ContentItemId IN (SELECT TOP 3 FK_ContentItem FROM Webcast ORDER BY Aantal_weergaven DESC)";

            stmt = con.createStatement();
            //Executing the query in the database
            rs = stmt.executeQuery(SQL);

            while (rs.next()) {

                String title = rs.getString("Titel");
                // Add the top 3 most viewed webcasts one by one into the list
                listOfMostViewedWebcasts.add(title);
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

        return listOfMostViewedWebcasts;
    }

    public static List<String> PercentageWatched(String student) {
        //Connecting to the database...
        DatabaseConnection connect = new DatabaseConnection();
        Connection con = connect.connect();

        //Statement lets us use SQL query's.
        Statement stmt = null;

        //ResultSet is the table we get from the database.
        //We can iterate through the rows.
        ResultSet rs = null;

        // In this list the webcasts the student has watched will be stored.
        List<String> listOfViewedWebcasts = new ArrayList<>();


        try {

            // The query which requests the top 3 most viewed webcasts
            String SQL = "SELECT ContentItem.Titel, Koppeltabel_ContentItem_Cursist.Voortgang FROM Cursist " +
                    "LEFT JOIN Koppeltabel_ContentItem_Cursist ON Cursist.Email = " +
                    "Koppeltabel_ContentItem_Cursist.FK_Cursist LEFT JOIN ContentItem ON " +
                    "Koppeltabel_ContentItem_Cursist.FK_ContentItem = ContentItem.ContentItemId LEFT JOIN Webcast ON " +
                    "ContentItem.ContentItemId = Webcast.FK_ContentItem WHERE Cursist.Email = '" + student + "' AND " +
                    "ContentItem.ContentItemId = Webcast.FK_ContentItem";

            stmt = con.createStatement();
            //Executing the query in the database
            rs = stmt.executeQuery(SQL);

            while (rs.next()) {
                String webcast = rs.getString("Titel");
                String percent = rs.getString("Voortgang");

                //Adding webcast and percentage to the list...
                listOfViewedWebcasts.add("Webcast name: " + webcast + ", percentage viewed: " + percent + "%.");
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

        return listOfViewedWebcasts;
    }

    public static List<String> PercentageComplete(String student) {
        //Connecting to the database...
        DatabaseConnection connect = new DatabaseConnection();
        Connection con = connect.connect();

        //Statement lets us use SQL query's.
        Statement stmt = null;

        //ResultSet is the table we get from the database.
        //We can iterate through the rows.
        ResultSet rs = null;

        // In this list the webcasts the student has watched will be stored.
        List<String> listOfStartedModules = new ArrayList<>();


        try {

            // The query which requests the top 3 most viewed webcasts
            String SQL = "SELECT ContentItem.Titel, Koppeltabel_ContentItem_Cursist.Voortgang FROM Cursist " +
                    "LEFT JOIN Koppeltabel_ContentItem_Cursist ON Cursist.Email = " +
                    "Koppeltabel_ContentItem_Cursist.FK_Cursist LEFT JOIN ContentItem ON " +
                    "Koppeltabel_ContentItem_Cursist.FK_ContentItem = ContentItem.ContentItemId LEFT JOIN Module ON " +
                    "ContentItem.ContentItemId = Module.FK_ContentItem WHERE Cursist.Email = '" + student + "' AND " +
                    "ContentItem.ContentItemId = Module.FK_ContentItem";

            stmt = con.createStatement();
            //Executing the query in the database
            rs = stmt.executeQuery(SQL);

            while (rs.next()) {
                String module = rs.getString("Titel");
                String percent = rs.getString("Voortgang");

                //Adding module and percentage to the list...
                listOfStartedModules.add("Module name: " + module + ", percentage of progress: " + percent + "%.");
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

        return listOfStartedModules;
    }

    public static List<String> certificatesBySelectedAccount(String student) {
        //Connecting to the database...
        DatabaseConnection connect = new DatabaseConnection();
        Connection con = connect.connect();

        //Creates a list for the result of the query.
        List<String> listOfCertificatesByStudent = new ArrayList<String>();

        //Statement lets us use SQL query's.
        Statement stmt = null;

        //ResultSet is the table we get from the database.
        //We can iterate through the rows.
        ResultSet rs = null;

        try {

            //Making a SQL query.
            String SQL = "SELECT FK_Cursus, FK_Cursist, Beoordeling, NaamMedewerker FROM Certificaat AS C JOIN Inschrijving AS I ON C.CertificaatId = I.FK_Certificaat JOIN Cursus ON I.FK_Cursus = Cursus.Naam WHERE FK_Cursist = '" + student + "'";

            stmt = con.createStatement();
            //Executing the query in the database
            rs = stmt.executeQuery(SQL);

            //Adds the 4 result values to the result list.
            while (rs.next()) {

                String fk_cursus = rs.getString("FK_Cursus");
                String fk_cursist = rs.getString("FK_Cursist");
                double rating = Double.parseDouble(rs.getString("Beoordeling"));
                String nameEmployee = rs.getString("NaamMedewerker");

                listOfCertificatesByStudent.add("Cursist: " + fk_cursist + "\t\t" + "Cursus: " + fk_cursus +
                        "\t\t" + "Rating: " + rating + "\t\t" + "Medewerker: " + nameEmployee + ".");

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

        return listOfCertificatesByStudent;

    }

    public static String percentageByGender(String gender) {
        //Connecting to the database...
        DatabaseConnection connect = new DatabaseConnection();
        Connection con = connect.connect();
        String gender2 = "";

        if (gender.equals("Male")) {
            gender2 = "Man";
        }
        if (gender.equals("Female")) {
            gender2 = "Vrouw";
        }

        //Statement lets us use SQL query's.
        Statement stmt = null;

        //ResultSet is the table we get from the database.
        //We can iterate through the rows.
        ResultSet rs = null;

        //In this variable, the result percentage of the SQL query will be stored.
        String percentage = "";

        try {

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

    public static List<String> unlinkedModules() {
        //Connecting to the database...
        DatabaseConnection connect = new DatabaseConnection();
        Connection con = connect.connect();

        //Creates a list for the result of the query.
        List<String> unlinkedModules = new ArrayList<String>();

        //Statement lets us use SQL query's.
        Statement stmt = null;

        //ResultSet is the table we get from the database.
        //We can iterate through the rows.
        ResultSet rs = null;

        try {

            //Making a SQL query.
            String SQL = "SELECT Titel FROM ContentItem RIGHT JOIN Module ON ContentItem.ContentItemId = " +
                    "Module.FK_ContentItem WHERE Module.FK_Cursus " + "IS NULL";

            stmt = con.createStatement();
            //Executing the query in the database
            rs = stmt.executeQuery(SQL);

            //Adds the 4 result values to the result list.
            while (rs.next()) {

                String module = rs.getString("Titel");

                unlinkedModules.add(module);
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

        return unlinkedModules;

    }

    public static void linkModule(String course, String moduleId) {
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
            String SQL = "UPDATE Module SET FK_Cursus = '" + course + "' WHERE Module.FK_ContentItem = " + moduleId;

            stmt = con.createStatement();
            //Executing the query in the database
            rs = stmt.executeQuery(SQL);
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

    }

    public static String getModuleId(String module) {
        //Connecting to the database...
        DatabaseConnection connect = new DatabaseConnection();
        Connection con = connect.connect();
        String moduleId = "";

        //Statement lets us use SQL query's.
        Statement stmt = null;

        //ResultSet is the table we get from the database.
        //We can iterate through the rows.
        ResultSet rs = null;

        try {

            //Making a SQL query.
            String SQL = "SELECT ContentItemId FROM ContentItem WHERE Titel = '" + module + "'";

            stmt = con.createStatement();
            //Executing the query in the database
            rs = stmt.executeQuery(SQL);

            while (rs.next()) {
                moduleId = rs.getString("ContentItemId");
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

        return moduleId;

    }

    public static List<String> percentageByStudentAndCourse(String student, String course) {
        //Connecting to the database...
        DatabaseConnection connect = new DatabaseConnection();
        Connection con = connect.connect();
        //Creates a list for the result of the query.
        List<String> listOfStudentsAndCourses = new ArrayList<String>();

        //Statement lets us use SQL query's.
        Statement stmt = null;

        //ResultSet is the table we get from the database.
        //We can iterate through the rows.
        ResultSet rs = null;

        try {

            //Making a SQL query.
            String SQL = "SELECT ContentItem.Titel AS Titel, Koppel.Voortgang AS Voortgang FROM Cursist JOIN Koppeltabel_ContentItem_Cursist AS Koppel ON Cursist.Email = Koppel.FK_Cursist JOIN ContentItem ON Koppel.FK_ContentItem = ContentItem.ContentItemId JOIN Module ON ContentItem.ContentItemId = Module.FK_ContentItem JOIN Cursus ON Module.FK_Cursus = Cursus.Naam WHERE Cursist.Email = '" + student + "' AND Cursus.Naam = '" + course + "'";

            stmt = con.createStatement();
            //Executing the query in the database
            rs = stmt.executeQuery(SQL);

            //Adds the result values to the result list.
            while (rs.next()) {

                String titel = rs.getString("Titel");
                String voortgang = rs.getString("Voortgang");

                listOfStudentsAndCourses.add("Titel: " + titel + "\t\t" + "Voortgang: " + voortgang + "%");
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

        // Returns the results in a list
        return listOfStudentsAndCourses;

    }

    public static List<String> averageProgressionInCourse(String course) {
        //Connecting to the database...
        DatabaseConnection connect = new DatabaseConnection();
        Connection con = connect.connect();
        //Creates a list for the result of the query.
        List<String> listOfAverageProgress = new ArrayList<String>();

        //Statement lets us use SQL query's.
        Statement stmt = null;

        //ResultSet is the table we get from the database.
        //We can iterate through the rows.
        ResultSet rs = null;

        try {

            //Making a SQL query.
            String SQL = "SELECT ContentItem.Titel, SUM(Koppel.Voortgang) / COUNT(Koppel.Voortgang) AS " +
                    "GemiddeldePercentagePerModule FROM ContentItem JOIN Koppeltabel_ContentItem_Cursist AS Koppel ON " +
                    "ContentItem.ContentItemId = Koppel.FK_ContentItem JOIN Module ON ContentItem.ContentItemId = " +
                    "Module.FK_ContentItem JOIN Cursus ON Module.FK_Cursus = Cursus.Naam WHERE Cursus.Naam = '" + course
                    + "' " + "GROUP BY ContentItem.Titel";

            stmt = con.createStatement();
            //Executing the query in the database
            rs = stmt.executeQuery(SQL);

            //Adds the result values to the result list.
            while (rs.next()) {

                String title = rs.getString("Titel");
                String averageProgress = rs.getString("GemiddeldePercentagePerModule");

                listOfAverageProgress.add(title + " " + averageProgress);
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

        // Returns the results in a list
        return listOfAverageProgress;

    }

}