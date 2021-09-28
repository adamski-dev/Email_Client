module Email_Client {
    requires javafx.controls;
    requires javafx.fxml;

    opens Email_Client to javafx.fxml;
    exports Email_Client;
}