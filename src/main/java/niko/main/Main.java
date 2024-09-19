package niko.main;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.util.Objects;

/**
 * The Main class to start the Niko chatbot.
 */
public class Main extends Application{
    private final Niko chatbot = new Niko("example.txt");

    /**
     * Starts the JavaFX application.
     *
     * @param stage The primary stage for this application.
     */
    public void start(Stage stage) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("/view/MainWindow.fxml"));
            AnchorPane ap = fxmlLoader.load();
            Scene scene = new Scene(ap, 400, 600);
            scene.getStylesheets().add(Objects.requireNonNull(Main.class.getResource("/styles/styles.css")).toExternalForm());

            stage.setTitle("Niko Chatbot");
            stage.setScene(scene);
            stage.setMinWidth(300);
            stage.setMinHeight(400);
            fxmlLoader.<MainWindow>getController().setNiko(chatbot);
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * The main method to launch the JavaFX application.
     *
     * @param args The command line arguments.
     */
    public static void main(String[] args) {
        launch(args);
    }
}