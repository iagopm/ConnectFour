package model;

import javafx.scene.control.Button;

public class Chip extends Button {
    private int column;
    private int row;
    private int occupiedByPlayer;

    public Chip(int column, int row, int occupiedByPlayer) {
        this.column = column;
        this.row = row;
        this.occupiedByPlayer = occupiedByPlayer;
        this.setPrefSize(Double.MAX_VALUE, Double.MAX_VALUE);
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
