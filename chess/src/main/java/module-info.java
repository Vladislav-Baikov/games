module chess {
    requires javafx.fxml;
    requires javafx.controls;
    //opens sample;
    opens ru.job4j.chess to javafx.fxml;
    exports ru.job4j.chess;
}