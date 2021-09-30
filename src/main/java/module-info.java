module GetMail {
    requires javafx.controls;
    requires javafx.fxml;

    opens GetMail to javafx.fxml;
    exports GetMail;
    //exports GetMail.view;
    //opens GetMail.view to javafx.fxml;
    exports GetMail.controller;
    opens GetMail.controller to javafx.fxml;
}