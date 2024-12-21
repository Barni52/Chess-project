package pieces;

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

    public ArrayList<Move> move(Board board, int x, int y) {
        ArrayList<Move> possibleMoves = new ArrayList<>();
        Piece[][] chessBoard = board.chessBoard;

        // Move up-right
        int i = x - 1;
        int j = y + 1;

        while(i >= 0 && y < 8){
            if (addMove(possibleMoves, chessBoard, x, y, i, j)) break;
            i--;
            j++;
        }

        //Move up-left
        
        i = x - 1;
        j = y - 1;

        while(i >= 0 && y >= 0){
            if (addMove(possibleMoves, chessBoard, x, y, i, j)) break;
            i--;
            j--;
        }

        //Move down-right
        
        i = x + 1;
        j = y + 1;

        while(i < 8 && y < 8){
            if (addMove(possibleMoves, chessBoard, x, y, i, j)) break;
            i++;
            j++;
        }

        //Move down-left
        
        i = x + 1;
        j = y - 1;

        while(i < 8 && y >= 0){
            if (addMove(possibleMoves, chessBoard, x, y, i, j)) break;
            i++;
            j--;
        }

        return possibleMoves;
    }
    
}
