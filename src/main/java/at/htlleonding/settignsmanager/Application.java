package at.htlleonding.settignsmanager;

import at.htlleonding.settignsmanager.controller.AppController;
import javafx.stage.Stage;

import java.io.IOException;

public class Application extends javafx.application.Application {
    @Override
    public void start(Stage stage) throws IOException {
        //singelton
        AppController.getInstance().initialize(stage);
    }
}