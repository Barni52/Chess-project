package pieces;

import java.util.ArrayList;

import board.Board;
import move.Move;

public class Knight extends Piece{
    public Knight(boolean color) {
        super(color);
    }

    public String toString() {
        return "[N" + (color ? "W" : "B") + "]";
    }

    public ArrayList<Move> move(Board board, int x, int y) {
        ArrayList<Move> possibleMoves = new ArrayList<>();
        Piece[][] chessBoard = board.chessBoard;

        // All possible relative moves for a knight
        int[][] knightMoves = {
            {-2, -1}, {-2, 1},  // Up-left, Up-right
            {-1, -2}, {-1, 2},  // Left-up, Right-up
            {1, -2}, {1, 2},    // Left-down, Right-down
            {2, -1}, {2, 1}     // Down-left, Down-right
        };

        for (int[] move : knightMoves) {
            int newX = x + move[0];
            int newY = y + move[1];

            // Check if the move is within board boundaries
            if (isValidMove(newX, newY)) {
                Piece targetPiece = chessBoard[newX][newY];

                // Add move if the square is empty or occupied by an opponent's piece
                if (targetPiece instanceof noPiece || targetPiece.color != this.color) {
                    possibleMoves.add(new Move(x, y, newX, newY, false));
                }
            }
        }

        return possibleMoves;
    }


    
}
