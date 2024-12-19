package Pieces;

import java.util.ArrayList;

import board.Board;
import move.Move;

public class Pawn extends Piece{
    private boolean moved = false;
    
    public boolean isMoved() {
        return moved;
    }

    public void setMoved(boolean moved) {
        this.moved = moved;
    }

    public Pawn(boolean color) {
        super(color);
    }

    public String toString() {
        return "[P" + (color ? "W" : "B") + "]";
    }

    public  ArrayList<Move> move(Board board, int x, int y){
        ArrayList<Move> possibleMoves = new ArrayList<>();


        return possibleMoves;
    };
}
