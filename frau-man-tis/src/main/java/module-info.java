module at.htlleonding.fraumantis {
    requires javafx.controls;
    requires javafx.fxml;


    opens at.htlleonding.fraumantis to javafx.fxml;
    exports at.htlleonding.fraumantis;
}