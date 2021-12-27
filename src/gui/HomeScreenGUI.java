package gui;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.stage.Stage;

public class HomeScreenGUI extends Application {
    public Scene getScene() {
        // makes layout
        BorderPane layout = new BorderPane();

        // makes menu
        HBox menu = new HBox();

        // makes body
        HBox body = new HBox();

        // makes buttons for menu
        Label nameText = new Label("Codecademy");
        Button info = new Button("Info");
        Button logout = new Button("Logout");

        // makes buttons for body
        Button modules = new Button("Cursussen");
        Button webcasts = new Button("Webcasts");
        Button users = new Button("Cursisten");

        HBox.setHgrow(modules, Priority.ALWAYS);
        HBox.setHgrow(webcasts, Priority.ALWAYS);
        HBox.setHgrow(users, Priority.ALWAYS);

        modules.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
        webcasts.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
        users.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);

        modules.setStyle("-fx-font-size:30");
        webcasts.setStyle("-fx-font-size:30");
        users.setStyle("-fx-font-size:30");

        // adds to menu
        menu.getChildren().addAll(nameText, info, logout);
        menu.setStyle("-fx-background-color: #ffd300;");

        // adds to body
        body.getChildren().addAll(modules, webcasts, users);
        body.setStyle("-fx-background-color: #fff0e5");

        // add menu to layout
        HBox.setMargin(nameText, new Insets(10, 10, 10, 10));
        menu.setAlignment(Pos.BASELINE_CENTER);
        layout.setTop(menu);

        // adds body to layout
        layout.setCenter(body);

        // positioning of the buttons
        body.setAlignment(Pos.BASELINE_CENTER);
        modules.setTranslateX(5);
        modules.setTranslateY(45);
        webcasts.setTranslateX(5);
        webcasts.setTranslateY(45);
        users.setTranslateX(5);
        users.setTranslateY(45);
        
        //giving the buttons function
        logout.setOnAction(event -> {
            System.exit(1);
        });
        modules.setOnAction(event -> {
            
            CoursesGUI mGui = new CoursesGUI();
            Stage window = HomeScreen.getStage();
            window.setScene(mGui.getScene());
        });
        webcasts.setOnAction(event -> {
            EnrollmentsGUI wGui = new EnrollmentsGUI();
            Stage window = HomeScreen.getStage();
            window.setScene(wGui.getScene());
        });
        users.setOnAction(event -> {
            StudentsGUI uGui = new StudentsGUI();
            Stage window = HomeScreen.getStage();
            window.setScene(uGui.getScene());
        });
        info.setOnAction(event -> {
            InfoGUI InfoGUI = new InfoGUI();
            Stage window = HomeScreen.getStage();
            window.setScene(InfoGUI.getScene());
        });
        //makes scene
        Scene scene = new Scene(layout,550,200);
        return scene;
        
        
    }

    @Override
    public void start(Stage window) throws Exception {
        
    }
}
