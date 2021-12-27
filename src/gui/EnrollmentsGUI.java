package gui;

import database.GetEnrollments;
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
import userdata.Enrollment;

public class EnrollmentsGUI {

    public Scene getScene() {
        //Creating the layout...
        BorderPane layout = new BorderPane();

        //Creating the menu...
        HBox menu = new HBox();
        VBox right = new VBox();

        //Making the table for viewing the enrollments...
        TableView<Enrollment> table = GetEnrollments.enrollments();

        //Setting colors...
        table.setStyle("-fx-background-color: #fff0e5");
        right.setStyle("-fx-background-color: #fff0e5");

        //Making columns...
        TableColumn<Enrollment, String> dateOfEnrollmentColumn = new TableColumn<Enrollment, String>("Enrollment");
        dateOfEnrollmentColumn.setCellValueFactory(new PropertyValueFactory<>("dateOfEnrollment"));

        //Adding the columns to the table...
        table.getColumns().addAll(dateOfEnrollmentColumn);

        //Creating buttons for the menu...
        Button back = new Button("Back");
        Label nameText = new Label("Codecademy");
        Button info = new Button("Info");
        Button logout = new Button("Logout");

        //Creating buttons for the body...
        Button add = new Button("Add");
        Button edit = new Button("Edit");
        Button delete = new Button("Delete");
        Button top3 = new Button("Top 3");

        //Adding buttons to the menu...
        menu.getChildren().addAll(back, nameText, info, logout);
        menu.setStyle("-fx-background-color: #ffd300;");

        //Adding buttons to the body...
        right.getChildren().addAll(add, edit, delete, top3);

        //Adding menu to the layout...
        HBox.setMargin(nameText, new Insets(10, 10, 10, 10));
        menu.setAlignment(Pos.BASELINE_CENTER);
        layout.setTop(menu);

        //Adding body to the layout...
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