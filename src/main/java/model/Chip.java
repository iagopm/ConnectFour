package model;

import javafx.scene.control.Button;
import javafx.scene.paint.Color;

public class Chip extends Button {
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

    public void setBackgroundColor(Color color) {
        String hexCodeForColour;
        if (color == Color.BLUE) {
            hexCodeForColour = "#2969c0";
        } else {
            hexCodeForColour = "#ff0000";
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
