package io.github.abdallahalghamdi.maillist;

import io.github.abdallahalghamdi.maillist.ui.AppBar;
import io.github.abdallahalghamdi.maillist.ui.MailList;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;

public class View {
    final Model model;

    public View(Model model) {
        this.model = model;
    }

    public Region getView() {
        // TripleBorderBox maillist = new TripleBorderBox(getMailList());
        AppBar appBar = new AppBar();
        VBox root = new VBox(appBar, getMailList());
        return root;
    }

    private Region getMailList() {
        MailList mailList = new MailList();
        mailList.setItems(model.getMailInbox());
        mailList.getSelectionModel().select(0);
        return mailList;
    }

}
