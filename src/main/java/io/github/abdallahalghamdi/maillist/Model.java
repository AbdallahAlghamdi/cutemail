package io.github.abdallahalghamdi.maillist;

import io.github.abdallahalghamdi.maillist.ui.MailRow;

import java.util.ArrayList;

public class Model {
    private ArrayList<MailRow> mailRows;
    public Model(){

    }
    public void setDefault(){
        mailRows.add(new MailRow("Dad", "About Chaud", false, true));
        mailRows.add(new MailRow("Dad", "About Chaud", false, true));
        mailRows.add(new MailRow("Dad", "About Chaud", false, true));
        mailRows.add(new MailRow("Dad", "About Chaud", false, true));
        mailRows.add(new MailRow("Dad", "About Chaud", false, true));
        mailRows.add(new MailRow("Dad", "About Chaud", false, true));
        mailRows.add(new MailRow("Dad", "About Chaud", false, true));
        mailRows.add(new MailRow("Dad", "About Chaud", false, true));
        mailRows.add(new MailRow("Dad", "About Chaud", false, true));
        mailRows.add(new MailRow("Dad", "About Chaud", false, true));
    }

}
