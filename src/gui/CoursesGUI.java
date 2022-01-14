package gui;

import database.DeleteItem;
import database.GetCourses;
import database.Overviews;
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
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import userdata.Course;

import java.util.List;

public class CoursesGUI {

    public Scene getScene() {

        //Creating the layout...
        BorderPane layout = new BorderPane();

        //Creating the menu...
        HBox menu = new HBox();
        VBox right = new VBox();

        //Making the table for viewing the courses...
        final TableView<Course> table = new TableView<Course>();

        //Converting list of courses to an observablelist...
        ObservableList<Course> coursesList = FXCollections.observableList(GetCourses.coursesList());

        table.setItems(coursesList);

        //Setting colors...
        table.setStyle("-fx-background-color: #fff0e5");
        right.setStyle("-fx-background-color: #fff0e5");

        //Making columns...
        TableColumn<Course, String> nameColumn = new TableColumn<Course, String>("Name");
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));

        TableColumn<Course, String> subjectColumn = new TableColumn<Course, String>("Subject");
        subjectColumn.setCellValueFactory(new PropertyValueFactory<>("subject"));

        TableColumn<Course, String> introductionTextColumn = new TableColumn<Course, String>("IntroductionText");
        introductionTextColumn.setCellValueFactory(new PropertyValueFactory<>("introductionText"));

        TableColumn<Course, String> levelColumn = new TableColumn<Course, String>("Level");
        levelColumn.setCellValueFactory(new PropertyValueFactory<>("level"));

        //Adding the columns to the table...
        table.getColumns().addAll(nameColumn, subjectColumn, introductionTextColumn, levelColumn);

        //Creating the buttons for the menu...
        Button back = new Button("Back");
        Label nameText = new Label("Codecademy");
        Button info = new Button("Info");
        Button logout = new Button("Logout");


        //Creating the buttons for the body...
        Button add = new Button("Add");
        Button edit = new Button("Edit");
        Button delete = new Button("Delete");
        Button overview = new Button("Overview");
        Button top3 = new Button("Top 3");
        Button averageProgressPerModule = new Button("Average\nprogress\nper module");
        Button buttonInfo = new Button("Show amount\nof students\nthat passed");

        //Adding the buttons to the body...
        right.getChildren().addAll(add, edit,  delete, overview, top3, averageProgressPerModule, buttonInfo);

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

        //Creates resultfield in the GUI
        HBox resultBox = new HBox();
        Label result = new Label();
        result.setTextFill(Color.web("#fff"));
        resultBox.getChildren().add(result);
        resultBox.setStyle("-fx-background-color: #7fb7d4");
        resultBox.setAlignment(Pos.BASELINE_CENTER);
        layout.setBottom(resultBox);

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
            AddEditCoursesGUI addCoursesGUI = new AddEditCoursesGUI();
            Stage window = MainGUI.getStage();
            window.setScene(addCoursesGUI.getStage());
        });
        edit.setOnAction(actionEvent -> {
            Course course = table.getSelectionModel().getSelectedItem();
            AddEditCoursesGUI addCoursesGUI = new AddEditCoursesGUI();
            Stage window = MainGUI.getStage();
            window.setScene(addCoursesGUI.editStage(course.getName(), course.getSubject(),
                    course.getIntroductionText(), course.getLevel().toString()));
        });
        delete.setOnAction(actionEvent -> {
            Course course = table.getSelectionModel().getSelectedItem();
            if (course != null) {
                DeleteItem.deleteItem(course.getName(), "Cursus", "Naam");
                CoursesGUI mGui = new CoursesGUI();
                Stage window = MainGUI.getStage();
                window.setScene(mGui.getScene());
            }
        });

        top3.setOnAction(actionEvent -> {

            //Calling the function what executes a query and returns the top 3 most viewed webcasts
            List<String> top3MostViewedWebcasts = Overviews.mostViewedWebcasts();

            //Displays the result on the screen
            result.setText("Meest bekeken webcasts\n" + "1: " + top3MostViewedWebcasts.get(0) + "\n2: " + top3MostViewedWebcasts.get(1) + "\n3: " + top3MostViewedWebcasts.get(2));

        });

        averageProgressPerModule.setOnAction(actionEvent -> {
            //To be implemented
        });

        buttonInfo.setOnAction(actionEvent -> {
            //Selects the current course
            Course course = table.getSelectionModel().getSelectedItem();

            //Calling the function what makes and executes a query and returns the results in a string
            String amountOfCompletionsBySelectedCourse = Overviews.amountOfCompletions(course.getName());

            //Displays the result on the screen
            result.setText("Amount of students who passed this course: " + amountOfCompletionsBySelectedCourse);

        });

        //Making the scene...
        return new Scene(layout, 800, 600);

    }

}