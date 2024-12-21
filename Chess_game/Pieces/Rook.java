package pieces;

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

    public ArrayList<Move> move(Board board, int x, int y) {
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

        return possibleMoves;
    }

    
}
