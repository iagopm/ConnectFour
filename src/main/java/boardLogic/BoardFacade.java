package boardLogic;

import model.Board;
import model.Chip;

import java.util.List;

public interface BoardFacade {
    void initBoard(Board oldBoard);

    void placeChip(Integer column);

    boolean checkColumnIsFull(Integer column);

    Chip calculateLastPosToPlace(List<Chip> chipsToIterateOn);

    void printChip(Chip chipToPrint);

    List<Chip> getColumn(int i);

    boolean checkEnd(int player);

    List<Chip> getRow(int i);

    int getColumnCount();

    int getRowCount();

    void refreshGui();
}
