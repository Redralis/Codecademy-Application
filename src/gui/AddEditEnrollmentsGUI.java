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

public class AddEditEnrollmentsGUI {
    public Scene getStage() {
        //Creating the layout...
        BorderPane layout = new BorderPane();

        //Creating the menu...
        HBox menu = new HBox();

        //Creating the body...
        GridPane body = new GridPane();

        //Creating buttons for the menu...
        Button back = new Button("Back");
        Label nameText = new Label("Codecademy");
        Button info = new Button("Info");
        Button logout = new Button("Logout");

        //Adding buttons to the menu...
        menu.getChildren().addAll(back, nameText, info, logout);
        menu.setStyle("-fx-background-color: #ffd300;");

        //Converting lists to observablelists for usage within comboboxes
        ObservableList<String> coursesList = FXCollections.observableList(GetCourses.listOfCourseNames());
        ObservableList<String> studentsList = FXCollections.observableList(GetStudents.listOfStudentEmails());

        //Creating buttons for the body...
        Label studentToEnroll = new Label("Student to enroll:");
        final ComboBox studentsBox = new ComboBox(studentsList);
        Label courseToEnroll = new Label("Course to enroll in:");
        final ComboBox coursesBox = new ComboBox(coursesList);
        Button submit = new Button("Submit");


        //Adding buttons to the body...
        body.add(studentToEnroll, 1, 1);
        body.add(studentsBox, 1, 2);
        body.add(courseToEnroll, 1, 3);
        body.add(coursesBox, 1, 4);
        body.add(submit, 1, 5);

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
            EnrollmentsGUI eGui = new EnrollmentsGUI();
            Stage window = MainGUI.getStage();
            window.setScene(eGui.getScene());
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

        //Creating the scrollpane...
        ScrollPane sp = new ScrollPane();

        sp.setContent(layout);
        sp.setFitToHeight(true);
        sp.setFitToWidth(true);
        //Creating the scene...
        return new Scene(sp, 800, 400);
    }

    //You can't edit certificateId, because the pairing happens automatically. The fact that you have to
    //delete a certificate to unpair and create one to pair prevents the user from overflowing the database.
    public Scene editStage(String dateOfEnrollment, String student, String course) {

        //Creating the layout...
        BorderPane layout = new BorderPane();

        //Creating the menu...
        HBox menu = new HBox();

        //Creating the body...
        GridPane body = new GridPane();

        //Creating buttons for the menu...
        Button back = new Button("Back");
        Label nameText = new Label("Codecademy");
        Button info = new Button("Info");
        Button logout = new Button("Logout");

        //Adding buttons to the menu...
        menu.getChildren().addAll(back, nameText, info, logout);
        menu.setStyle("-fx-background-color: #ffd300;");

        //Converting lists to observablelists for usage within comboboxes
        ObservableList<String> coursesList = FXCollections.observableList(GetCourses.listOfCourseNames());
        ObservableList<String> studentsList = FXCollections.observableList(GetStudents.listOfStudentEmails());

        //Separating date of enrollment into day, month and year...
        String[] splitDate = dateOfEnrollment.split("-");
        String year = splitDate[0];
        String month = splitDate[1];
        String day = splitDate[2];


        //Creating buttons for the body...
        Label dateOfEnrollmentDayLabel = new Label("Day of enrollment:  ");
        TextArea dateOfEnrollmentDayField = new TextArea();
        dateOfEnrollmentDayField.setText(day);
        dateOfEnrollmentDayField.setMaxHeight(40);
        Label dateOfEnrollmentMonthLabel = new Label("Month of enrollment:  ");
        TextArea dateOfEnrollmentMonthField = new TextArea();
        dateOfEnrollmentMonthField.setText(month);
        dateOfEnrollmentMonthField.setMaxHeight(40);
        Label dateOfEnrollmentYearLabel = new Label("Year of enrollment:  ");
        TextArea dateOfEnrollmentYearField = new TextArea();
        dateOfEnrollmentYearField.setText(year);
        dateOfEnrollmentYearField.setMaxHeight(40);
        Label studentToEnroll = new Label("Student to enroll:");
        final ComboBox studentsBox = new ComboBox(studentsList);
        studentsBox.setValue(student);
        Label courseToEnroll = new Label("Course to enroll in:");
        final ComboBox coursesBox = new ComboBox(coursesList);
        coursesBox.setValue(course);
        Button submit = new Button("Submit");


        //Adding buttons to the body...
        body.add(dateOfEnrollmentDayLabel, 1, 1);
        body.add(dateOfEnrollmentDayField, 1, 2);
        body.add(dateOfEnrollmentMonthLabel, 1, 3);
        body.add(dateOfEnrollmentMonthField, 1, 4);
        body.add(dateOfEnrollmentYearLabel, 1, 5);
        body.add(dateOfEnrollmentYearField, 1, 6);
        body.add(studentToEnroll, 1, 7);
        body.add(studentsBox, 1, 8);
        body.add(courseToEnroll, 1, 9);
        body.add(coursesBox, 1, 10);
        body.add(submit, 1, 11);

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
            EnrollmentsGUI eGui = new EnrollmentsGUI();
            Stage window = MainGUI.getStage();
            window.setScene(eGui.getScene());
        });
        info.setOnAction(event -> {
            InfoGUI InfoGUI = new InfoGUI();
            Stage window = MainGUI.getStage();
            window.setScene(InfoGUI.getScene());
        });
        submit.setOnAction(event -> {
            String newDateOfEnrollment = dateOfEnrollmentYearField.getText() + "-" + dateOfEnrollmentMonthField.getText() + "-" +
                    dateOfEnrollmentDayField.getText();
            EditItem.editEnrollment(dateOfEnrollment, student, course, newDateOfEnrollment,
                    studentsBox.getValue().toString(), coursesBox.getValue().toString());
            EnrollmentsGUI mGui = new EnrollmentsGUI();
            Stage window = MainGUI.getStage();
            window.setScene(mGui.getScene());
        });

        //Creating the scrollpane...
        ScrollPane sp = new ScrollPane();

        sp.setContent(layout);
        sp.setFitToHeight(true);
        sp.setFitToWidth(true);
        //Creating the scene...
        return new Scene(layout, 800, 400);
    }

}
