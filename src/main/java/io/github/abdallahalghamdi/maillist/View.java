package io.github.abdallahalghamdi.maillist;

import io.github.abdallahalghamdi.maillist.ui.AppBar;
import io.github.abdallahalghamdi.maillist.ui.MailRow;
import io.github.abdallahalghamdi.maillist.ui.TripleBorderBox;
import javafx.scene.control.ListView;
import javafx.scene.layout.Priority;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;


public class View  {
    Model model;
    public View(Model model){
        this.model = model;
    }
    public Region getView() {
        VBox root = new VBox(AppBar.getAppBar(),getMailList());
        return root;
    }
    private Region getMailList(){
        ListView<MailRow> list = new ListView<>();
        list.getStyleClass().add("mailListView");
        VBox.setVgrow(list, Priority.ALWAYS);

        list.getItems().add(new MailRow("Dad", "About Chaud", false, true));
        list.getItems().add(new MailRow("Dad", "About Chaud", false, false));
        list.getItems().add(new MailRow("Dad", "About Chaud", true, false));
        list.getItems().add(new MailRow("Dad", "About Chaud", false, false));
        list.getItems().add(new MailRow("Dad", "About Chaud", false, false));


        return new TripleBorderBox(list);
    }

}
