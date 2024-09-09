module at.htlleonding.fraumantis {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires java.desktop;


    opens at.htlleonding.fraumantis to javafx.fxml;
    exports at.htlleonding.fraumantis;
    exports at.htlleonding.fraumantis.view;
    opens at.htlleonding.fraumantis.view to javafx.fxml;
    opens at.htlleonding.fraumantis.model to javafx.base;
}