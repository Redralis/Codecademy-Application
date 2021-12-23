package gui;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class UsersGUI {
    public Scene getScene() {
        BorderPane layout = new BorderPane();

        // aanmaken menu
        HBox menu = new HBox();

        // middel aanmaken
        VBox body = new VBox();
        body.setStyle("-fx-background-color: #fff0e5");
        VBox right = new VBox();
        right.setStyle("-fx-background-color: #fff0e5");
        // buttons aanmaken menu
        Button back = new Button("Back");
        Label nameText = new Label("Codeacademy");
        Button info = new Button("Info");
        Button settings = new Button("Settings");
        Button logout = new Button("Logout");

        // buttons aanmaken voor body
        Button add = new Button("Add");
        Button delete = new Button("Delete");

        // buttons toevoegen aan menu
        menu.getChildren().addAll(back, nameText, info, settings, logout);
        menu.setStyle("-fx-background-color: #ffd300;");

        // buttons toevoegen aan body
        right.getChildren().addAll(add, delete);

        // body toevoegen aan layout
        layout.setCenter(body);
        layout.setRight(right);
        // buttons functie geven
        logout.setOnAction((event) -> {
            System.exit(1);
        });
        back.setOnAction(event -> {
            HomeScreenGUI hGui = new HomeScreenGUI();
            Stage window = HomeScreen.getStage();
            window.setScene(hGui.getScene());
            
        });

        // menu toevoegen aan layout
        HBox.setMargin(nameText, new Insets(10, 10, 10, 10));
        menu.setAlignment(Pos.BASELINE_CENTER);
        layout.setTop(menu);

        // scene aanmaken
        Scene scene = new Scene(layout, 500, 200);
        return scene;
    }
}
