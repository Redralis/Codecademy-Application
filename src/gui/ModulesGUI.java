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
import javafx.stage.Window;

public class ModulesGUI {
    
    public Scene getScene() {
        // aanmaken layout
        BorderPane layout = new BorderPane();

        // aanmaken menu
        HBox menu = new HBox();
        VBox right = new VBox();

        // middel aanmaken
        VBox body = new VBox();
        body.setStyle("-fx-background-color: #fff0e5");
        right.setStyle("-fx-background-color: #fff0e5");

        //moet toegevoegd worden aan geselecteerde cursussen
        HBox aanbevolen = new HBox();

        // buttons aanmaken menu
        Button back = new Button("Back");
        Label nameText = new Label("Codeacademy");
        Button info = new Button("Info");
        Button settings = new Button("Settings");
        Button logout = new Button("Logout");

        //buttons aanmaken voor body
        Button add = new Button("Add");
        Button delete = new Button("Delete");
        Button overzicht = new Button("Overzicht");
        Button top3 = new Button("Top 3");
        Label percBehaald = new Label("...% / 100%"); 

        


        //buttons toevoegen aan body
        right.getChildren().addAll(add, delete, overzicht, top3, percBehaald);

        //buttons toevoegen aan menu
        menu.getChildren().addAll(back, nameText, info, settings, logout);
        menu.setStyle("-fx-background-color: #ffd300;");

        //menu toevoegen aan layout
        HBox.setMargin(nameText, new Insets(10,10,10,10));
        menu.setAlignment(Pos.BASELINE_CENTER);
        layout.setTop(menu);

        //body toevoegen aan layout
        layout.setCenter(body);
        layout.setRight(right);
        //buttons functie geven
        logout.setOnAction((event) -> {
            System.exit(1);
        });
        back.setOnAction(event -> {
            HomeScreenGUI hGui = new HomeScreenGUI();
            Stage window = HomeScreen.getStage();
            window.setScene(hGui.getScene());
            
        });
       

        //scene aanmaken
        Scene modulesG = new Scene(layout, 550, 200); 
        
        return modulesG;
         
    }
    
}
