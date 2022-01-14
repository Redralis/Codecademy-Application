package gui;

import database.AddItem;
import database.GetCertificatesBySelectedAccount;
import database.GetPercentageByGender;
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

public class CertificateCompletionPercByGenderGUI {
    public Scene getStage() {
        //creates layout
        BorderPane layout = new BorderPane();

        //creates menu
        HBox menu = new HBox();

        //creates body
        GridPane body = new GridPane();

        // Creates resultfield in the GUI
        HBox resultBox = new HBox();
        Label result = new Label();
        resultBox.getChildren().add(result);
        resultBox.setStyle("-fx-background-color: #7fb7d4");
        resultBox.setAlignment(Pos.BASELINE_CENTER);
        layout.setBottom(resultBox);

        //creates buttons for menu
        Button back = new Button("Back");
        Label nameText = new Label("Codecademy");
        Button info = new Button("Info");
        Button logout = new Button("Logout");

        //adds buttons to menu
        menu.getChildren().addAll(back, nameText, info, logout);
        menu.setStyle("-fx-background-color: #ffd300;");

        //creates buttons for body
        Label gendersLabel = new Label("Pick gender: ");
        ObservableList<String> genders = FXCollections.observableArrayList("Male", "Female");
        final ComboBox genderBox = new ComboBox(genders);
        Button show = new Button("Show");
        Label percCompleted= new Label();


        //adds buttons to body
        body.add(gendersLabel, 1, 1);
        body.add(genderBox, 1, 2);
        body.add(show, 1, 3);
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
        show.setOnAction(event -> {

            // Calling the function that makes and executes a query and returns the results in a String.
            String percentage = GetPercentageByGender.percentageByGender((String) genderBox.getValue());

            // Shows the result on the screen, when clicked on show
            result.setText("The percentage completed courses for this gender is: " + percentage);

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
