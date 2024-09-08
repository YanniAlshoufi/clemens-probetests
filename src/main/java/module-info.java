module at.htlleonding.settignsmanager {
    requires javafx.controls;
    requires javafx.fxml;


    opens at.htlleonding.settignsmanager to javafx.fxml;
    exports at.htlleonding.settignsmanager;
    exports at.htlleonding.settignsmanager.view;
    opens at.htlleonding.settignsmanager.view to javafx.fxml;
}