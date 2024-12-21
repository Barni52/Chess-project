package pieces;

import java.util.ArrayList;

import board.Board;
import move.Move;

public abstract class Piece {
    final protected boolean color;

    public Piece(boolean color) {
        this.color = color;
    }

    public String toString() {
        return "ERROR";
    }

    public abstract ArrayList<Move> move(Board board, int x, int y);

}
