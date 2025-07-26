package io.github.abdallahalghamdi.maillist.ui;

import javafx.scene.Node;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;

public class AppBar {
    final static HBox appbar = new HBox();
    final static Text appbarTitle = new Text("CuteMail");
    public static Node getAppBar(){
        appbarTitle.getStyleClass().addAll("textMax", "textPrimary");
        appbarTitle.getStyleClass().addAll("textMax", "textPrimary");
        appbarTitle.setSmooth(false);

        appbar.getChildren().add(appbarTitle);
        appbar.getStyleClass().add("appbar");
        return appbar;
    }

}
