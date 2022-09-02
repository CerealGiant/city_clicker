module com.example.city_clicker {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.city_clicker to javafx.fxml;
    exports com.example.city_clicker;
}