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

public class MainGUI extends Application {
    public static Stage mainStage;

    @Override
    public void start(Stage window) {

        //Creating the layout...
        BorderPane layout = new BorderPane();

        //Creating the menu...
        HBox menu = new HBox();

        //Creating body...
        HBox body = new HBox();

        //Creating menu buttons...
        Label nameText = new Label("Codecademy");
        Button info = new Button("Info");
        Button logout = new Button("Logout");

        //Creating body buttons...
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

        //Adding to menu...
        menu.getChildren().addAll(nameText, info, logout);
        menu.setStyle("-fx-background-color: #ffd300;");

        //Adding to body...
        body.getChildren().addAll(courses, enrollments, students, certificates);
        body.setStyle("-fx-background-color: #fff0e5");

        //Adding menu to layout...
        HBox.setMargin(nameText, new Insets(10, 10, 10, 10));
        menu.setAlignment(Pos.BASELINE_CENTER);
        layout.setTop(menu);

        //Adding body to layout...
        layout.setCenter(body);

        //Positioning the body...
        body.setAlignment(Pos.BASELINE_CENTER);
        courses.setTranslateX(5);
        courses.setTranslateY(45);
        enrollments.setTranslateX(5);
        enrollments.setTranslateY(45);
        students.setTranslateX(5);
        students.setTranslateY(45);
        certificates.setTranslateX(5);
        certificates.setTranslateY(45);

        Scene scene = new Scene(layout, 800, 200);
        window.setScene(scene);
        window.show();

        //Giving buttons function...
        logout.setOnAction((event) -> {
            System.exit(1);
        });
        courses.setOnAction(event -> {
            CoursesGUI mGui = new CoursesGUI();
            window.setScene(mGui.getScene());
            // window.setScene(mGui.getScene());
        });
        enrollments.setOnAction(event -> {
            EnrollmentsGUI wGUI = new EnrollmentsGUI();
            window.setScene(wGUI.getScene());

        });
        students.setOnAction(event -> {
            StudentsGUI uGui = new StudentsGUI();
            window.setScene(uGui.getScene());
        });
        certificates.setOnAction(event -> {
            CertificatesGUI uGui = new CertificatesGUI();
            window.setScene(uGui.getScene());
        });
        info.setOnAction(event -> {
            InfoGUI infoGUI = new InfoGUI();
            window.setScene(infoGUI.getScene());
        });
        mainStage = window;

    }

    public static Stage getStage() {
        return mainStage;
    }

    public static void main(String[] args) {

    }

}
