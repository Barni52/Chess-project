package Pieces;

import java.util.ArrayList;

import board.Board;
import move.Move;

public class Queen extends Piece{
    public Queen(boolean color) {
        super(color);
    }

    public String toString() {
        return "[Q" + (color ? "W" : "B") + "]";
    }

    public  ArrayList<Move> move(Board board, int x, int y){
        ArrayList<Move> possibleMoves = new ArrayList<>();


        return possibleMoves;
    };
}
