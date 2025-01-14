package pieces;

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
        Piece[][] chessBoard = board.chessBoard;

        for (int i = x - 1; i >= 0; i--) {
            if (addMove(possibleMoves, chessBoard, x, y, i, y)) break;
        }
        
        // Move down
        for (int i = x + 1; i < 8; i++) {
            if (addMove(possibleMoves, chessBoard, x, y, i, y)) break;
        }
        
        // Move left
        for (int j = y - 1; j >= 0; j--) {
            if (addMove(possibleMoves, chessBoard, x, y, x, j)) break;
        }
        
        // Move right
        for (int j = y + 1; j < 8; j++) {
            if (addMove(possibleMoves, chessBoard, x, y, x, j)) break;
        }

        // Move up-right
        int i = x - 1;
        int j = y + 1;

        while(i >= 0 && j < 8){
            if (addMove(possibleMoves, chessBoard, x, y, i, j)) break;
            i--;
            j++;
        }

        //Move up-left
        i = x - 1;
        j = y - 1;
        while(i >= 0 && j >= 0){
            if (addMove(possibleMoves, chessBoard, x, y, i, j)) break;
            i--;
            j--;
        }

        //Move down-right
        i = x + 1;
        j = y + 1;
        while(i < 8 && j < 8){
            if (addMove(possibleMoves, chessBoard, x, y, i, j)) break;
            i++;
            j++;
        }

        //Move down-left
        i = x + 1;
        j = y - 1;
        while(i < 8 && j >= 0){
            if (addMove(possibleMoves, chessBoard, x, y, i, j)) break;
            i++;
            j--;
        }

        return possibleMoves;
    };
}
