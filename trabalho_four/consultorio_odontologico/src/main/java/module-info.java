module consultorio{
    requires transitive javafx.graphics;
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;

    opens consultorio to javafx.fxml;
    exports consultorio;
}
