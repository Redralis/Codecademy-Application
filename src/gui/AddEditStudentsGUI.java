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
import test.DateTools;
import test.MailTools;
import test.PostalCode;

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
        Label nameLabel = new Label("Enter student's name: ");
        TextArea nameField = new TextArea();
        nameField.setPromptText("Type the student's name: ");
        Label emailLabel = new Label("Enter student's email: ");
        TextArea emailField = new TextArea();
        emailField.setPromptText("Enter student's email: ");
        Label dayLabel = new Label("Enter the day the student was born: ");
        TextArea dateOfBirthDayField = new TextArea();
        dateOfBirthDayField.setPromptText("Type the day of the student's birth: ");
        Label monthLabel = new Label("Enter the month the student was born: ");
        TextArea dateOfBirthMonthField = new TextArea();
        dateOfBirthMonthField.setPromptText("Type the month of the student's birth:  ");
        TextArea dateOfBirthYearField = new TextArea();
        Label yearLabel = new Label("Enter the year the student was born: ");
        dateOfBirthYearField.setPromptText("Type the year of the student's birth: ");
        Label gendersLabel = new Label("Pick gender: ");
        ObservableList<String> genders =
                FXCollections.observableArrayList(
                        "M",
                        "F"
                );
        final ComboBox comboBox = new ComboBox(genders);
        Label addressLabel = new Label("Enter student's current address: ");
        TextArea addressField = new TextArea();
        addressField.setPromptText("Type the student's current address: ");
        Label cityLabel = new Label("Enter student's current city: ");
        TextArea cityField = new TextArea();
        cityField.setPromptText("Type the student's city: ");
        Label countryLabel = new Label("Enter student's current country: ");
        TextArea countryField = new TextArea();
        countryField.setPromptText("Type the student's current country: ");
        Label postalCodeLabel = new Label("Enter student's current postal code: ");
        TextArea postalCodeField = new TextArea();
        postalCodeField.setPromptText("Type the student's current postalcode: ");
        Button submit = new Button("Submit");


        //Adding buttons to the body...
        body.add(nameLabel, 1, 1);
        body.add(nameField, 1, 2);
        body.add(emailLabel, 1, 3);
        body.add(emailField, 1, 4);
        body.add(dayLabel, 1, 5);
        body.add(dateOfBirthDayField, 1, 6);
        body.add(monthLabel, 1, 7);
        body.add(dateOfBirthMonthField, 1, 8);
        body.add(yearLabel, 1, 9);
        body.add(dateOfBirthYearField, 1, 10);
        body.add(gendersLabel, 1, 11);
        body.add(comboBox, 1, 12);
        body.add(addressLabel, 1, 13);
        body.add(addressField, 1, 14);
        body.add(cityLabel, 1, 15);
        body.add(cityField, 1, 16);
        body.add(countryLabel, 1, 17);
        body.add(countryField, 1, 18);
        body.add(postalCodeLabel, 1, 19);
        body.add(postalCodeField, 1, 20);
        body.add(submit, 1, 21);
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
            StudentsGUI studentsGUI = new StudentsGUI();
            Stage window = MainGUI.getStage();
            window.setScene(studentsGUI.getScene());
        });
        info.setOnAction(event -> {
            InfoGUI InfoGUI = new InfoGUI();
            Stage window = MainGUI.getStage();
            window.setScene(InfoGUI.getScene());
        });
        submit.setOnAction(event -> {
            if (nameField.getText().trim().length() == 0 || emailField.getText().trim().length() == 0 ||
                    dateOfBirthDayField.getText().trim().length() == 0 ||
                    dateOfBirthMonthField.getText().trim().length() == 0 ||
                    dateOfBirthYearField.getText().trim().length() == 0 ||
                    addressField.getText().trim().length() == 0 || comboBox.getSelectionModel().isEmpty() ||
                    cityField.getText().trim().length() == 0 || countryField.getText().trim().length() == 0 ||
                    postalCodeField.getText().trim().length() == 0) {
                Alert alert = new Alert(Alert.AlertType.WARNING, "Please make sure all fields have input.", ButtonType.OK);
                alert.showAndWait();
            } else if (MailTools.validateMailAddress(emailField.getText()).equals("false")) {
                Alert alert = new Alert(Alert.AlertType.WARNING, "Incorrect email input, try again.", ButtonType.OK);
                alert.showAndWait();
            } else if (DateTools.validateDate(Integer.parseInt(dateOfBirthDayField.getText()),Integer.parseInt(dateOfBirthMonthField.getText()),Integer.parseInt(dateOfBirthYearField.getText())).equals("false")) {
                Alert alert = new Alert(Alert.AlertType.WARNING, "Incorrect date input, try again.", ButtonType.OK);
                alert.showAndWait();
            } else {
                String dateOfBirth = dateOfBirthYearField.getText() + "-" + dateOfBirthMonthField.getText() + "-" +
                        dateOfBirthDayField.getText();
                AddItem.addStudent(emailField.getText(), nameField.getText(), dateOfBirth,
                        (String) comboBox.getValue(), addressField.getText(), cityField.getText(), countryField.getText(),
                        postalCodeField.getText());
                StudentsGUI mGui = new StudentsGUI();
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
        return new Scene(sp, 800, 600);

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
        Label nameLabel = new Label("Enter student's name: ");
        TextArea nameField = new TextArea();
        nameField.setPromptText("Type student's name: ");
        nameField.setText(name);
        Label emailLabel = new Label("Enter student's email: ");
        TextArea emailField = new TextArea();
        emailField.setPromptText("Type student's email: ");
        emailField.setText(email);
        Label dayLabel = new Label("Enter the day the student was born: ");
        TextArea dateOfBirthDayField = new TextArea();
        dateOfBirthDayField.setPromptText("Enter the day the student was born: ");
        dateOfBirthDayField.setText(day);
        Label monthLabel = new Label("Enter the month the student was born: ");
        TextArea dateOfBirthMonthField = new TextArea();
        dateOfBirthMonthField.setPromptText("Type the student's date of birth: ");
        dateOfBirthMonthField.setText(month);
        Label yearLabel = new Label("Enter the year the student was born: ");
        TextArea dateOfBirthYearField = new TextArea();
        dateOfBirthYearField.setPromptText("Type the student's date of birth: ");
        dateOfBirthYearField.setText(year);
        Label gendersLabel = new Label("Pick gender: ");
        ObservableList<String> genders =
                FXCollections.observableArrayList(
                        "M",
                        "F"
                );
        final ComboBox comboBox = new ComboBox(genders);
        comboBox.setValue(gender);
        Label addressLabel = new Label("Enter student's current address: ");
        TextArea addressField = new TextArea();
        addressField.setPromptText("Type the student's address: ");
        addressField.setText(address);
        Label cityLabel = new Label("Enter student's current city: ");
        TextArea cityField = new TextArea();
        cityField.setPromptText("Type the student's current city: ");
        cityField.setText(city);
        Label countryLabel = new Label("Enter student's current country: ");
        TextArea countryField = new TextArea();
        countryField.setPromptText("Type the student's country: ");
        countryField.setText(country);
        Label postalCodeLabel = new Label("Enter student's current postal code: ");
        TextArea postalCodeField = new TextArea();
        postalCodeField.setPromptText("Type the student's postalcode: ");
        postalCodeField.setText(postalCode);
        Button submit = new Button("Submit");


        //Adding buttons to the body...
        body.add(nameLabel, 1, 1);
        body.add(nameField, 1, 2);
        body.add(emailLabel, 1, 3);
        body.add(emailField, 1, 4);
        body.add(dayLabel, 1, 5);
        body.add(dateOfBirthDayField, 1, 6);
        body.add(monthLabel, 1, 7);
        body.add(dateOfBirthMonthField, 1, 8);
        body.add(yearLabel, 1, 9);
        body.add(dateOfBirthYearField, 1, 10);
        body.add(gendersLabel, 1, 11);
        body.add(comboBox, 1, 12);
        body.add(addressLabel, 1, 13);
        body.add(addressField, 1, 14);
        body.add(cityLabel, 1, 15);
        body.add(cityField, 1, 16);
        body.add(countryLabel, 1, 17);
        body.add(countryField, 1, 18);
        body.add(postalCodeLabel, 1, 19);
        body.add(postalCodeField, 1, 20);
        body.add(submit, 1, 21);
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
            StudentsGUI studentsGUI = new StudentsGUI();
            Stage window = MainGUI.getStage();
            window.setScene(studentsGUI.getScene());
        });
        info.setOnAction(event -> {
            InfoGUI InfoGUI = new InfoGUI();
            Stage window = MainGUI.getStage();
            window.setScene(InfoGUI.getScene());
        });
        submit.setOnAction(event -> {
            if (nameField.getText().trim().length() == 0 || emailField.getText().trim().length() == 0 ||
                    dateOfBirthDayField.getText().trim().length() == 0 ||
                    dateOfBirthMonthField.getText().trim().length() == 0 ||
                    dateOfBirthYearField.getText().trim().length() == 0 ||
                    addressField.getText().trim().length() == 0 || comboBox.getSelectionModel().isEmpty() ||
                    cityField.getText().trim().length() == 0 || countryField.getText().trim().length() == 0 ||
                    postalCodeField.getText().trim().length() == 0) {
                Alert alert = new Alert(Alert.AlertType.WARNING, "Please make sure all fields have input.", ButtonType.OK);
                alert.showAndWait();
            } else if (MailTools.validateMailAddress(emailField.getText()).equals("false")) {
                Alert alert = new Alert(Alert.AlertType.WARNING, "Incorrect email input, try again.", ButtonType.OK);
                alert.showAndWait();
            } else if (DateTools.validateDate(Integer.parseInt(dateOfBirthDayField.getText()),Integer.parseInt(dateOfBirthMonthField.getText()),Integer.parseInt(dateOfBirthYearField.getText())).equals("false")) {
                    Alert alert = new Alert(Alert.AlertType.WARNING, "Incorrect date input, try again.", ButtonType.OK);
                    alert.showAndWait();
            } else {
                String newDateOfBirth = dateOfBirthYearField.getText() + "-" + dateOfBirthMonthField.getText() + "-" +
                        dateOfBirthDayField.getText();
                EditItem.editStudent(email, emailField.getText(), nameField.getText(), newDateOfBirth,
                        (String) comboBox.getValue(), addressField.getText(), cityField.getText(), countryField.getText(),
                        postalCodeField.getText());
                StudentsGUI mGui = new StudentsGUI();
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
        return new Scene(sp, 800, 600);

    }


}
