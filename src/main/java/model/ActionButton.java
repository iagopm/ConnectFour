package model;

import javafx.scene.control.Button;

public class ActionButton extends Button {
    private int column;

    public ActionButton(int column) {
        this.column = column;
        this.setPrefSize(Double.MAX_VALUE, Double.MAX_VALUE);

    }

    public int getColumn() {
        return column;
    }

    public void setColumn(int column) {
        this.column = column;
    }
}
