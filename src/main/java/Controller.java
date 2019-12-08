import application.GameApplication;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import model.ActionPane;
import model.Board;
import model.Chip;
import sun.security.util.Resources;

import java.util.ResourceBundle;

public class Controller {
    public static ResourceBundle bundle = Resources.getBundle("game");
    GameApplication application;

    @FXML
    Board boardPane;
    @FXML
    ActionPane actionPane;

    public Controller(GameApplication application) {
        this.application = application;
    }

    public void start(ActionEvent actionEvent) {
        int column = Integer.parseInt(bundle.getString("column"));
        int row = Integer.parseInt(bundle.getString("row"));
        Board newBoard = new Board();
        System.out.println("Columns " + column + " Rows " + row);
        for (int x = 0; x < row; x++) {
            for (int y = 0; y < column; y++) {
                boardPane.add(new Chip(y, x, 0), y, x);
                System.out.println("Chip gen on column " + y + " row " + x);
            }
        }
        for (int z = 0; z < column; z++) {
            Chip chip = new Chip(z, 0, 0);
            chip.setOnAction(event -> {
                application.getBoardFacade().placeChip(chip.getColumn());
            });
            actionPane.add(chip, z, 0);
            System.out.println("Action button on column " + z);
        }
        application.getBoardFacade().initBoard((Board) boardPane);
    }
}
