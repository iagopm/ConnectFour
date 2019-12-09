package boardLogic;

import application.GameApplication;
import javafx.collections.ObservableList;
import javafx.scene.Node;
import model.Board;
import model.Chip;
import sun.security.util.Resources;

import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class BoardFacadeImpl implements BoardFacade {
    public static ResourceBundle bundle = Resources.getBundle("game");
    private GameApplication application;

    private final int column = Integer.parseInt(bundle.getString("column"));
    private final int row = Integer.parseInt(bundle.getString("row"));
    private Board board;
    private int currentPlayer = 1;

    private List<Chip> chipsToIterateOn;

    public BoardFacadeImpl(GameApplication application) {
        this.application = application;
    }

    @Override
    public void initBoard(Board oldBoard) {
        this.board = oldBoard;
    }

    @Override
    public void placeChip(Integer column) throws Exception {
        if (!checkColumnIsFull(column)) {
            Chip chipToPrint = calculateLastPosToPlace(chipsToIterateOn);
            //   System.out.println("chip to print " + chipToPrint);
            printChip(chipToPrint);
            checkEnd(currentPlayer);
            if (checkEnd(currentPlayer)) {
                System.out.println("Wins " + currentPlayer);
                application.restart();
            }
            if (currentPlayer == 1) {
                if (checkEnd(2)) {
                    System.out.println("Wins 2");
                    application.restart();
                }
            } else {
                if (checkEnd(1)) {
                    System.out.println("Wins 1");
                    application.restart();
                }
            }
        }
    }

    @Override
    public boolean checkEnd(int player) {
        int count = 0;
        for (int currentColumn = 0; currentColumn < column; currentColumn++) {
            for (int c = 0; c < row; c++) {
                List<Chip> chipsInColumn = getColumn(currentColumn);
                for (Chip chip : chipsInColumn) {
                    if (chip.getOccupiedByPlayer() == player) {
                        count++;
                    } else {
                        count = 0;
                    }
                    if (count >= 4) {
                        return true;
                    }
                }
            }
        }
        for (int currentRow = 0; currentRow < row; currentRow++) {
            for (int c = 0; c < row; c++) {
                List<Chip> chipsInColumn = getRow(currentRow);
                for (Chip chip : chipsInColumn) {
                    if (chip.getOccupiedByPlayer() == player) {
                        count++;
                    } else {
                        count = 0;
                    }
                    if (count >= 4) {
                        return true;
                    }
                }

            }
        }
        int[][] array = createBidiArray(board);
        for (int i = 3; i < getColumnCount(); i++) {
            for (int j = 0; j < getRowCount() - 3; j++) {
                if (array[i][j] == player && array[i - 1][j + 1] == player && array[i - 2][j + 2] == player && array[i - 3][j + 3] == player)
                    return true;
            }
        }
        for (int i = 3; i < getColumnCount(); i++) {
            for (int j = 3; j < getRowCount(); j++) {
                if (array[i][j] == player && array[i - 1][j - 1] == player && array[i - 2][j - 2] == player && array[i - 3][j - 3] == player)
                    return true;
            }
        }

        return false;
    }

    @Override
    public int[][] createBidiArray(Board board) {
        int bidiArray[][] = new int[getColumnCount()][getRowCount()];
        for (int c = 0; c < getColumnCount(); c++) {
            List<Chip> columnChip = getColumn(c);
            for (Chip chip : columnChip) {
                bidiArray[chip.getColumn()][chip.getRow()] = chip.getOccupiedByPlayer();
            }
        }
        return bidiArray;
    }

    @Override
    public List<Chip> getColumn(int column) {
        List<Chip> chips = new ArrayList<>();
        Node result = null;
        ObservableList<Node> childrens = board.getChildren();
        for (Node node : childrens) {
            if (board.getColumnIndex(node) == column) {
                result = node;
                Chip chip = (Chip) result;
                chips.add(chip);
            }
        }
        return chips;
    }

    @Override
    public List<Chip> getRow(int i) {
        List<Chip> chips = new ArrayList<>();
        Node result = null;
        ObservableList<Node> childrens = board.getChildren();
        for (Node node : childrens) {
            if (board.getRowIndex(node) == i) {
                result = node;
                Chip chip = (Chip) result;
                chips.add(chip);
            }
        }
        return chips;
    }


    @Override
    public void printChip(Chip chipToPrint) {
        if (currentPlayer == 1) {
            chipToPrint.setOccupiedByPlayer(currentPlayer);
            chipToPrint.setBackgroundColor(1);
            currentPlayer = 2;
        } else if (currentPlayer == 2) {
            chipToPrint.setOccupiedByPlayer(currentPlayer);
            chipToPrint.setBackgroundColor(2);
            currentPlayer = 1;
        }
        application.getAnimationFacade().animate(chipToPrint);
    }

    @Override
    public Chip calculateLastPosToPlace(List<Chip> chipsToIterateOn) {
        for (int i = chipsToIterateOn.size() - 1; i >= 0; i--) {
            if (chipsToIterateOn.get(i).getOccupiedByPlayer() == 0) {
                return chipsToIterateOn.get(i);
            }
        }
        return null;
    }

    @Override
    public boolean checkColumnIsFull(Integer column) {
        chipsToIterateOn = new ArrayList<>();
        Node result;
        ObservableList<Node> childrens = board.getChildren();
        for (Node node : childrens) {
            if (board.getColumnIndex(node) == column) {
                result = node;
                Chip chip = (Chip) result;
                if (chip.getOccupiedByPlayer() == 0) {
                    chipsToIterateOn.add(chip);
                }
            }
        }
        if (!chipsToIterateOn.isEmpty()) {
            return false;
        }
        return true;
    }

    @Override
    public int getColumnCount() {
        return column;
    }

    @Override
    public int getRowCount() {
        return row;
    }

    @Override
    public void refreshGui() {
        for (int y = 0; y < column; y++) {
            List<Chip> column = getColumn(y);
            for (Chip chip : column) {
                refreshChip(chip);
            }
        }

    }

    private void refreshChip(Chip chip) {
        if (chip.getOccupiedByPlayer() != 0) {
            if (chip.getOccupiedByPlayer() == 1) {
                chip.setBackgroundColor(1);
            } else if (chip.getOccupiedByPlayer() == 2) {
                chip.setBackgroundColor(2);
            }
        }
    }

    @Override
    public int getCurrentPlayer() {
        return currentPlayer;
    }

    @Override
    public void setCurrentPlayer(int currentPlayer) {
        this.currentPlayer = currentPlayer;
    }
}
