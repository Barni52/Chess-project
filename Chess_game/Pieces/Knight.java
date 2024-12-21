package pieces;

import java.util.ArrayList;

import board.Board;
import move.Move;

public class Knight extends Piece{
    public Knight(boolean color) {
        super(color);
    }

    public String toString() {
        return "[N" + (color ? "W" : "B") + "]";
    }

    public  ArrayList<Move> move(Board board, int x, int y){
        ArrayList<Move> possibleMoves = new ArrayList<>();


        return possibleMoves;
    };
}
