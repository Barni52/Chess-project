package Pieces;

import java.util.ArrayList;

import board.Board;
import move.Move;

public class Rook extends Piece{
    public Rook(boolean color) {
        super(color);
    }

    public String toString() {
        return "[R" + (color ? "W" : "B") + "]";
    }

    public  ArrayList<Move> move(Board board, int x, int y){
        ArrayList<Move> possibleMoves = new ArrayList<>();


        return possibleMoves;
    };
}
