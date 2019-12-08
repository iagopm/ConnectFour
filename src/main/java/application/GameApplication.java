package application;

import boardLogic.BoardFacade;
import boardLogic.BoardFacadeImpl;

public class GameApplication implements Application {
    private BoardFacade boardFacade;

    @Override
    public void init() {
        boardFacade = new BoardFacadeImpl();
    }


    @Override
    public void restart() {

    }

    @Override
    public void close() {

    }

    public BoardFacade getBoardFacade() {
        return boardFacade;
    }

    public void setBoardFacade(BoardFacade boardFacade) {
        this.boardFacade = boardFacade;
    }
}
