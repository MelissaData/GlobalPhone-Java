module com.melissadata.globalphone {
    requires javafx.controls;
    requires javafx.fxml;
    requires transitive javafx.graphics;
    requires com.google.gson;
    requires jdk.crypto.ec;

    opens com.melissadata.globalphone to javafx.fxml;
    opens com.melissadata.globalphone.model to javafx.fxml;
    opens com.melissadata.globalphone.view to javafx.fxml;
    exports com.melissadata.globalphone;
}
