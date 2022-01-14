package gui;

import database.DeleteItem;
import database.GetCertificates;
import database.GetCourses;
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
import userdata.Certificate;
import userdata.Course;

public class CertificatesGUI {
    
    public Scene getScene() {

        //Creating the layout...
        BorderPane layout = new BorderPane();

        //Creating the menu...
        HBox menu = new HBox();
        VBox right = new VBox();

        //Making the table for viewing the certificates...
        final TableView<Certificate> table = new TableView<Certificate>();

        //Converting list of certificates to an observablelist...
        ObservableList<Certificate> certificatesList = FXCollections.observableList(GetCertificates.certificatesList());

        table.setItems(certificatesList);

        //Setting colors...
        table.setStyle("-fx-background-color: #fff0e5");
        right.setStyle("-fx-background-color: #fff0e5");

        //Making columns...
        TableColumn<Certificate, String> idColumn = new TableColumn<Certificate, String>("Id");
        idColumn.setCellValueFactory(new PropertyValueFactory<>("certificateId"));

        TableColumn<Certificate, String> ratingColumn = new TableColumn<Certificate, String>("Beoordeling");
        ratingColumn.setCellValueFactory(new PropertyValueFactory<>("rating"));

        TableColumn<Certificate, String> nameEmployeeColumn = new TableColumn<Certificate, String>("Naam Medewerker");
        nameEmployeeColumn.setCellValueFactory(new PropertyValueFactory<>("nameEmployee"));

        //Adding the columns to the table...
        table.getColumns().addAll(idColumn, ratingColumn, nameEmployeeColumn);

        //Creating the buttons for the menu...
        Button back = new Button("Back");
        Label nameText = new Label("Codecademy");
        Button info = new Button("Info");
        Button logout = new Button("Logout");

        //Creating the buttons for the body...
        Button add = new Button("Add");
        Button edit = new Button("Edit");
        Button delete = new Button("Delete");

        //Adding the buttons to the body...
        right.getChildren().addAll(add, edit,  delete);

        //Adding the buttons to menu...
        menu.getChildren().addAll(back, nameText, info, logout);
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
            Stage window = MainGUI.getStage();
            window.setScene(hGui.getScene());
        });
        info.setOnAction(event -> {
            InfoGUI InfoGUI = new InfoGUI();
            Stage window = MainGUI.getStage();
            window.setScene(InfoGUI.getScene());
        });
        add.setOnAction(actionEvent -> {
            AddEditCertificatesGUI addCoursesGUI = new AddEditCertificatesGUI();
            Stage window = MainGUI.getStage();
            window.setScene(addCoursesGUI.getStage());
        });
        edit.setOnAction(actionEvent -> {
            Certificate certificate = table.getSelectionModel().getSelectedItem();
            AddEditCertificatesGUI addEditCertificatesGUI = new AddEditCertificatesGUI();
            Stage window = MainGUI.getStage();
            window.setScene(addEditCertificatesGUI.editStage(Integer.toString(certificate.getCertificateId()),
                    Double.toString(certificate.getRating()), certificate.getNameEmployee()));
        });
        delete.setOnAction(actionEvent -> {
            Certificate certificate = table.getSelectionModel().getSelectedItem();
            if (certificate != null) {
                DeleteItem.deleteItem(Integer.toString(certificate.getCertificateId()), "Certificaat", "CertificaatId");
                CertificatesGUI mGui = new CertificatesGUI();
                Stage window = MainGUI.getStage();
                window.setScene(mGui.getScene());
            }
        });

        //Making the scene...
        return new Scene(layout, 800, 400);

    }
    
}
