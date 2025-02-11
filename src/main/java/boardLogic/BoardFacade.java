package boardLogic;

import model.Board;
import model.Chip;

import java.util.List;

public interface BoardFacade {
    void initBoard(Board oldBoard);

    void placeChip(Integer column) throws Exception;

    boolean checkColumnIsFull(Integer column);

    Chip calculateLastPosToPlace(List<Chip> chipsToIterateOn);

    void printChip(Chip chipToPrint);

    int[][] createBidiArray(Board board);

    List<Chip> getColumn(int column);

    boolean checkEnd(int player);

    List<Chip> getRow(int i);

    int getColumnCount();

    int getRowCount();

    void refreshGui();

    int getCurrentPlayer();

    void setCurrentPlayer(int currentPlayer);
}
