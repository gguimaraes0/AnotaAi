module com.example.anotaai {
    requires javafx.controls;
    requires javafx.fxml;
    requires javax.persistence;


    opens com.example.anotaai to javafx.fxml;
    exports com.example.anotaai;
}