package io.github.abdallahalghamdi.maillist;

import io.github.abdallahalghamdi.maillist.ui.MailRow;
import javafx.collections.ObservableList;

public class Interactor {
    private Model model;

    Interactor(Model model){
        this.model = model;
    }

    public void handleCursor(ObservableList<MailRow> observable, MailRow oldMail, MailRow newMail){
        System.out.println(observable);
        System.out.println(oldMail);
        System.out.println(newMail);
        if(oldMail!= null)
            oldMail.setIsSelect(false);
        newMail.setIsSelect(true);
    }
}
