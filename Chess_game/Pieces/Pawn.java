package pieces;

import java.util.ArrayList;

import board.Board;
import move.Move;

public class Pawn extends Piece{
    public Pawn(boolean color) {
        super(color);
    }

    public String toString() {
        return "[P" + (color ? "W" : "B") + "]";
    }

    public int getValue(){
        return 1;
    }

    public  ArrayList<Move> move(Board board, int x, int y){
        ArrayList<Move> possibleMoves = new ArrayList<>();
        Piece[][] chessBoard = board.chessBoard;

        int direction = color ? -1 : 1; // White moves up (-1), Black moves down (+1)
        int startingRank = color ? 6 : 1; // Starting rank for white and black pawns

        // Forward move (1 square)
        if (isValidMove(x + direction, y) && chessBoard[x + direction][y] instanceof noPiece) {
            possibleMoves.add(new Move(x, y, x + direction, y, false));

            // Forward move (2 squares) from starting position
            if (x == startingRank && chessBoard[x + direction * 2][y] instanceof noPiece) {
                possibleMoves.add(new Move(x, y, x + direction * 2, y, false));
            }
        }

        // Capture diagonally (left and right)
        if (isValidMove(x + direction, y - 1) && !(chessBoard[x + direction][y - 1] instanceof noPiece)) {
            Piece targetPiece = chessBoard[x + direction][y - 1];
            if (targetPiece.color != this.color) {
                possibleMoves.add(new Move(x, y, x + direction, y - 1, false));
            }
        }
        if (isValidMove(x + direction, y + 1) && !(chessBoard[x + direction][y + 1] instanceof noPiece)) {
            Piece targetPiece = chessBoard[x + direction][y + 1];
            if (targetPiece.color != this.color) {
                possibleMoves.add(new Move(x, y, x + direction, y + 1, false));
            }
        }

        return possibleMoves;
    };
}
