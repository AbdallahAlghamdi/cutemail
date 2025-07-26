package io.github.abdallahalghamdi.maillist;

import javafx.scene.layout.Region;

public class Controller {
    private final Model model;
    private final View view;

    public Controller(){
        model = new Model();
        view = new View(model);
    }

    public Region getView(){
        return view.getView();
    }
}
