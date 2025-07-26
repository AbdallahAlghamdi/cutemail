package io.github.abdallahalghamdi.maillist.ui;

import javafx.scene.control.ListView;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;

public class MailList extends ListView<MailRow> {
    public MailList() {
        getStyleClass().add("mailListView");
        VBox.setVgrow(this, Priority.ALWAYS);
        handleCursor();
    }
    private void handleCursor() {
        getSelectionModel().selectedItemProperty().addListener((observable, oldMail, newMail
        ) -> {
            newMail.setIsNew(false);
//            System.out.println("----------");
//            System.out.println(observable);
//            System.out.println(oldMail);
//            System.out.println(newMail);
            if (oldMail != null) {
                oldMail.setIsSelect(false);
            }
            newMail.setIsSelect(true);
        });
    }
}
