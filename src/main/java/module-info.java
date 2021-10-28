module com.example.anota6 {
    requires javafx.controls;
    requires javafx.fxml;
    requires javax.persistence;


    opens com.example.anota6 to javafx.fxml;
    exports com.example.anota6;
    exports Controllers;
    opens Controllers to javafx.fxml;
}