package io.github.abdallahalghamdi.maillist.ui;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.text.Text;

public class MailRow extends HBox {
    private final SimpleBooleanProperty isNew;
    private final SimpleBooleanProperty isSelect;
    public MailRow(String sender, String mailTitle, boolean isNew, boolean isSelect) {
        this.isNew = new SimpleBooleanProperty(isNew);
        this.isSelect = new SimpleBooleanProperty(isSelect);
        setPrefHeight(50);

        ImageView cursor = getCursorImage();
        if (!isSelect)
            cursor.visibleProperty().bind(this.isSelect);
        setSpacing(5);
        setAlignment(Pos.CENTER);
        getChildren().addAll(cursor, getBorderPane(sender, mailTitle));
    }
    private BorderPane getBorderPane(String sender, String mailTitle){
        BorderPane mailRowPane = new BorderPane();
        HBox.setHgrow(mailRowPane, Priority.ALWAYS);
        Text mailTextText = new Text(mailTitle);
        HBox rightBox = sideBox(mailTextText);
        rightBox.setPadding(new Insets(0,10,0,0));

        Text senderText = new Text(sender);
        HBox leftBox = sideBox();

        HBox newBox = new NewIndicator();
        newBox.visibleProperty().bind(this.isNew);
        leftBox.getChildren().addAll(newBox, senderText);

        mailRowPane.setLeft(leftBox);
        mailRowPane.setRight(rightBox);

        return mailRowPane;
    }
    private HBox sideBox(Node... child){
        HBox hBox = new HBox(child);
        hBox.setAlignment(Pos.CENTER);
        return  hBox;
    }
    private ImageView getCursorImage() {
        String cursorURL = getClass().getResource("/images/cursor-right.gif").toExternalForm();

        Image cursorImage = new Image(cursorURL, 32, 32, true, false);
        ImageView cursor = new ImageView(cursorImage);
        cursor.setSmooth(false);

        return cursor;
    }
    public void setIsNew(boolean isNew) {
        this.isNew.set(isNew);
    }
    public void setIsSelect(boolean isSelect) {
        this.isSelect.set(isSelect);
    }
}
