package loadGameLogic;

import application.GameApplication;
import model.Board;
import model.Game;

import java.util.List;
import java.util.Scanner;

public class LoadGameFacadeImpl implements LoadGameFacade {
    GameApplication application;
    Boolean isOpened = true;
    List<Game> games;
    Board latestLoadedBoard;

    public LoadGameFacadeImpl(GameApplication application) {
        this.application = application;
    }

    @Override
    public void menu() {
        System.out.println("Load from menu");
        application.getPersistenceFacade().findAll().stream().forEach(System.out::println);
        games = application.getPersistenceFacade().findAll();
        System.out.println("Type id of the game you want to load");
        int id = new Scanner(System.in).nextInt();
        Board newBoard = null;
        for (Game game : games) {
            if (game.getId() == id) {
                newBoard = application.getPersistenceFacade().unparseGameIntoBoard(game.getGame());
                latestLoadedBoard = newBoard;
            }
        }
        isOpened = false;
    }

    @Override
    public boolean isOpened() {
        return isOpened;
    }

    public Board getLatestLoadedBoard() {
        return latestLoadedBoard;
    }

    public void setLatestLoadedBoard(Board latestLoadedBoard) {
        this.latestLoadedBoard = latestLoadedBoard;
    }
}
