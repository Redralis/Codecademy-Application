package gui;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class WebcastsGUI {
    public Scene getScene() {
        BorderPane layout = new BorderPane();

        // makes menu
        HBox menu = new HBox();

        // makes body
        VBox body = new VBox();
        body.setStyle("-fx-background-color: #fff0e5");
        VBox right = new VBox();
        right.setStyle("-fx-background-color: #fff0e5");
        // makes buttons for menu
        Button back = new Button("Back");
        Label nameText = new Label("Codecademy");
        Button info = new Button("Info");
        Button logout = new Button("Logout");

        // makes buttons for body
        Button add = new Button("Add");
        Button edit = new Button("Edit");
        Button delete = new Button("Delete");
        Button top3 = new Button("Top 3");

        // adds buttons to menu
        menu.getChildren().addAll(back, nameText, info, logout);
        menu.setStyle("-fx-background-color: #ffd300;");

        // adds buttons to body
        right.getChildren().addAll(add, edit, delete, top3);

        // adds body to layout
        layout.setCenter(body);
        layout.setRight(right);
        // giving the buttons function
        logout.setOnAction((event) -> {
            System.exit(1);
        });
        back.setOnAction(event -> {
            HomeScreenGUI hGui = new HomeScreenGUI();
            Stage window = HomeScreen.getStage();
            window.setScene(hGui.getScene());
            
        });

        // adds menu to the layout
        HBox.setMargin(nameText, new Insets(10, 10, 10, 10));
        menu.setAlignment(Pos.BASELINE_CENTER);
        layout.setTop(menu);

        // makes the scene
        Scene scene = new Scene(layout, 550, 200);
        return scene;
    }
}
