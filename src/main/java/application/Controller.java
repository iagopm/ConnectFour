package application;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import model.ActionButton;
import model.ActionPane;
import model.Board;
import model.Chip;
import sun.security.util.Resources;

import java.util.ResourceBundle;

public class Controller {
    public static ResourceBundle bundle = Resources.getBundle("game");
    GameApplication application;
    Boolean loaded = false;
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
        if (loaded) {
            Board boardToIterateOn = application.getLoadGameFacade().getLatestLoadedBoard();
            application.getBoardFacade().initBoard(boardToIterateOn);
            for (int c = 0; c < column; c++) {
                for (Chip chip : application
                        .getBoardFacade()
                        .getColumn(c)) {
                    boardPane.add(
                            chip,
                            chip.getColumn(),
                            chip.getRow());
                    System.out.println("cloned chip" + chip);
                }
            }
            application.getBoardFacade().initBoard(boardPane);
            application.getBoardFacade().refreshGui();
            for (int z = 0; z < column; z++) {
                ActionButton actionButton = new ActionButton(z);
                actionButton.setOnAction(event -> {
                    try {
                        application.getBoardFacade().placeChip(actionButton.getColumn());
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                });
                actionPane.add(actionButton, z, 0);
            }
        } else {

            Board newBoard = new Board();

            System.out.println("Columns " + column + " Rows " + row);
            for (int x = 0; x < row; x++) {
                for (int y = 0; y < column; y++) {
                    boardPane.add(new Chip(y, x, 0), y, x);
                    System.out.println("Chip gen on column " + y + " row " + x);
                }
            }
            application.getBoardFacade().initBoard(boardPane);

            for (int z = 0; z < column; z++) {
                ActionButton actionButton = new ActionButton(z);
                actionButton.setOnAction(event -> {
                    try {
                        application.getBoardFacade().placeChip(actionButton.getColumn());
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                });
                actionPane.add(actionButton, z, 0);
                System.out.println("Action button on column " + z);
            }
        }
    }


    public void save(ActionEvent actionEvent) {
        application.getPersistenceFacade().insertGame(application.getPersistenceFacade().parseGameIntoString(boardPane));
    }

    public void load(ActionEvent actionEvent) {
        while (application.getLoadGameFacade().isOpened()) {
            application.getLoadGameFacade().menu();
            loaded = true;
        }
    }

    public void restart(ActionEvent actionEvent) throws Exception {
        application.restart();
    }
}
