package gui;

import database.AddItem;
import database.EditItem;
import database.GetCertificates;
import database.GetEnrollments;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class AddEditCertificatesGUI {
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

        //creates buttons for body
        Label enter = new Label("Enter certificate information: ");
        TextArea ratingField = new TextArea();
        ratingField.setPromptText("Type the rating of the certificate: ");
        TextArea nameEmployeeField = new TextArea();
        nameEmployeeField.setPromptText("Type the employee's name of the certificate: ");
        Label enrollmentToPair = new Label("Select student to give the certificate:");
        ObservableList<String> enrollments = GetEnrollments.enrollmentsList();
        final ComboBox<String> enrollmentsBox = new ComboBox<String>(enrollments);
        Button submit = new Button("Submit");

        //adds buttons to body
        body.add(enter, 1, 1);
        body.add(ratingField, 1, 2);
        body.add(nameEmployeeField, 1, 3);
        body.add(enrollmentToPair, 1, 4);
        body.add(enrollmentsBox, 1, 5);
        body.add(submit, 1, 6);

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
            AddItem.addCertificate(Double.parseDouble(ratingField.getText()), nameEmployeeField.getText());
            String[] split = enrollmentsBox.getValue().split(", ");
            EditItem.coupleCertificate(GetCertificates.latestId(), split[0], split[1]);
            CertificatesGUI mGui = new CertificatesGUI();
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

    public Scene editStage(String id, String rating, String nameEmployee) {
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

        //creates buttons for body
        Label enter = new Label("Enter certificate information: ");
        TextArea ratingField = new TextArea();
        ratingField.setPromptText("Type the rating of the certificate: ");
        ratingField.setText(rating);
        TextArea nameEmployeeField = new TextArea();
        nameEmployeeField.setPromptText("Type the employee's name of the certificate: ");
        nameEmployeeField.setText(nameEmployee);
        Button submit = new Button("Submit");

        //adds buttons to body
        body.add(enter, 1, 1);
        body.add(ratingField, 1, 2);
        body.add(nameEmployeeField, 1, 3);
        body.add(submit, 1, 4);

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
            EditItem.editCertificate(id, ratingField.getText(), nameEmployeeField.getText());
            CertificatesGUI mGui = new CertificatesGUI();
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
