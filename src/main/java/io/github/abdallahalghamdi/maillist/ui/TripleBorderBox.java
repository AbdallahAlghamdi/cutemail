package io.github.abdallahalghamdi.maillist.ui;

import javafx.scene.layout.Priority;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;

public class TripleBorderBox extends VBox {
    public TripleBorderBox(Region child) {
        VBox.setVgrow(this, Priority.ALWAYS);

        getStyleClass().addAll("border-outline", "outline-first");
        VBox middleBox = getBorderVBox("outline-second");
        VBox inBox = getBorderVBox("outline-third");
        if (child != null)
            inBox.getChildren().add(child);

        getStyleClass().add("mailListContainer");
        middleBox.getChildren().add(inBox);
        getChildren().add(middleBox);
    }

    private VBox getBorderVBox(String... classNames) {
        VBox box = new VBox();
        box.getStyleClass().addAll(classNames);
        box.getStyleClass().addAll("border-outline");
        VBox.setVgrow(box, Priority.ALWAYS);
        return box;
    }

}
