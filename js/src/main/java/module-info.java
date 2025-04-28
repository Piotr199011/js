module com.example.js {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.js to javafx.fxml;
    exports com.example.js;
}