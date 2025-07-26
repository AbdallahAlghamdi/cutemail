package io.github.abdallahalghamdi.maillist;

import javafx.scene.layout.Region;

public class Controller {
    private final View view;
    private final Interactor interactor;

    public Controller() {
        Model model = new Model();
        interactor = new Interactor(model);

        view = new View(model);
    }

    public Region getView() {
        return view.getView();
    }
}
