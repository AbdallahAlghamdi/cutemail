package io.github.abdallahalghamdi.maillist;

import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;
import javafx.scene.text.FontSmoothingType;
import javafx.scene.text.Text;
import javafx.util.Builder;

public class View implements Builder<Region> {
    @Override
    public Region build() {

        VBox root = new VBox(getAppbar(),getMailList());
        return root;
    }
    private Node getMailList(){
        VBox body = new VBox();
        body.getStyleClass().add("primary-outline");
        VBox.setVgrow(body, Priority.ALWAYS);

        return body;
    }
    private Node getAppbar(){
        HBox hbox = new HBox();

        Text appbarTitle = new Text("CuteMail");
        appbarTitle.getStyleClass().addAll("textMax", "textPrimary");
        appbarTitle.setSmooth(false);

        hbox.getChildren().add(appbarTitle);
        hbox.getStyleClass().add("appbar");
        return hbox;
    }
}
