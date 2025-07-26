package io.github.abdallahalghamdi.maillist.ui;

import javafx.scene.layout.HBox;
import javafx.scene.text.Text;

public class AppBar extends HBox {

    public AppBar() {
        final Text appbarTitle = new Text("CuteMail");
        appbarTitle.getStyleClass().addAll("textMax", "textPrimary");
        appbarTitle.setSmooth(false);

        getStyleClass().add("appbar");
        getChildren().add(appbarTitle);
    }

}
