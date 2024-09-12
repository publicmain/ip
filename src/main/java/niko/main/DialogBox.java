package niko.main;

import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Node;
import javafx.scene.layout.Region;

public class DialogBox extends HBox {

    public DialogBox(Label text, ImageView displayPicture) {
        text.setWrapText(true);
        displayPicture.setFitWidth(100.0);
        displayPicture.setFitHeight(100.0);
//        this.setAlignment(Pos.TOP_RIGHT);

        this.getChildren().addAll(displayPicture, text);
    }
    private void flip() {
        this.setAlignment(Pos.TOP_LEFT);
        ObservableList<Node> tmp = FXCollections.observableArrayList(this.getChildren());
        FXCollections.reverse(tmp);
        this.getChildren().setAll(tmp);
    }
    public static DialogBox getUserDialog(String text, Image img) {
        Label label = new Label(text);
        ImageView imageView = new ImageView(img);
        var db = new DialogBox(label,imageView);

        return db;
    }

    public static DialogBox getDukeDialog(String text, Image img) {
        Label label = new Label(text);
        ImageView imageView = new ImageView(img);

        return new DialogBox(label,imageView);
    }
}
