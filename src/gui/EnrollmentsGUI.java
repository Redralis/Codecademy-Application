package gui;

import database.DeleteItem;
import database.GetCourses;
import database.GetEnrollments;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
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
        TableView<Enrollment> table = new TableView<Enrollment>();

        //Converting list of enrollments to an observablelist...
        ObservableList<Enrollment> enrollmentsList = FXCollections.observableList(GetEnrollments.enrollmentsList());

        table.setItems(enrollmentsList);

        //Setting colors...
        table.setStyle("-fx-background-color: #fff0e5");
        right.setStyle("-fx-background-color: #fff0e5");

        //Making columns...
        TableColumn<Enrollment, String> dateOfEnrollmentColumn = new TableColumn<Enrollment, String>("Inschrijvingsdatum");
        dateOfEnrollmentColumn.setCellValueFactory(new PropertyValueFactory<>("dateOfEnrollment"));

        TableColumn<Enrollment, String> studentColumn = new TableColumn<Enrollment, String>("Student");
        studentColumn.setCellValueFactory(new PropertyValueFactory<>("student"));

        TableColumn<Enrollment, String> courseColumn = new TableColumn<Enrollment, String>("Cursus");
        courseColumn.setCellValueFactory(new PropertyValueFactory<>("course"));

        TableColumn<Enrollment, String> certificateColumn = new TableColumn<Enrollment, String>("Certificaat");
        certificateColumn.setCellValueFactory(new PropertyValueFactory<>("certificate"));


        //Adding the columns to the table...
        table.getColumns().addAll(dateOfEnrollmentColumn, studentColumn, courseColumn, certificateColumn);

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
            Stage window = MainGUI.getStage();
            window.setScene(hGui.getScene());
            
        });
        info.setOnAction(event -> {
            InfoGUI InfoGUI = new InfoGUI();
            Stage window = MainGUI.getStage();
            window.setScene(InfoGUI.getScene());
        });
        add.setOnAction(actionEvent -> {
            AddEditEnrollmentsGUI addEnrollmentsGUI = new AddEditEnrollmentsGUI();
            Stage window = MainGUI.getStage();
            window.setScene(addEnrollmentsGUI.getStage());
        });
        edit.setOnAction(actionEvent -> {
            Enrollment enrollment = table.getSelectionModel().getSelectedItem();
            AddEditEnrollmentsGUI addEnrollmentsGUI = new AddEditEnrollmentsGUI();
            Stage window = MainGUI.getStage();
            window.setScene(addEnrollmentsGUI.editStage(enrollment.getDateOfEnrollment(), enrollment.getStudent(),
                    enrollment.getCourse()));
        });
        delete.setOnAction(actionEvent -> {
            Enrollment enrollment = table.getSelectionModel().getSelectedItem();
            if (enrollment != null) {
                DeleteItem.deleteItem(enrollment.getStudent(), enrollment.getDateOfEnrollment(), "Inschrijving",
                "FK_Cursist", "InschrijfDatum");
                EnrollmentsGUI mGui = new EnrollmentsGUI();
                Stage window = MainGUI.getStage();
                window.setScene(mGui.getScene());
            }
        });

        //Making the scene...
        return new Scene(layout, 800, 400);

    }

}
