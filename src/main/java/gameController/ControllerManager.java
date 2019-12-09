package gameController;

import javafx.event.ActionEvent;

public interface ControllerManager {

    void start(ActionEvent actionEvent);

    void save(ActionEvent actionEvent);

    void load(ActionEvent actionEvent);

    void restart(ActionEvent actionEvent) throws Exception;
}
