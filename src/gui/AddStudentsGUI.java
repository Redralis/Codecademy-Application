package gui;

import database.AddEditItem;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class AddStudentsGUI {
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
        Label enter = new Label("Enter Student information: ");
        TextArea nameField = new TextArea();
        nameField.setPromptText("Type your name: ");
        TextArea emailField = new TextArea();
        emailField.setPromptText("Type your email: ");
        TextArea dateOfBirth = new TextArea();
        dateOfBirth.setPromptText("Type your date of birth: ");
        Label gendersLabel = new Label("Pick gender: ");
        ObservableList<String> genders =
                FXCollections.observableArrayList(
                        "M",
                        "F"
                );
        final ComboBox comboBox = new ComboBox(genders);
        TextArea address = new TextArea();
        address.setPromptText("Type your address: ");
        TextArea city = new TextArea();
        city.setPromptText("Type your city: ");
        TextArea country = new TextArea();
        country.setPromptText("Type your country: ");
        TextArea postalCode = new TextArea();
        postalCode.setPromptText("Type your postalcode: ");
        Button submit = new Button("Submit");


        //adds buttons to body
        body.add(enter, 1, 1);
        body.add(nameField, 1, 2);
        body.add(emailField, 1, 3);
        body.add(dateOfBirth, 1, 4);
        body.add(gendersLabel, 1, 5);
        body.add(comboBox, 1, 6);
        body.add(address, 1, 7);
        body.add(city, 1, 8);
        body.add(country, 1, 9);
        body.add(postalCode, 1, 10);
        body.add(submit, 1, 11);
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
            AddEditItem.addStudent(emailField.getText(), nameField.getText(), dateOfBirth.getText(),
                    (String) comboBox.getValue(), address.getText(), city.getText(), country.getText(), postalCode.getText());
            StudentsGUI mGui = new StudentsGUI();
            Stage window = MainGUI.getStage();
            window.setScene(mGui.getScene());
        });

        //creates scrollpane
        ScrollPane sp = new ScrollPane();

        sp.setContent(layout);
        sp.setFitToHeight(true);
        sp.setFitToWidth(true);
        //creates scene
        return new Scene(sp, 700, 200);

    }


}
