package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.List;

public class Main extends Application {
    static VBox root;
    static List<GridPane> gridPaneList = new ArrayList<GridPane> ();
    private static int index_current = 0;
    @Override
    public void start(Stage primaryStage) throws Exception {     // a Stage is the main window for a JavaFX application
        // initialize some test data

        root = FXMLLoader.load(getClass().getResource("Multiscene.fxml"));
        gridPaneList.add(FXMLLoader.load(getClass().getResource("patients.fxml")));
        gridPaneList.add(FXMLLoader.load(getClass().getResource("employees.fxml")));

        //root.getChildren().add(gridPanePatients);
        primaryStage.setTitle("CoronaNet");
        Scene scene = new Scene(root, 1200, 600); // create a scene window 1200 x 500 pixels
        root.setStyle("-fx-background-image: " +
                "url(\"https://i2.wp.com/churchmediadrop.com/wp-content/uploads/edd/2017/08/Welcome-Slide-2_720p.jpg?fit=1280%2C720&ssl=1\"); -fx-background-radius: 500;"
        );
        primaryStage.setScene(scene);                   // add the scene to the stage / application window
        primaryStage.show();                 // display the stage - important! otherwise nothing happens :-)

    }
    public static void main(String[] args) {
        launch(args);
    }

    public static void setGridPane (int index) {
        root.getChildren().remove(gridPaneList.get(index_current));
        root.getChildren().add(gridPaneList.get(index));
        index_current=index;
    };
}

