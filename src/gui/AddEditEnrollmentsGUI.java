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

public class AddEditEnrollmentsGUI {
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

        //Converting lists to observablelists for usage within comboboxes
        ObservableList<String> coursesList = FXCollections.observableList(GetCourses.listOfCourseNames());

        //creates buttons for body
        Label studentToEnroll = new Label("Student to enroll:");
        ObservableList students = GetStudents.studentsList();
        final ComboBox studentsBox = new ComboBox(students);
        Label courseToEnroll = new Label("Course to enroll in:");
        ObservableList courses = coursesList;
        final ComboBox coursesBox = new ComboBox(courses);
        Button submit = new Button("Submit");


        //adds buttons to body
        body.add(studentToEnroll, 1, 1);
        body.add(studentsBox, 1, 2);
        body.add(courseToEnroll, 1, 3);
        body.add(coursesBox, 1, 4);
        body.add(submit, 1, 5);

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
            AddItem.addEnrollment((String) studentsBox.getValue(), (String) coursesBox.getValue());
            EnrollmentsGUI mGui = new EnrollmentsGUI();
            Stage window = MainGUI.getStage();
            window.setScene(mGui.getScene());
        });

        //creates scrollpane
        ScrollPane sp = new ScrollPane();

        sp.setContent(layout);
        sp.setFitToHeight(true);
        sp.setFitToWidth(true);
        //creates scene
        return new Scene(sp, 800, 200);
    }

    //You can't edit certificateId, because the pairing happens automatically. The fact that you have to
    //delete a certificate to unpair and create one to pair prevents the user from overflowing the database.
    public Scene editStage(String dateOfEnrollment, String student, String course) {

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

        //Converting lists to observablelists for usage within comboboxes
        ObservableList<String> coursesList = FXCollections.observableList(GetCourses.listOfCourseNames());

        //creates buttons for body
        Label dateLabel = new Label("Date of enrollment: ");
        TextArea dateOfEnrollmentField = new TextArea();
        dateOfEnrollmentField.setText(dateOfEnrollment);
        Label studentToEnroll = new Label("Student to enroll:");
        ObservableList students = GetStudents.studentsList();
        final ComboBox studentsBox = new ComboBox(students);
        studentsBox.setValue(student);
        Label courseToEnroll = new Label("Course to enroll in:");
        ObservableList courses = coursesList;
        final ComboBox coursesBox = new ComboBox(courses);
        coursesBox.setValue(course);
        Button submit = new Button("Submit");


        //adds buttons to body
        body.add(dateLabel, 1, 1);
        body.add(dateOfEnrollmentField, 1, 2);
        body.add(studentToEnroll, 1, 3);
        body.add(studentsBox, 1, 4);
        body.add(courseToEnroll, 1, 5);
        body.add(coursesBox, 1, 6);
        body.add(submit, 1, 7);

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
            EditItem.editEnrollment(dateOfEnrollment, student, course, dateOfEnrollmentField.getText(),
                    studentsBox.getValue().toString(), coursesBox.getValue().toString());
            EnrollmentsGUI mGui = new EnrollmentsGUI();
            Stage window = MainGUI.getStage();
            window.setScene(mGui.getScene());
        });

        //creates scrollpane
        ScrollPane sp = new ScrollPane();

        sp.setContent(layout);
        sp.setFitToHeight(true);
        sp.setFitToWidth(true);
        //creates scene
        return new Scene(sp, 800, 220);
    }

}
