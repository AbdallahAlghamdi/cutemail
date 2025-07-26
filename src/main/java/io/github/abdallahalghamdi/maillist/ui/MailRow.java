package io.github.abdallahalghamdi.maillist.ui;

import javafx.beans.property.SimpleBooleanProperty;
import javafx.geometry.Insets;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.text.Text;

import java.net.URL;

public class MailRow extends HBox {
    private final SimpleBooleanProperty isNew;
    private final SimpleBooleanProperty isSelect;
    public MailRow(String sender, String mailTitle, boolean isNew, boolean isSelect) {
        this.isNew = new SimpleBooleanProperty(isNew);
        this.isSelect = new SimpleBooleanProperty(isSelect);

        BorderPane mailRowPane = new BorderPane();
        HBox.setHgrow(mailRowPane, Priority.ALWAYS);
        Text mailTextText = new Text(mailTitle);
        Text senderText = new Text(sender);
        HBox leftBox = new HBox();

        Text newMessage = new Text("NEW");
        newMessage.setVisible(isNew);
        leftBox.getChildren().addAll(newMessage, senderText);
        leftBox.setSpacing(5);

        mailRowPane.setLeft(leftBox);
        mailRowPane.setRight(mailTextText);

        HBox.setMargin(mailRowPane, new Insets(0, 32,0,0));


        ImageView cursor = getCursorImage();
        if(!isSelect)
            cursor.setVisible(false);

        getChildren().addAll(cursor,mailRowPane);


    }
    private ImageView getCursorImage(){
        String cursorURL = getClass().getResource("/images/cursor-up.png").toExternalForm();

        Image cursorImage = new Image(cursorURL, 32, 32, true, false);
        ImageView cursor = new ImageView(cursorImage);
        cursor.setRotate(90);
        cursor.setSmooth(false);

        return cursor;
    }
    public void setIsNew(boolean isNew){
        this.isNew.set(isNew);
    }
    public void setIsSelect(boolean isSelect){
        this.isSelect.set(isSelect);
    }
}
