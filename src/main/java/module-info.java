module at.htlleonding.settignsmanager {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;
    requires com.h2database;
    requires java.sql;


    opens at.htlleonding.settignsmanager to javafx.fxml;
    exports at.htlleonding.settignsmanager;
    exports at.htlleonding.settignsmanager.view;
    opens at.htlleonding.settignsmanager.view to javafx.fxml;
    opens at.htlleonding.settignsmanager.domain.models to javafx.base;
}