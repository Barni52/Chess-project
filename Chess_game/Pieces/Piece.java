package pieces;

import java.util.ArrayList;

import board.Board;
import move.Move;

public abstract class Piece {
    final protected boolean color;

    public boolean getColor() {
        return color;
    }

    protected boolean hasMoved = false;

    public boolean hasMoved() {
        return hasMoved;
    }

    public void setHasMoved(boolean hasMoved) {
        this.hasMoved = hasMoved;
    }

    public Piece(boolean color) {
        this.color = color;
    }

    public String toString() {
        return "ERROR";
    }

    public abstract ArrayList<Move> move(Board board, int x, int y);

    protected boolean addMove(ArrayList<Move> possibleMoves, Piece[][] chessBoard, int fromX, int fromY, int toX, int toY) {
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

    protected boolean isValidMove(int x, int y) {
        return x >= 0 && x < 8 && y >= 0 && y < 8;
    }

}
