module unit05 {
    requires transitive javafx.graphics;
    requires transitive javafx.controls;
    requires javafx.fxml;
    requires transitive javafx.media;

    opens unit05 to javafx.fxml;
    exports unit05;
    exports unit05.hilo.model;
    exports unit05.hilo.view;
}
