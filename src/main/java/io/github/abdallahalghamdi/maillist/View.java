package io.github.abdallahalghamdi.maillist;

import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;
import javafx.scene.text.FontSmoothingType;
import javafx.scene.text.Text;
import javafx.util.Builder;

public class View implements Builder<Region> {
    @Override
    public Region build() {

        VBox root = new VBox(getAppbar());
        root.getStyleClass().add("red");
        return root;
    }

    private Node getAppbar(){
        HBox hbox = new HBox();
        Text appbarTitle = new Text("CuteMail");
        appbarTitle.getStyleClass().addAll("textMax", "outline-text");
        appbarTitle.setSmooth(false);
        appbarTitle.setEffect(null);
        appbarTitle.setFontSmoothingType(FontSmoothingType.GRAY);



        hbox.getChildren().add(appbarTitle);
//        hbox.getStyleClass().add("appbar");
        return hbox;
    }
}
