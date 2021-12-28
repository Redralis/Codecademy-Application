package gui;

import database.GetCourses;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import userdata.Course;

public class CoursesGUI {
    
    public Scene getScene() {

        //Creating the layout...
        BorderPane layout = new BorderPane();

        //Creating the menu...
        HBox menu = new HBox();
        VBox right = new VBox();

        //Making the table for viewing the courses...
        TableView<Course> table = GetCourses.courses();

        //Setting colors...
        table.setStyle("-fx-background-color: #fff0e5");
        right.setStyle("-fx-background-color: #fff0e5");

        //Making columns...
        TableColumn<Course, String> nameColumn = new TableColumn<Course, String>("Name");
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));

        TableColumn<Course, String> subjectColumn = new TableColumn<Course, String>("Subject");
        subjectColumn.setCellValueFactory(new PropertyValueFactory<>("subject"));

        TableColumn<Course, String> introductionTextColumn = new TableColumn<Course, String>("introductionText");
        introductionTextColumn.setCellValueFactory(new PropertyValueFactory<>("introductionText"));

        TableColumn<Course, String> levelColumn = new TableColumn<Course, String>("Level");
        levelColumn.setCellValueFactory(new PropertyValueFactory<>("level"));

        //Adding the columns to the table...
        table.getColumns().addAll(nameColumn, subjectColumn, introductionTextColumn, levelColumn);

        //Has to be added to selected courses...
        HBox aanbevolen = new HBox();

        //Creating the buttons for the menu...
        Button back = new Button("Back");
        Label nameText = new Label("Codecademy");
        Button info = new Button("Info");
        Button settings = new Button("Settings");
        Button logout = new Button("Logout");

        //Creating the buttons for the body...
        Button add = new Button("Add");
        Button edit = new Button("Edit");
        Button delete = new Button("Delete");
        Button overzicht = new Button("Overzicht");
        Button top3 = new Button("Top 3");
        Label percBehaald = new Label("...% / 100%");

        //Adding the buttons to the body...
        right.getChildren().addAll(add, edit,  delete, overzicht, top3, percBehaald);

        //Adding the buttons to menu...
        menu.getChildren().addAll(back, nameText, info, settings, logout);
        menu.setStyle("-fx-background-color: #ffd300;");

        //Adding the menu to the layout...
        HBox.setMargin(nameText, new Insets(10,10,10,10));
        menu.setAlignment(Pos.BASELINE_CENTER);
        layout.setTop(menu);

        //Adding the body to the layout...
        layout.setCenter(table);
        layout.setRight(right);

        //Giving the buttons function...
        logout.setOnAction((event) -> {
            System.exit(1);
        });
        back.setOnAction(event -> {
            HomeScreenGUI hGui = new HomeScreenGUI();
            Stage window = HomeScreen.getStage();
            window.setScene(hGui.getScene());
        });

        //Making the scene...
        return new Scene(layout, 550, 200);

    }
    
}
