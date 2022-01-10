package gui;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.stage.Stage;

public class HomeScreenGUI extends Application {

    public Scene getScene() {

        //Creating the layout...
        BorderPane layout = new BorderPane();

        //Creating the menu...
        HBox menu = new HBox();

        //Creating the body...
        HBox body = new HBox();
        HBox body2 = new HBox();
        //Creating buttons for the menu...
        Label nameText = new Label("Codecademy");
        Button info = new Button("Info");
        Button logout = new Button("Logout");

        //Creating buttons for the body...
        Button courses = new Button("Cursussen");
        Button enrollments = new Button("Inschrijvingen");
        Button students = new Button("Studenten");
        Button certificates = new Button("Certificaten");

        HBox.setHgrow(courses, Priority.ALWAYS);
        HBox.setHgrow(enrollments, Priority.ALWAYS);
        HBox.setHgrow(students, Priority.ALWAYS);
        HBox.setHgrow(certificates, Priority.ALWAYS);

        courses.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
        enrollments.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
        students.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
        certificates.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);

        courses.setStyle("-fx-font-size:30");
        enrollments.setStyle("-fx-font-size:30");
        students.setStyle("-fx-font-size:30");
        certificates.setStyle("-fx-font-size:30");

        //creating body2 buttons...
        Button webcast = new Button("Webcasts");

        //styling body2 buttons...
        webcast.setStyle("-fx-font-size:30");
        //Adding to the menu...
        menu.getChildren().addAll(nameText, info, logout);
        menu.setStyle("-fx-background-color: #ffd300;");

        //Adding to the body...
        body.getChildren().addAll(courses, enrollments, students, certificates);
        body.setStyle("-fx-background-color: #fff0e5");

        //Adding to body2...
        body2.getChildren().add(webcast);
        body2.setStyle("-fx-background-color: #fff0e5");

        //Adding menu to layout...
        HBox.setMargin(nameText, new Insets(10, 10, 10, 10));
        menu.setAlignment(Pos.BASELINE_CENTER);
        layout.setTop(menu);

        //Adding body to layout...
        layout.setCenter(body);


        //Adding body2 to layout...
        layout.setBottom(body2);

        //Positioning the buttons...
        body.setAlignment(Pos.BASELINE_CENTER);
        courses.setTranslateX(5);
        courses.setTranslateY(45);
        enrollments.setTranslateX(5);
        enrollments.setTranslateY(45);
        students.setTranslateX(5);
        students.setTranslateY(45);
        certificates.setTranslateX(5);
        certificates.setTranslateY(45);

        //Positioning the body2...
        body2.setAlignment(Pos.BASELINE_CENTER);
        webcast.setTranslateX(25);
        webcast.setTranslateY(1);

        //Giving buttons function...
        logout.setOnAction(event -> {
            System.exit(1);
        });
        courses.setOnAction(event -> {
            CoursesGUI mGui = new CoursesGUI();
            Stage window = MainGUI.getStage();
            window.setScene(mGui.getScene());
        });
        enrollments.setOnAction(event -> {
            EnrollmentsGUI wGui = new EnrollmentsGUI();
            Stage window = MainGUI.getStage();
            window.setScene(wGui.getScene());
        });
        students.setOnAction(event -> {
            StudentsGUI uGui = new StudentsGUI();
            Stage window = MainGUI.getStage();
            window.setScene(uGui.getScene());
        });
        certificates.setOnAction(event -> {
            CertificatesGUI uGui = new CertificatesGUI();
            Stage window = MainGUI.getStage();
            window.setScene(uGui.getScene());
        });
        info.setOnAction(event -> {
            InfoGUI InfoGUI = new InfoGUI();
            Stage window = MainGUI.getStage();
            window.setScene(InfoGUI.getScene());
        });

        //Making scene...
        return new Scene(layout, 800, 220);
    }

    @Override
    public void start(Stage window) throws Exception {

    }

}
