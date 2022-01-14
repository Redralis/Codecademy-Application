package gui;

import database.AddItem;
import database.EditItem;
import database.GetCourses;
import database.GetStudents;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import userdata.Course;

public class ProgressCoursesGUI {
    public Scene getStage() {
        //creates layout
        BorderPane layout = new BorderPane();

        //creates menu
        HBox menu = new HBox();

        //creates body
        GridPane body = new GridPane();

        //creates buttons for menu
        Button back = new Button("Back");
        Label nameText = new Label("Codecademy");
        Button info = new Button("Info");
        Button logout = new Button("Logout");

        //adds buttons to menu
        menu.getChildren().addAll(back, nameText, info, logout);
        menu.setStyle("-fx-background-color: #ffd300;");

        //Converting list of courses to an observablelist...
        ObservableList<String> coursesList = FXCollections.observableList(GetCourses.listOfCourseNames());

        //creates buttons for body
        Label studentToEnroll = new Label("Choose the course: ");
        final ComboBox coursesBox = new ComboBox(coursesList);

        Button submit = new Button("Submit");
        Label averageProgression = new Label();

        //adds buttons to body
        body.add(studentToEnroll, 1, 1);
        body.add(coursesBox, 1, 2);
        body.add(submit, 1, 3);
        body.add(averageProgression, 1,4);

        body.setStyle("-fx-background-color: #fff0e5");

        //adds menu and body to layout
        HBox.setMargin(nameText, new Insets(10, 10, 10, 10));
        menu.setAlignment(Pos.BASELINE_CENTER);
        layout.setTop(menu);
        layout.setCenter(body);

        //gives positioning to the buttons
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
        submit.setOnAction(event -> {
        averageProgression.setText("The average progression for this course is: " );

        });

        //creates scrollpane
        ScrollPane sp = new ScrollPane();

        sp.setContent(layout);
        sp.setFitToHeight(true);
        sp.setFitToWidth(true);
        //creates scene
        return new Scene(layout, 800, 400);
    }



}
