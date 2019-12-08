package model;

import javafx.scene.control.Button;
import sun.security.util.Resources;

import java.util.ResourceBundle;

public class Chip extends Button {
    ResourceBundle bundle = Resources.getBundle("game");
    private int column;
    private int row;
    private int occupiedByPlayer;

    public Chip(int column, int row, int occupiedByPlayer) {
        this.column = column;
        this.row = row;
        this.occupiedByPlayer = occupiedByPlayer;
        this.setPrefSize(Double.MAX_VALUE, Double.MAX_VALUE);
        this.setStyle(
                "-fx-background-radius: 50px; " +
                        "-fx-min-width: 50px;" +
                        "-fx-min-height: 50px; " +
                        "-fx-max-width: 50px;" +
                        "-fx-max-height: 50px;"
        );
    }

    public void setBackgroundColor(int color) {
        String hexCodeForColour;
        if (color == 1) {
            hexCodeForColour = bundle.getString("playerOneColor");
        } else {
            hexCodeForColour = bundle.getString("playerTwoColor");
        }
        this.setStyle("-fx-background-radius: 50px; " +
                "-fx-min-width: 50px;" +
                "-fx-min-height: 50px; " +
                "-fx-max-width: 50px;" +
                "-fx-max-height: 50px;" +
                "-fx-background-color: " + hexCodeForColour);
    }

    public int getColumn() {
        return column;
    }

    public void setColumn(int column) {
        this.column = column;
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getOccupiedByPlayer() {
        return occupiedByPlayer;
    }

    public void setOccupiedByPlayer(int occupiedByPlayer) {
        this.occupiedByPlayer = occupiedByPlayer;
    }

    @Override
    public String toString() {
        return "Chip{" +
                "column=" + column +
                ", row=" + row +
                ", occupiedByPlayer=" + occupiedByPlayer +
                '}';
    }


}
