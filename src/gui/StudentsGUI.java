package gui;

import database.GetStudents;
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
import userdata.Student;

public class StudentsGUI {

    public Scene getScene() {

        //Creating the layout...
        BorderPane layout = new BorderPane();

        //Creating the menu...
        HBox menu = new HBox();
        VBox right = new VBox();

        //Creating the table for viewing the students...
        TableView<Student> table = GetStudents.students();

        //Setting colors...
        table.setStyle("-fx-background-color: #fff0e5");
        right.setStyle("-fx-background-color: #fff0e5");

        //Making columns...
        TableColumn<Student, String> emailColumn = new TableColumn<Student, String>("Email");
        emailColumn.setCellValueFactory(new PropertyValueFactory<>("email"));

        TableColumn<Student, String> nameColumn = new TableColumn<Student, String>("Name");
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));

        TableColumn<Student, String> dateOfBirthColumn = new TableColumn<Student, String>("DateOfBirth");
        dateOfBirthColumn.setCellValueFactory(new PropertyValueFactory<>("dateOfBirth"));

        TableColumn<Student, String> genderColumn = new TableColumn<Student, String>("Gender");
        genderColumn.setCellValueFactory(new PropertyValueFactory<>("gender"));

        TableColumn<Student, String> addressColumn = new TableColumn<Student, String>("Address");
        addressColumn.setCellValueFactory(new PropertyValueFactory<>("address"));

        TableColumn<Student, String> cityColumn = new TableColumn<Student, String>("City");
        cityColumn.setCellValueFactory(new PropertyValueFactory<>("city"));

        TableColumn<Student, String> countryColumn = new TableColumn<Student, String>("Country");
        countryColumn.setCellValueFactory(new PropertyValueFactory<>("country"));

        TableColumn<Student, String> postalCodeColumn = new TableColumn<Student, String>("PostalCode");
        postalCodeColumn.setCellValueFactory(new PropertyValueFactory<>("postalCode"));

        //Adding the columns to the table...
        table.getColumns().addAll(emailColumn, nameColumn, dateOfBirthColumn, genderColumn, addressColumn, cityColumn,
                countryColumn, postalCodeColumn);

        //Creating the buttons for the menu...
        Button back = new Button("Back");
        Label nameText = new Label("Codecademy");
        Button info = new Button("Info");
        Button logout = new Button("Logout");

        //Creating buttons for the body...
        Button add = new Button("Add");
        Button edit = new Button("Edit");
        Button delete = new Button("Delete");

        //Adding the buttons to the menu...
        menu.getChildren().addAll(back, nameText, info, logout);
        menu.setStyle("-fx-background-color: #ffd300");

        //Adding the buttons to the body...
        right.getChildren().addAll(add, edit, delete);

        //Adding the menu to the layout...
        HBox.setMargin(nameText, new Insets(10, 10, 10, 10));
        menu.setAlignment(Pos.BASELINE_CENTER);
        layout.setTop(menu);

        //Adding the body to the layout...
        layout.setCenter(table);
        layout.setRight(right);
        // giving the buttons function
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
        add.setOnAction(event -> {
            AddStudentsGUI addGUI = new AddStudentsGUI();
            Stage window = MainGUI.getStage();
            window.setScene(addGUI.getStage());
        });

        //Making the scene...
        return new Scene(layout, 700, 200);

    }

}
