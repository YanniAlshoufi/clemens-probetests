package at.htlleonding.fraumantis.view;

import javafx.scene.control.Alert;
import javafx.stage.Stage;

import java.io.IOException;

public class AppView {

    private static AppView mInstance;

    private AppView() {
    }

    public static AppView getInstance() {
        if(mInstance == null) {
            mInstance = new AppView();
        }

        return mInstance;
    }


    public void initialize(Stage stage) throws IOException {
        ViewHelper.showScene(stage, ViewMetaData.MAIN_VIEW, null);
    }

    public void showException(Exception e) {
        Alert alert = new Alert(Alert.AlertType.ERROR);

        alert.setTitle("Error");
        alert.setContentText(e.getMessage());
        alert.showAndWait();
    }
}