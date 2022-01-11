package gui;

import database.*;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import userdata.Certificate;
import userdata.CertificateAndStudent;

import java.util.List;

public class CertificatesBySelectedAccountGUI {

    // Default window
    public Scene getStage() {
        //creates layout
        BorderPane layout = new BorderPane();

        //creates menu
        HBox menu = new HBox();

        //creates body
        GridPane body = new GridPane();

        //  The results will come here
        HBox resultBox = new HBox();

        //creates buttons for menu
        Button back = new Button("Back");
        Label nameText = new Label("Codecademy");
        Button info = new Button("Info");
        Button logout = new Button("Logout");

        //adds buttons to menu
        menu.getChildren().addAll(back, nameText, info, logout);
        menu.setStyle("-fx-background-color: #ffd300;");

        //creates buttons for body
        Label selectedStudent = new Label("Select student:");
        ObservableList students = GetStudents.studentsList();
        final ComboBox studentsBox = new ComboBox(students);
        Button show = new Button("Show");

        //creates resultlabel were the results will be stored in
        Label result = new Label();

        //adds buttons to body
        body.add(selectedStudent, 1, 1);
        body.add(studentsBox, 1, 2);
        body.add(show, 1, 5);
        resultBox.getChildren().add(result);

        // Colors the background of the application
        body.setStyle("-fx-background-color: #fff0e5");
        resultBox.setStyle("-fx-background-color: #7fb7d4");

        //adds menu and body to layout
        HBox.setMargin(nameText, new Insets(10, 10, 10, 10));
        menu.setAlignment(Pos.BASELINE_CENTER);
        layout.setTop(menu);
        layout.setCenter(body);
        layout.setBottom(resultBox);

        //gives positioning to the buttons
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

        // When clicked on 'show' it will show & update the results at the bottom of the window
        show.setOnAction(event -> {

            // Calling the function what makes and executes a query and returns the results in a List.
            List certificatesByStudent = GetCertificatesBySelectedAccount.certificatesBySelectedAccount((String) studentsBox.getValue());

            // Transforming the list to a string
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < certificatesByStudent.size(); i++) {
                sb.append(certificatesByStudent.get(i).toString() + "\n");
            }

            // Assigning the result-string to a Label;
            result.setText(sb.toString());
        });

        //creates scrollpane
        ScrollPane sp = new ScrollPane();

        sp.setContent(layout);
        sp.setFitToHeight(true);
        sp.setFitToWidth(true);

        //creates scene
        return new Scene(sp, 800, 200);
    }
}
