package pieces;

import java.util.ArrayList;

import board.Board;
import move.Move;

public class noPiece extends Piece{
    public noPiece(boolean color) {
        super(color);
    }

    public String toString() {
        return "[  ]";
    }

    public  ArrayList<Move> move(Board board, int x, int y){
        ArrayList<Move> possibleMoves = new ArrayList<>();


        return possibleMoves;
    };
}
