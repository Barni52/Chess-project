package pieces;

import java.util.ArrayList;

import board.Board;
import move.Move;

public class King extends Piece{

    public King(boolean color) {
        super(color);
    }

    public String toString() {
        return "[K" + (color ? "W" : "B") + "]";
    }


    public  ArrayList<Move> move(Board board, int x, int y){
        ArrayList<Move> possibleMoves = new ArrayList<>();


        return possibleMoves;
    };
    
}
