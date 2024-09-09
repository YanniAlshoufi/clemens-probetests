package at.htlleonding.fraumantis.view;

import at.htlleonding.fraumantis.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;

public class ViewHelper {

    public static void showScene(Stage stage, ViewMetaData viewMetaData, Stage parentStage) throws IOException {

        FXMLLoader fxmlLoader = new FXMLLoader(Application.class.getResource(viewMetaData.getNameOfFile()));
        Scene scene = new Scene(fxmlLoader.load(), viewMetaData.getHeight(), viewMetaData.getWidth());

        if(parentStage != null) {
            stage.initModality(Modality.WINDOW_MODAL);
            stage.initOwner(parentStage);
        }

        stage.setTitle(viewMetaData.getTitle());
        stage.setScene(scene);
        stage.show();
    }
}
