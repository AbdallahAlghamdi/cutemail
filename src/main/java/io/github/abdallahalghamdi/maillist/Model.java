package io.github.abdallahalghamdi.maillist;

import io.github.abdallahalghamdi.maillist.ui.MailRow;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;


public class Model {
    private final ObservableList<MailRow> mailInbox;
    public Model(){
        mailInbox = FXCollections.observableArrayList();
        setDefault();
    }
    public void setDefault(){
        mailInbox.add(new MailRow("Dad", "About Chaud", false, false));
        mailInbox.add(new MailRow("Ronny", "How are you?", false, false));
        mailInbox.add(new MailRow("Ronny", "How are you?", true, false));
        mailInbox.add(new MailRow("Ronny", "How are you?", false, false));
        mailInbox.add(new MailRow("Ronny", "How are you?", false, false));


    }
    public ObservableList<MailRow> getMailInbox(){
        return mailInbox;
    }
}
