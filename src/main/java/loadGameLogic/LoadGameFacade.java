package loadGameLogic;

import model.Board;

public interface LoadGameFacade {
    void menu();

    boolean isOpened();

    Board getLatestLoadedBoard();

    void setLatestLoadedBoard(Board latestLoadedBoard);
}
