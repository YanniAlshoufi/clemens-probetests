package at.htlleonding.fraumantis;

import at.htlleonding.fraumantis.controller.AppController;
import at.htlleonding.fraumantis.model.FmtTasksRepository;
import at.htlleonding.fraumantis.view.AppView;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Application extends javafx.application.Application {
    @Override
    public void start(Stage stage) throws IOException {

        // I like domain more, because it
        //
        //

        FmtTasksRepository.getInstance();
        AppController.getInstance();
        AppView.getInstance().initialize(stage);
    }

    public static void main(String[] args) {
        launch();
    }


    @Override
    public void stop() throws Exception {
        FmtTasksRepository.getInstance().closeConnection();
        super.stop();
    }
}