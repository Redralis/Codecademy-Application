package gui;

import database.*;
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

import java.util.List;

public class CertificatesBySelectedAccountGUI {

    //Default window
    public Scene getStage() {
        //Creating the layout...
        BorderPane layout = new BorderPane();

        //Creating the menu...
        HBox menu = new HBox();

        //Creating the body...
        GridPane body = new GridPane();

        // The results will come here
        HBox resultBox = new HBox();

        //Creating buttons for the menu...
        Button back = new Button("Back");
        Label nameText = new Label("Codecademy");
        Button info = new Button("Info");
        Button logout = new Button("Logout");

        //Adding buttons to the menu...
        menu.getChildren().addAll(back, nameText, info, logout);
        menu.setStyle("-fx-background-color: #ffd300;");

        //Converting lists to observablelists for usage within comboboxes
        ObservableList<String> studentsList = FXCollections.observableList(GetStudents.listOfStudentEmails());

        //Creating buttons for the body...
        Label selectedStudent = new Label("Select student:");
        final ComboBox studentsBox = new ComboBox(studentsList);
        Button show = new Button("Show");

        //creates resultlabel were the results will be stored in
        Label result = new Label();

        //Adding buttons to the body...
        body.add(selectedStudent, 1, 1);
        body.add(studentsBox, 1, 2);
        body.add(show, 1, 5);
        resultBox.getChildren().add(result);

        //Colors the background of the application
        body.setStyle("-fx-background-color: #fff0e5");
        resultBox.setStyle("-fx-background-color: #7fb7d4");

        //Adding menu and body to the layout...
        HBox.setMargin(nameText, new Insets(10, 10, 10, 10));
        menu.setAlignment(Pos.BASELINE_CENTER);
        layout.setTop(menu);
        layout.setCenter(body);
        layout.setBottom(resultBox);

        //Positioning the buttons...
        body.setAlignment(Pos.BASELINE_CENTER);
        resultBox.setAlignment(Pos.BASELINE_CENTER);

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

        //When clicked on 'show' it will show & update the results at the bottom of the window
        show.setOnAction(event -> {

            //Calling the function what makes and executes a query and returns the results in a List.
            List certificatesByStudent = GetCertificatesBySelectedAccount.certificatesBySelectedAccount((String) studentsBox.getValue());

            //Transforming the list to a string
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < certificatesByStudent.size(); i++) {
                sb.append(certificatesByStudent.get(i).toString() + "\n");
            }

            //Assigning the result-string to a Label;
            result.setText(sb.toString());
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
