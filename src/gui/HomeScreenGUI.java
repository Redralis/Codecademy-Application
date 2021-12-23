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
import javafx.stage.Window;

public class HomeScreenGUI extends Application {
    public Scene getScene() {
        // aanmaken layout
        BorderPane layout = new BorderPane();

        // aanmaken menu
        HBox menu = new HBox();

        // middel aanmaken
        HBox body = new HBox();

        // buttons aanmaken menu
        Label nameText = new Label("Codecademy");
        Button info = new Button("Info");
        Button settings = new Button("Settings");
        Button logout = new Button("Logout");

        // buttons aanmaken body
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

        // toevoegen aan menu
        menu.getChildren().addAll(nameText, info, settings, logout);
        menu.setStyle("-fx-background-color: #ffd300;");

        // toevoegen aan body
        body.getChildren().addAll(modules, webcasts, users);
        body.setStyle("-fx-background-color: #fff0e5");

        // menu toevoegen aan layout
        HBox.setMargin(nameText, new Insets(10, 10, 10, 10));
        menu.setAlignment(Pos.BASELINE_CENTER);
        layout.setTop(menu);

        // body toevoegen aan layout
        layout.setCenter(body);

        // positionering van de body buttons
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
            
            ModulesGUI mGui = new ModulesGUI();
            Stage window = HomeScreen.getStage();
            window.setScene(mGui.getScene());
        });
        webcasts.setOnAction(event -> {
            WebcastsGUI wGui = new WebcastsGUI();
            Stage window = HomeScreen.getStage();
            window.setScene(wGui.getScene());
        });
        users.setOnAction(event -> {
            UsersGUI uGui = new UsersGUI();
            Stage window = HomeScreen.getStage();
            window.setScene(uGui.getScene());
        });

        Scene scene = new Scene(layout,550,200);
        return scene;
        
        
    }
    // public void setScene(HomeScreen home) {
    //     home.setScene(getScene());
    // }
    @Override
    public void start(Stage window) throws Exception {
        
    }
}
