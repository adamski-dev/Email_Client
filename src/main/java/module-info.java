module GetMail {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;
    requires activation;
    requires java.mail;
    requires java.desktop;

    opens GetMail to javafx.fxml;
    exports GetMail;
    exports GetMail.controller;
    opens GetMail.controller to javafx.fxml;
    exports GetMail.model;
    opens GetMail.model to javafx.fxml;
    exports GetMail.view;
    opens GetMail.view to javafx.fxml;
}