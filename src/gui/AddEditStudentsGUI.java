package gui;

import database.AddItem;
import database.EditItem;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class AddEditStudentsGUI {
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

        //Creating buttons for the body...
        Label enter = new Label("Enter Student information: ");
        TextArea nameField = new TextArea();
        nameField.setPromptText("Type your name: ");
        TextArea emailField = new TextArea();
        emailField.setPromptText("Type your email: ");
        TextArea dateOfBirthDayField = new TextArea();
        dateOfBirthDayField.setPromptText("Type the day of your birth: ");
        TextArea dateOfBirthMonthField = new TextArea();
        dateOfBirthMonthField.setPromptText("Type the month of your birth:  ");
        TextArea dateOfBirthYearField = new TextArea();
        dateOfBirthYearField.setPromptText("Type the year of your birth: ");
        Label gendersLabel = new Label("Pick gender: ");
        ObservableList<String> genders =
                FXCollections.observableArrayList(
                        "M",
                        "F"
                );
        final ComboBox comboBox = new ComboBox(genders);
        TextArea addressField = new TextArea();
        addressField.setPromptText("Type your address: ");
        TextArea cityField = new TextArea();
        cityField.setPromptText("Type your city: ");
        TextArea countryField = new TextArea();
        countryField.setPromptText("Type your country: ");
        TextArea postalCodeField = new TextArea();
        postalCodeField.setPromptText("Type your postalcode: ");
        Button submit = new Button("Submit");


        //Adding buttons to the body...
        body.add(enter, 1, 1);
        body.add(nameField, 1, 2);
        body.add(emailField, 1, 3);
        body.add(dateOfBirthDayField, 1, 4);
        body.add(dateOfBirthMonthField, 1, 5);
        body.add(dateOfBirthYearField, 1, 6);
        body.add(gendersLabel, 1, 7);
        body.add(comboBox, 1, 8);
        body.add(addressField, 1, 9);
        body.add(cityField, 1, 10);
        body.add(countryField, 1, 11);
        body.add(postalCodeField, 1, 12);
        body.add(submit, 1, 13);
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
            String dateOfBirth = dateOfBirthYearField.getText() + "-" + dateOfBirthMonthField.getText() + "-" +
                    dateOfBirthDayField.getText();
            AddItem.addStudent(emailField.getText(), nameField.getText(), dateOfBirth,
                    (String) comboBox.getValue(), addressField.getText(), cityField.getText(), countryField.getText(),
                    postalCodeField.getText());
            StudentsGUI mGui = new StudentsGUI();
            Stage window = MainGUI.getStage();
            window.setScene(mGui.getScene());
        });

        //Creating the scrollpane...
        ScrollPane sp = new ScrollPane();

        sp.setContent(layout);
        sp.setFitToHeight(true);
        sp.setFitToWidth(true);
        //Creating the scene...
        return new Scene(layout, 800, 500);

    }

    public Scene editStage(String email, String name, String dateOfBirth, String gender, String address, String city,
                           String country, String postalCode) {
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

        //Separating date of birth into day, month and year...
        String[] splitDate = dateOfBirth.split("-");
        String year = splitDate[0];
        String month = splitDate[1];
        String day = splitDate[2];

        //Creating buttons for the body...
        Label enter = new Label("Enter Student information: ");
        TextArea nameField = new TextArea();
        nameField.setPromptText("Type your name: ");
        nameField.setText(name);
        TextArea emailField = new TextArea();
        emailField.setPromptText("Type your email: ");
        emailField.setText(email);
        TextArea dateOfBirthDayField = new TextArea();
        dateOfBirthDayField.setPromptText("Type your date of birth: ");
        dateOfBirthDayField.setText(day);
        TextArea dateOfBirthMonthField = new TextArea();
        dateOfBirthMonthField.setPromptText("Type your date of birth: ");
        dateOfBirthMonthField.setText(month);
        TextArea dateOfBirthYearField = new TextArea();
        dateOfBirthYearField.setPromptText("Type your date of birth: ");
        dateOfBirthYearField.setText(year);
        Label gendersLabel = new Label("Pick gender: ");
        ObservableList<String> genders =
                FXCollections.observableArrayList(
                        "M",
                        "F"
                );
        final ComboBox comboBox = new ComboBox(genders);
        comboBox.setValue(gender);
        TextArea addressField = new TextArea();
        addressField.setPromptText("Type your address: ");
        addressField.setText(address);
        TextArea cityField = new TextArea();
        cityField.setPromptText("Type your city: ");
        cityField.setText(city);
        TextArea countryField = new TextArea();
        countryField.setPromptText("Type your country: ");
        countryField.setText(country);
        TextArea postalCodeField = new TextArea();
        postalCodeField.setPromptText("Type your postalcode: ");
        postalCodeField.setText(postalCode);
        Button submit = new Button("Submit");


        //Adding buttons to the body...
        body.add(enter, 1, 1);
        body.add(nameField, 1, 2);
        body.add(emailField, 1, 3);
        body.add(dateOfBirthDayField, 1, 4);
        body.add(dateOfBirthMonthField, 1, 5);
        body.add(dateOfBirthYearField, 1, 6);
        body.add(gendersLabel, 1, 7);
        body.add(comboBox, 1, 8);
        body.add(addressField, 1, 9);
        body.add(cityField, 1, 10);
        body.add(countryField, 1, 11);
        body.add(postalCodeField, 1, 12);
        body.add(submit, 1, 13);
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
            String newDateOfBirth = dateOfBirthYearField.getText() + "-" + dateOfBirthMonthField.getText() + "-" +
                    dateOfBirthDayField.getText();
            EditItem.editStudent(email, emailField.getText(), nameField.getText(), newDateOfBirth,
                    (String) comboBox.getValue(), addressField.getText(), cityField.getText(), countryField.getText(),
                    postalCodeField.getText());
            StudentsGUI mGui = new StudentsGUI();
            Stage window = MainGUI.getStage();
            window.setScene(mGui.getScene());
        });

        //Creating the scrollpane...
        ScrollPane sp = new ScrollPane();

        sp.setContent(layout);
        sp.setFitToHeight(true);
        sp.setFitToWidth(true);
        //Creating the scene...
        return new Scene(sp, 800, 220);

    }


}
