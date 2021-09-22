module com.example.anotaai {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.anotaai to javafx.fxml;
    exports com.example.anotaai;
}