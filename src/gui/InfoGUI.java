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

public class InfoGUI {
    public Scene getScene() {
        //adds the layout
        BorderPane layout = new BorderPane();

        //adds the boxes
        HBox menu = new HBox();
        VBox body = new VBox();
        HBox bodyB = new HBox();
        HBox bodyO = new HBox();

        //creates the buttons for the menu
        Button back = new Button("Back");
        Label nameText = new Label("Codecademy");
        Button logout = new Button("Logout");

        //adds the buttons to the menu
        menu.getChildren().addAll(back, nameText, logout);

        //edit menu
        HBox.setMargin(nameText, new Insets(10, 10, 10, 10));
        menu.setAlignment(Pos.BASELINE_CENTER);
        menu.setStyle("-fx-background-color: #ffd300;");

        //edit body
        body.setStyle("-fx-background-color: #fff0e5");

        //creates the buttons for the body
        Label infoBody = new Label("- This application is made by Hans Gerard Karremans, Joost van Dam, Rick Wijkmans en Lucas de Kleijn");
        Label infoMore = new Label("- If there are any problems regarding this application please mail them to: \n  hg.karremans@student.avans.nl");
        //adds the buttons to the body
        bodyB.getChildren().add(infoBody);
        bodyO.getChildren().add(infoMore);
        body.getChildren().addAll(bodyB, bodyO);
        //adds the menu and body to the layout
        layout.setTop(menu);
        layout.setCenter(body);

        //gives the buttons function
        logout.setOnAction((event) -> {
            System.exit(1);
        });
        back.setOnAction(event -> {
            HomeScreenGUI hGui = new HomeScreenGUI();
            Stage window = HomeScreen.getStage();
            window.setScene(hGui.getScene());

        });

        //makes a scene
        Scene scene = new Scene(layout, 550, 200);

        return scene;



    }
}
