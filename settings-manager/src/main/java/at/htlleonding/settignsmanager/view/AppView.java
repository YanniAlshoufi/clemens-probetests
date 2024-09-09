package at.htlleonding.settignsmanager.view;

import javafx.scene.control.Alert;
import javafx.stage.Stage;

import java.io.IOException;

public class AppView {
    private static AppView mAppView;

    private AppView(){

    }

    public static AppView getInstance() {
        if(mAppView == null) {
            mAppView = new AppView();
        }

        return mAppView;
    }

    public void initialize(Stage stage) throws IOException {
        ViewHelper.showView(stage, ViewId.APP_VIEW, null);
    }

    public void showException(Exception e) {
        Alert alert = new Alert(Alert.AlertType.ERROR);

        alert.setTitle("Error");
        alert.setContentText(e.getMessage());
        alert.showAndWait();
    }
}
