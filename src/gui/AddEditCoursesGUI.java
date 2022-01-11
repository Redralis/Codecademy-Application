package gui;

import database.AddItem;
import database.EditItem;
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

public class AddEditCoursesGUI {
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
        Label enter = new Label("Enter course information: ");
        TextArea nameField = new TextArea();
        nameField.setPromptText("Type the name of the course: ");
        TextArea subjectField = new TextArea();
        subjectField.setPromptText("Type the name of the subject for the course: ");
        TextArea introductionField = new TextArea();
        introductionField.setPromptText("Type a introduction: ");
        Label levelsLabel = new Label("Pick level of difficulty: ");
        ObservableList<String> levels =
                FXCollections.observableArrayList(
                        "Beginner",
                        "Advanced",
                        "Expert"
                );
        final ComboBox comboBox = new ComboBox(levels);
        Button submit = new Button("Submit");

        //adds buttons to body
        body.add(enter, 1, 1);
        body.add(nameField, 1, 2);
        body.add(subjectField, 1, 3);
        body.add(introductionField, 1, 4);
        body.add(levelsLabel, 1, 5);
        body.add(comboBox, 1, 6);
        body.add(submit, 1, 7);

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
            AddItem.addCourse(nameField.getText(), subjectField.getText(), introductionField.getText(),
                    (String) comboBox.getValue());
            CoursesGUI mGui = new CoursesGUI();
            Stage window = MainGUI.getStage();
            window.setScene(mGui.getScene());
        });

        //creates scrollpane
        ScrollPane sp = new ScrollPane();

        sp.setContent(layout);
        sp.setFitToHeight(true);
        sp.setFitToWidth(true);
        //creates scene
        return new Scene(sp, 700, 220);
    }

    public Scene editStage(String name, String subject, String introductionText, String level) {
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
        Label enter = new Label("Enter course information: ");
        TextArea nameField = new TextArea();
        nameField.setPromptText("Type the name of the course: ");
        nameField.setText(name);
        TextArea subjectField = new TextArea();
        subjectField.setPromptText("Type the name of the subject for the course: ");
        subjectField.setText(subject);
        TextArea introductionField = new TextArea();
        introductionField.setPromptText("Type a introduction: ");
        introductionField.setText(introductionText);
        Label levelsLabel = new Label("Pick level of difficulty: ");
        ObservableList<String> levels =
                FXCollections.observableArrayList(
                        "Beginner",
                        "Advanced",
                        "Expert"
                );
        final ComboBox comboBox = new ComboBox(levels);
        comboBox.setValue(level);
        Button submit = new Button("Submit");

        //adds buttons to body
        body.add(enter, 1, 1);
        body.add(nameField, 1, 2);
        body.add(subjectField, 1, 3);
        body.add(introductionField, 1, 4);
        body.add(levelsLabel, 1, 5);
        body.add(comboBox, 1, 6);
        body.add(submit, 1, 7);

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
            EditItem.editCourse(name, nameField.getText(), subjectField.getText(), introductionField.getText(),
                    (String) comboBox.getValue());
            CoursesGUI mGui = new CoursesGUI();
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
