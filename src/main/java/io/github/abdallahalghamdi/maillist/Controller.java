package io.github.abdallahalghamdi.maillist;

import javafx.scene.layout.Region;

public class Controller {
    private Model model;
    private View view;

    public Controller(){
        model = new Model();
        view = new View();
    }

    public Region getView(){
        return view.build();
    }
}
