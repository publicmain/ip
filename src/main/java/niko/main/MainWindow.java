package niko.main;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;

import java.util.Objects;

/**
 * Controller for the main GUI.
 */
public class MainWindow extends AnchorPane {
    @FXML
    private ScrollPane scrollPane;
    @FXML
    private VBox dialogContainer;
    @FXML
    private TextField userInput;
    @FXML
    private Button sendButton;

    private Niko niko;
    private final Image userImage = new Image(Objects.requireNonNull(this.getClass().getResourceAsStream("/images/user.png")));
    private final Image dukeImage = new Image(Objects.requireNonNull(this.getClass().getResourceAsStream("/images/niko.png")));

    /**
     * Initializes the controller class. This method is automatically called
     * after the fxml file has been loaded.
     */
    @FXML
    public void initialize() {
        // Add a listener to automatically scroll to the bottom when new messages are added
        dialogContainer.heightProperty().addListener((observable, oldValue, newValue) -> {
            scrollPane.setVvalue(1.0);
        });
    }


    /**
     * Sets the Niko instance for processing user input.
     *
     * @param niko The Niko chatbot instance.
     */
    public void setNiko(Niko niko) {
        this.niko = niko;
        this.niko.setMainWindow(this);
        // Optionally, display a welcome message
        // String welcome = niko.getUi().showWelcomeMessage("Niko");
        // showDialog(welcome);
    }

    /**
     * Handles the user input by passing it to Niko and displaying the response.
     */
    @FXML
    public void handleUserInput() {
        String input = userInput.getText();
        if (!input.trim().isEmpty()) {
            // Display user dialog
            dialogContainer.getChildren().addAll(
                    DialogBox.getUserDialog(input, userImage)
            );

            // Pass the input to Niko for processing
            niko.processUserInput(input);
        }
        userInput.clear();
    }


    /**
     * Displays the chatbot's response in the dialog container.
     *
     * @param nikoText The chatbot's response text.
     */
    public void showDialog(String nikoText) {
        dialogContainer.getChildren().addAll(
                DialogBox.getDukeDialog(nikoText, dukeImage)
        );
    }

    /**
     * Displays error messages in a distinct format.
     *
     * @param errorText The error message to display.
     */
    public void showError(String errorText) {
        dialogContainer.getChildren().addAll(
                DialogBox.getErrorDialog(errorText)
        );
        Platform.runLater(() -> scrollPane.setVvalue(1.0));
    }

}