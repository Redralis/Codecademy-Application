package gui;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class AddCoursesGUI {
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
        TextArea levelField = new TextArea();
        levelField.setPromptText("What is the level of difficulty? ");
        Button submit = new Button("Submit");



        //adds buttons to body
        body.add(enter, 1, 1);
        body.add(nameField, 1, 2);
        body.add(subjectField, 1, 3);
        body.add(introductionField, 1, 4);
        body.add(levelField, 1, 5);
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

        //creates scrollpane
        ScrollPane sp = new ScrollPane();

        sp.setContent(layout);
        sp.setFitToHeight(true);
        sp.setFitToWidth(true);
        //creates scene
        return new Scene(sp, 700, 200);
    }
}
