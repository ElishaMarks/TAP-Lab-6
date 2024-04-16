module org.example.taplab6 {
    requires javafx.controls;
    requires javafx.fxml;


    opens org.example.taplab6 to javafx.fxml;
    exports org.example.taplab6;
}