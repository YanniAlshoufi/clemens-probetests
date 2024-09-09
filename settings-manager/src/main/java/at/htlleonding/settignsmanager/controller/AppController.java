package at.htlleonding.settignsmanager.controller;

import at.htlleonding.settignsmanager.domain.models.Property;
import at.htlleonding.settignsmanager.domain.models.Setting;
import at.htlleonding.settignsmanager.domain.repositories.AppRepository;
import at.htlleonding.settignsmanager.view.AppView;
import javafx.stage.Stage;

import java.io.IOException;


public class AppController {

    private static AppController mAppController;

    private AppController(){
    }

    public static AppController getInstance() {
        if(mAppController == null) {
            mAppController = new AppController();
        }

        return mAppController;
    }

    public void addProperty(Setting setting, String name, String value) {
        AppRepository.getInstance().addProperty(setting, new Property(name, value));
    }

    public void removeProperty(Setting setting, Property property) {
        AppRepository.getInstance().deleteProperty(setting, property);
    }

    public void initialize(Stage stage) throws IOException {
        AppRepository.getInstance().initialize();
        AppView.getInstance().initialize(stage);
    }

    public void handleException(Exception e) {
        AppView.getInstance().showException(e);
    }
}
