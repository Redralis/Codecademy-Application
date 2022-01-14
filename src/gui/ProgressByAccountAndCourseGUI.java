package gui;

import database.GetCourses;
import database.GetStudents;
import database.Overviews;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

import java.util.List;

public class ProgressByAccountAndCourseGUI {
    public Scene getScene() {
        //Creating the layout...
        BorderPane layout = new BorderPane();

        //Creating the menu...
        HBox menu = new HBox();

        //Creating the body...
        GridPane body = new GridPane();

        //Creates resultfield in the GUI
        HBox resultBox = new HBox();
        Label result = new Label();
        resultBox.getChildren().add(result);
        resultBox.setStyle("-fx-background-color: #7fb7d4");
        resultBox.setAlignment(Pos.BASELINE_CENTER);
        layout.setBottom(resultBox);

        //Creating buttons for the menu...
        Button back = new Button("Back");
        Label nameText = new Label("Codecademy");
        Button info = new Button("Info");
        Button logout = new Button("Logout");

        //Adding buttons to the menu...
        menu.getChildren().addAll(back, nameText, info, logout);
        menu.setStyle("-fx-background-color: #ffd300;");

        //Creating buttons for the body...
        ObservableList<String> coursesList = FXCollections.observableList(GetCourses.listOfCourseNames());
        ObservableList<String> studentsList = FXCollections.observableList(GetStudents.listOfStudentEmails());

        //Creating buttons for the body...
        Label student = new Label("Select student: ");
        final ComboBox studentsBox = new ComboBox(studentsList);
        Label course = new Label("Select course: ");
        final ComboBox coursesBox = new ComboBox(coursesList);
        Button show = new Button("Show");


        //Adding buttons to the body...
        body.add(student, 1, 1);
        body.add(studentsBox, 1, 2);
        body.add(course, 1, 3);
        body.add(coursesBox, 1, 4);
        body.add(show, 1, 5);
        body.setStyle("-fx-background-color: #fff0e5");

        //Adding menu and body to the layout...
        HBox.setMargin(nameText, new Insets(10, 10, 10, 10));
        menu.setAlignment(Pos.BASELINE_CENTER);
        layout.setTop(menu);
        layout.setCenter(body);

        //Positioning the buttons...
        body.setAlignment(Pos.BASELINE_CENTER);

        //Giving the buttons function...
        logout.setOnAction((event) -> {
            System.exit(1);
        });
        back.setOnAction(event -> {
            HomeScreenGUI hGui = new HomeScreenGUI();
            Stage window = MainGUI.getStage();
            window.setScene(hGui.getScene());
        });
        info.setOnAction(event -> {
            InfoGUI InfoGUI = new InfoGUI();
            Stage window = MainGUI.getStage();
            window.setScene(InfoGUI.getScene());
        });
        show.setOnAction(event -> {

            //Calling the function that makes and executes a query and returns the results in a String.
            List<String> results = Overviews.percentageByStudentAndCourse((String) studentsBox.getValue(), (String) coursesBox.getValue());

            StringBuilder sb = new StringBuilder();
            for (String s : results) {
                sb.append(s + "\n");
            }

            //Shows the result on the screen, when clicked on show
            result.setText("Module en voortgang\n" + sb.toString());


        });

        //Creating the scrollpane...
        ScrollPane sp = new ScrollPane();

        sp.setContent(layout);
        sp.setFitToHeight(true);
        sp.setFitToWidth(true);
        //Creating the scene...
        return new Scene(layout, 800, 600);
    }
}
