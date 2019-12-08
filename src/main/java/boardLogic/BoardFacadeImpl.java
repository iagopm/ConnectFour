package boardLogic;

import application.GameApplication;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.paint.Color;
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
        //comprobar vertical
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
        //comprobar diagonal

        return false;
    }

    @Override
    public List<Chip> getColumn(int i) {
        List<Chip> chips = new ArrayList<>();
        Node result = null;
        ObservableList<Node> childrens = board.getChildren();
        for (Node node : childrens) {
            if (board.getColumnIndex(node) == i) {
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
            chipToPrint.setText("" + currentPlayer);
            chipToPrint.setBackground(new Background(new BackgroundFill(Color.BLUE, CornerRadii.EMPTY, Insets.EMPTY)));
            currentPlayer = 2;
        } else if (currentPlayer == 2) {
            chipToPrint.setOccupiedByPlayer(currentPlayer);
            chipToPrint.setText("" + currentPlayer);
            chipToPrint.setBackground(new Background(new BackgroundFill(Color.RED, CornerRadii.EMPTY, Insets.EMPTY)));
            currentPlayer = 1;
        }
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
                chip.setBackground(new Background(new BackgroundFill(Color.BLUE, CornerRadii.EMPTY, Insets.EMPTY)));
            } else if (chip.getOccupiedByPlayer() == 2) {
                chip.setBackground(new Background(new BackgroundFill(Color.RED, CornerRadii.EMPTY, Insets.EMPTY)));
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
