package niko.main;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.shape.Circle;

import java.util.Objects;

/**
 * Represents a dialog box consisting of an ImageView to represent the speaker's face and a label
 * containing text from the speaker.
 */
public class DialogBox extends HBox {

    /**
     * Constructs a DialogBox with the specified text and display picture.
     *
     * @param text           The label containing the dialog text.
     * @param displayPicture The image view containing the speaker's picture.
     */
    public DialogBox(Label text, ImageView displayPicture) {
        text.setWrapText(true);
        displayPicture.setFitWidth(50.0);
        displayPicture.setFitHeight(50.0);

        // Apply circular clipping to the display picture
        Circle clip = new Circle(25, 25, 25);
        displayPicture.setClip(clip);

        this.getChildren().addAll(displayPicture, text);
        this.setAlignment(Pos.TOP_LEFT);
        this.setSpacing(10);
        this.getStyleClass().add("dialog-box");
    }

    /**
     * Flips the dialog box such that the image is on the opposite side.
     */
    public void flip() {
        ObservableList<Node> tmp = FXCollections.observableArrayList(this.getChildren());
        FXCollections.reverse(tmp);
        this.getChildren().setAll(tmp);
        this.setAlignment(Pos.TOP_RIGHT);
    }

    /**
     * Creates a dialog box for the user with the image on the right side.
     *
     * @param text The user's input text.
     * @param img  The user's profile image.
     * @return A DialogBox representing the user's message.
     */
    public static DialogBox getUserDialog(String text, Image img) {
        Label label = new Label(text);
        label.getStyleClass().add("user-label");
        ImageView imageView = new ImageView(img);
        DialogBox db = new DialogBox(label, imageView);
        db.flip();
        return db;
    }

    /**
     * Creates a dialog box for the chatbot with the image on the left side.
     *
     * @param text The chatbot's response text.
     * @param img  The chatbot's profile image.
     * @return A DialogBox representing the chatbot's message.
     */
    public static DialogBox getDukeDialog(String text, Image img) {
        Label label = new Label(text);
        label.getStyleClass().add("duke-label");
        ImageView imageView = new ImageView(img);
        return new DialogBox(label, imageView);
    }

    /**
     * Creates a dialog box for displaying error messages with distinct styling.
     *
     * @param text The error message text.
     * @return A DialogBox representing the error message.
     */
    public static DialogBox getErrorDialog(String text) {
        Label label = new Label(text);
        label.getStyleClass().add("error-label");
        ImageView imageView = new ImageView(new Image(Objects.requireNonNull(DialogBox.class.getResourceAsStream("/images/error.png"))));
        return new DialogBox(label, imageView);
    }
}
