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

        // Move up
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

    private boolean addMove(ArrayList<Move> possibleMoves, Piece[][] chessBoard, int fromX, int fromY, int toX, int toY) {
        Piece targetPiece = chessBoard[toX][toY];

        if (targetPiece instanceof noPiece) {
            possibleMoves.add(new Move(fromX, fromY, toX, toY, false));
            return false;
        } else if (targetPiece.color != this.color) {
            possibleMoves.add(new Move(fromX, fromY, toX, toY, false));
            return true;
        } else {
            return true;
        }
    }
}
