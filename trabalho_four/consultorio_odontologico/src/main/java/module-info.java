module consultorio{
    requires transitive javafx.graphics;
    requires javafx.controls;
    requires javafx.fxml;

    opens consultorio to javafx.fxml;
    exports consultorio;
}
