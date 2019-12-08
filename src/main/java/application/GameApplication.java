package application;

import boardLogic.BoardFacade;
import boardLogic.BoardFacadeImpl;
import loadGameLogic.LoadGameFacade;
import loadGameLogic.LoadGameFacadeImpl;
import persistenceLogic.PersistenceFacade;
import persistenceLogic.PersistenceFacadeImpl;

public class GameApplication implements Application {
    private BoardFacade boardFacade;
    private PersistenceFacade persistenceFacade;
    private LoadGameFacade loadGameFacade;
    @Override
    public void init() {
        boardFacade = new BoardFacadeImpl(this);
        persistenceFacade = new PersistenceFacadeImpl(this);
        loadGameFacade = new LoadGameFacadeImpl(this);
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

    public PersistenceFacade getPersistenceFacade() {
        return persistenceFacade;
    }

    public void setPersistenceFacade(PersistenceFacade persistenceFacade) {
        this.persistenceFacade = persistenceFacade;
    }

    public LoadGameFacade getLoadGameFacade() {
        return loadGameFacade;
    }

    public void setLoadGameFacade(LoadGameFacade loadGameFacade) {
        this.loadGameFacade = loadGameFacade;
    }
}
