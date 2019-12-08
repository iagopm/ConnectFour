package application;

import javafx.stage.Stage;

public interface Application {
    void init();

    void restart() throws Exception;

    void close();

    void setStage(Stage primaryStage);
}
