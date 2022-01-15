package gui;

import database.AddItem;
import database.EditItem;
import database.Overviews;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class AddEditCoursesGUI {
    public Scene getStage() {
        //Creating the layout...
        BorderPane layout = new BorderPane();

        //Creating the menu...
        HBox menu = new HBox();

        //Creating the body...
        GridPane body = new GridPane();

        //Creating buttons for the menu...
        Button back = new Button("Back");
        Label nameText = new Label("Codecademy");
        Button info = new Button("Info");
        Button logout = new Button("Logout");

        //Adding buttons to the menu...
        menu.getChildren().addAll(back, nameText, info, logout);
        menu.setStyle("-fx-background-color: #ffd300;");

        //Creating buttons for the body...
        Label nameLabel = new Label("Enter the course's name: ");
        TextArea nameField = new TextArea();
        nameField.setPromptText("Type the name of the course: ");
        nameField.setMaxHeight(40);
        Label subjectLabel = new Label("Enter the course's subject: ");
        TextArea subjectField = new TextArea();
        subjectField.setPromptText("Type the name of the subject for the course: ");
        subjectField.setMaxHeight(40);
        Label introductionLabel = new Label("Enter the course's introduction text: ");
        TextArea introductionField = new TextArea();
        introductionField.setPromptText("Type a introduction: ");
        introductionField.setMaxHeight(40);
        Label moduleLabel = new Label("Choose a module to pair: ");
        final ComboBox moduleBox = new ComboBox(FXCollections.observableList(Overviews.unlinkedModules()));
        Label levelsLabel = new Label("Pick level of difficulty: ");
        ObservableList<String> levels =
                FXCollections.observableArrayList(
                        "Beginner",
                        "Advanced",
                        "Expert"
                );
        final ComboBox comboBox = new ComboBox(levels);
        Button submit = new Button("Submit");

        //Adding buttons to the body...
        body.add(nameLabel, 1, 1);
        body.add(nameField, 1, 2);
        body.add(subjectLabel, 1, 3);
        body.add(subjectField, 1, 4);
        body.add(introductionLabel, 1, 5);
        body.add(introductionField, 1, 6);
        body.add(moduleLabel, 1, 7);
        body.add(moduleBox, 1, 8);
        body.add(levelsLabel, 1, 9);
        body.add(comboBox, 1, 10);
        body.add(submit, 1, 11);

        body.setStyle("-fx-background-color: #fff0e5");

        //Adding menu and body to the layout...
        HBox.setMargin(nameText, new Insets(10, 10, 10, 10));
        menu.setAlignment(Pos.BASELINE_CENTER);
        layout.setTop(menu);
        layout.setCenter(body);

        //Positioning the buttons...
        body.setAlignment(Pos.BASELINE_CENTER);

        //Giving the buttons function...
        logout.setOnAction((event) -> {
            System.exit(1);
        });
        back.setOnAction(event -> {
            CoursesGUI cGui = new CoursesGUI();
            Stage window = MainGUI.getStage();
            window.setScene(cGui.getScene());
        });
        info.setOnAction(event -> {
            InfoGUI InfoGUI = new InfoGUI();
            Stage window = MainGUI.getStage();
            window.setScene(InfoGUI.getScene());
        });
        submit.setOnAction(event -> {
            if (nameField.getText().trim().length() == 0 || subjectField.getText().trim().length() == 0 ||
                    introductionField.getText().trim().length() == 0 || moduleBox.getSelectionModel().isEmpty() ||
                    comboBox.getSelectionModel().isEmpty()) {
                Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "Please make sure all fields have input.", ButtonType.OK);
                alert.showAndWait();
            } else {
                String module = (String) moduleBox.getValue();
                AddItem.addCourse(nameField.getText(), subjectField.getText(), introductionField.getText(),
                        (String) comboBox.getValue());
                Overviews.linkModule(nameField.getText(), Overviews.getModuleId(module));
                CoursesGUI mGui = new CoursesGUI();
                Stage window = MainGUI.getStage();
                window.setScene(mGui.getScene());
            }
        });

        //Creating the scrollpane...
        ScrollPane sp = new ScrollPane();

        sp.setContent(layout);
        sp.setFitToHeight(true);
        sp.setFitToWidth(true);
        //Creating the scene...
        return new Scene(sp, 800, 600);
    }

    public Scene editStage(String name, String subject, String introductionText, String level) {
        //Creating the layout...
        BorderPane layout = new BorderPane();

        //Creating the menu...
        HBox menu = new HBox();

        //Creating the body...
        GridPane body = new GridPane();

        //Creating buttons for the menu...
        Button back = new Button("Back");
        Label nameText = new Label("Codecademy");
        Button info = new Button("Info");
        Button logout = new Button("Logout");

        //Adding buttons to the menu...
        menu.getChildren().addAll(back, nameText, info, logout);
        menu.setStyle("-fx-background-color: #ffd300;");

        //Creating buttons for the body...
        Label nameLabel = new Label("Enter the course's name: ");
        TextArea nameField = new TextArea();
        nameField.setPromptText("Type the name of the course: ");
        nameField.setText(name);
        nameField.setMaxHeight(40);
        Label subjectLabel = new Label("Enter the course's subject: ");
        TextArea subjectField = new TextArea();
        subjectField.setPromptText("Type the name of the subject for the course: ");
        subjectField.setText(subject);
        subjectField.setMaxHeight(40);
        Label introductionLabel = new Label("Enter the course's introduction text: ");
        TextArea introductionField = new TextArea();
        introductionField.setPromptText("Type a introduction: ");
        introductionField.setText(introductionText);
        introductionField.setMaxHeight(40);
        Label levelsLabel = new Label("Pick level of difficulty: ");
        ObservableList<String> levels =
                FXCollections.observableArrayList(
                        "Beginner",
                        "Advanced",
                        "Expert"
                );
        final ComboBox comboBox = new ComboBox(levels);
        comboBox.setValue(level);
        Button submit = new Button("Submit");

        //Adding buttons to the body...
        body.add(nameLabel, 1, 1);
        body.add(nameField, 1, 2);
        body.add(subjectLabel, 1, 3);
        body.add(subjectField, 1, 4);
        body.add(introductionLabel, 1, 5);
        body.add(introductionField, 1, 6);
        body.add(levelsLabel, 1, 7);
        body.add(comboBox, 1, 8);
        body.add(submit, 1, 9);

        body.setStyle("-fx-background-color: #fff0e5");

        //Adding menu and body to the layout...
        HBox.setMargin(nameText, new Insets(10, 10, 10, 10));
        menu.setAlignment(Pos.BASELINE_CENTER);
        layout.setTop(menu);
        layout.setCenter(body);

        //Positioning the buttons...
        body.setAlignment(Pos.BASELINE_CENTER);

        //Giving the buttons function...
        logout.setOnAction((event) -> {
            System.exit(1);
        });
        back.setOnAction(event -> {
            CoursesGUI cGui = new CoursesGUI();
            Stage window = MainGUI.getStage();
            window.setScene(cGui.getScene());
        });
        info.setOnAction(event -> {
            InfoGUI InfoGUI = new InfoGUI();
            Stage window = MainGUI.getStage();
            window.setScene(InfoGUI.getScene());
        });
        submit.setOnAction(event -> {
            if (nameField.getText().trim().length() == 0 || subjectField.getText().trim().length() == 0 ||
                    introductionField.getText().trim().length() == 0 || comboBox.getSelectionModel().isEmpty()) {
                Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "Please make sure all fields have input.", ButtonType.OK);
                alert.showAndWait();
            } else {
                EditItem.editCourse(name, nameField.getText(), subjectField.getText(), introductionField.getText(),
                        (String) comboBox.getValue());
                CoursesGUI mGui = new CoursesGUI();
                Stage window = MainGUI.getStage();
                window.setScene(mGui.getScene());
            }
        });

        //Creating the scrollpane...
        ScrollPane sp = new ScrollPane();

        sp.setContent(layout);
        sp.setFitToHeight(true);
        sp.setFitToWidth(true);
        //Creating the scene...
        return new Scene(layout, 800, 600);

    }
}
