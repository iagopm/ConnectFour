package persistenceLogic;

import model.Board;
import model.Game;

import java.util.List;

public interface PersistenceFacade {
    List<Game> findAll();

    void insertGame(String game);

    String parseGameIntoString(Board board);

    Board unparseGameIntoBoard(String unparsedBoard);
}
