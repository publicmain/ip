package niko.main;


import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;


public class DialogBox extends HBox {

    public DialogBox(Label text, ImageView displayPicture) {
        text.setWrapText(true);
        displayPicture.setFitWidth(100.0);
        displayPicture.setFitHeight(100.0);

        this.getChildren().addAll(displayPicture, text);
    }

    public static DialogBox getUserDialog(String text, Image img) {
        return getDukeDialog(text, img);
    }

    public static DialogBox getDukeDialog(String text, Image img) {
        Label label = new Label(text);
        ImageView imageView = new ImageView(img);

        return new DialogBox(label,imageView);
    }
}
