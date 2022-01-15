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
import javafx.scene.control.Alert;

public class AddEditCertificatesGUI {
    public Scene getStage() {
        //Creating the layout...
        BorderPane layout = new BorderPane();

        //Creating the menu...
        HBox menu = new HBox();

        //Creating the body...
        GridPane body = new GridPane();

        //Creating the menu...
        Button back = new Button("Back");
        Label nameText = new Label("Codecademy");
        Button info = new Button("Info");
        Button logout = new Button("Logout");

        //Adding buttons to the menu...
        menu.getChildren().addAll(back, nameText, info, logout);
        menu.setStyle("-fx-background-color: #ffd300;");

        //Creating buttons for the menu...
        Label ratingLabel = new Label("Enter certificate rating: ");
        TextArea ratingField = new TextArea();
        ratingField.setPromptText("Type the rating of the certificate: ");
        ratingField.setMaxHeight(40);
        Label nameEmployeeLabel = new Label("Enter the name of the employee who issued the certificate: ");
        TextArea nameEmployeeField = new TextArea();
        nameEmployeeField.setPromptText("Type the name of the employee who issued the certificate: ");
        nameEmployeeField.setMaxHeight(40);
        Label enrollmentToPair = new Label("Select student to give the certificate:");
        ObservableList<String> enrollmentsList = FXCollections.observableList(GetEnrollments.enrollmentsStudentAndCourseList());
        final ComboBox<String> enrollmentsBox = new ComboBox<String>(enrollmentsList);
        Button submit = new Button("Submit");

        //Adding buttons to the body...
        body.add(ratingLabel, 1, 1);
        body.add(ratingField, 1, 2);
        body.add(nameEmployeeLabel, 1, 3);
        body.add(nameEmployeeField, 1, 4);
        body.add(enrollmentToPair, 1, 5);
        body.add(enrollmentsBox, 1, 6);
        body.add(submit, 1, 7);

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
            CertificatesGUI cGui = new CertificatesGUI();
            Stage window = MainGUI.getStage();
            window.setScene(cGui.getScene());
        });
        info.setOnAction(event -> {
            InfoGUI InfoGUI = new InfoGUI();
            Stage window = MainGUI.getStage();
            window.setScene(InfoGUI.getScene());
        });
        submit.setOnAction(event -> {
            if (nameEmployeeField.getText().trim().length() == 0 || ratingField.getText().trim().length() == 0 ||
                    enrollmentsBox.getSelectionModel().isEmpty()) {
                Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "Please make sure all fields have input.", ButtonType.OK);
                alert.showAndWait();
            } else {
                AddItem.addCertificate(Double.parseDouble(ratingField.getText()), nameEmployeeField.getText());
                String[] split = enrollmentsBox.getValue().split(", ");
                EditItem.coupleCertificate(GetCertificates.latestId(), split[0], split[1]);
                CertificatesGUI mGui = new CertificatesGUI();
                Stage window = MainGUI.getStage();
                window.setScene(mGui.getScene());
            }
        });

        //Creating scrollpane...
        ScrollPane sp = new ScrollPane();

        sp.setContent(layout);
        sp.setFitToHeight(true);
        sp.setFitToWidth(true);

        //Creating the scene...
        return new Scene(sp, 800, 600);
    }

    public Scene editStage(String id, String rating, String nameEmployee) {
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

        //Creating buttons for the menu...
        Label ratingLabel = new Label("Enter certificate rating: ");
        TextArea ratingField = new TextArea();
        ratingField.setPromptText("Type the rating of the certificate: ");
        ratingField.setText(rating);
        ratingField.setMaxHeight(40);
        Label nameEmployeeLabel = new Label("Enter the name of the employee who issued the certificate: ");
        TextArea nameEmployeeField = new TextArea();
        nameEmployeeField.setPromptText("Type the employee's name of the certificate: ");
        nameEmployeeField.setText(nameEmployee);
        nameEmployeeField.setMaxHeight(40);
        Button submit = new Button("Submit");

        //Adding buttons to the body...
        body.add(ratingLabel, 1, 1);
        body.add(ratingField, 1, 2);
        body.add(nameEmployeeLabel, 1, 3);
        body.add(nameEmployeeField, 1, 4);
        body.add(submit, 1, 5);

        body.setStyle("-fx-background-color: #fff0e5");

        //Adding menu and body the layout...
        HBox.setMargin(nameText, new Insets(10, 10, 10, 10));
        menu.setAlignment(Pos.BASELINE_CENTER);
        layout.setTop(menu);
        layout.setCenter(body);

        //Gives positioning to the body...
        body.setAlignment(Pos.BASELINE_CENTER);

        //Giving the buttons function...
        logout.setOnAction((event) -> {
            System.exit(1);
        });
        back.setOnAction(event -> {
            CertificatesGUI cGui = new CertificatesGUI();
            Stage window = MainGUI.getStage();
            window.setScene(cGui.getScene());
        });
        info.setOnAction(event -> {
            InfoGUI InfoGUI = new InfoGUI();
            Stage window = MainGUI.getStage();
            window.setScene(InfoGUI.getScene());
        });
        submit.setOnAction(event -> {
            if (nameEmployeeField.getText().trim().length() == 0 || ratingField.getText().trim().length() == 0) {
                Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "Please make sure all fields have input.", ButtonType.OK);
                alert.showAndWait();
            } else {
                EditItem.editCertificate(id, ratingField.getText(), nameEmployeeField.getText());
                CertificatesGUI mGui = new CertificatesGUI();
                Stage window = MainGUI.getStage();
                window.setScene(mGui.getScene());
            }
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
