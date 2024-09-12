package niko.main;

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
    private Ui ui;
    private final Image userImage = new Image(Objects.requireNonNull(this.getClass().getResourceAsStream("images/images.jpeg")));
    private final Image dukeImage = new Image(Objects.requireNonNull(this.getClass().getResourceAsStream("images/images2.jpeg")));
    private String input;
    private String response;

    @FXML
    public void initialize() {
        scrollPane.vvalueProperty().bind(dialogContainer.heightProperty());
    }

    /** Injects the Duke instance */
    public void setNiko(Niko d) {
        niko = d;
    }

    /**
     * Creates two dialog boxes, one echoing user input and the other containing Duke's reply and then appends them to
     * the dialog container. Clears the user input after processing.
     */
    public void setInput(String input) {
        this.input = input;
    }

    public void setResponse(String response) {
        this.response = response;
    }
    @FXML
    public void handleUserInput() {
        niko.run();
        dialogContainer.getChildren().addAll(
                DialogBox.getUserDialog(input, userImage),
                DialogBox.getDukeDialog(response, dukeImage)
        );
        userInput.clear();
    }



}
