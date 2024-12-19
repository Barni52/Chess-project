package Pieces;

import java.util.ArrayList;

import board.Board;
import move.Move;

public class Bishop extends Piece{
    public Bishop(boolean color) {
        super(color);
    }

    public String toString() {
        return "[B" + (color ? "W" : "B") + "]";
    }

    public  ArrayList<Move> move(Board board, int x, int y){
        ArrayList<Move> possibleMoves = new ArrayList<>();


        return possibleMoves;
    };

    
}
