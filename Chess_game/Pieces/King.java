package pieces;

import java.util.ArrayList;

import board.Board;
import move.Move;

public class King extends Piece{

    public King(boolean color) {
        super(color);
    }

    public String toString() {
        return "[K" + (color ? "W" : "B") + "]";
    }

    public int getValue(){
        return 0;
    }


    public  ArrayList<Move> move(Board board, int x, int y){
        ArrayList<Move> possibleMoves = new ArrayList<>();
        Piece[][] chessBoard = board.chessBoard;

        // All possible relative moves for the king
        int[][] kingMoves = {
            {-1, -1}, {-1, 0}, {-1, 1}, // Top-left, Top, Top-right
            {0, -1},         {0, 1},   // Left,        Right
            {1, -1}, {1, 0}, {1, 1}    // Bottom-left, Bottom, Bottom-right
        };

        for (int[] move : kingMoves) {
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
        addCastlingMoves(possibleMoves, board, x, y);

        return possibleMoves;
    };

    private void addCastlingMoves(ArrayList<Move> possibleMoves, Board board, int x, int y) {
        if (this.hasMoved) return;

        //Piece[][] chessBoard = board.chessBoard;
        if(color == Board.BLACK){
            // Check for black kingside castling
            if (isCastlingPossible(board, x, y, 0, 7, 5, 6)) {
                possibleMoves.add(new Move(x, y, x, y + 2, false, true));
            }

            // Check for black queenside castling
            if (isCastlingPossible(board, x, y, 0, 0, 1, 2, 3)) {
                possibleMoves.add(new Move(x, y, x, y - 2, false, true));
            }
        }

        if(color == Board.WHITE){
            // Check for black kingside castling
            if (isCastlingPossible(board, x, y, 7, 7, 5, 6)) {
                possibleMoves.add(new Move(x, y, x, y + 2, false, true));
            }

            // Check for black queenside castling
            if (isCastlingPossible(board, x, y, 7, 0, 1, 2, 3)) {
                possibleMoves.add(new Move(x, y, x, y - 2, false, true));
            }
        }
    }

    private boolean isCastlingPossible(Board board, int kingX, int kingY, int rookX, int rookY, int... pathSquares) {
        Piece[][] chessBoard = board.chessBoard;

        if (!(chessBoard[rookX][rookY] instanceof Rook)) return false;
        Rook rook = (Rook) chessBoard[rookX][rookY];
        if (rook.hasMoved || rook.color != this.color) return false;
        
        for (int i : pathSquares) {
            if (!(chessBoard[kingX][i] instanceof noPiece)) return false;
        }
        /* TODO
            NEED A WAY TO CHECK IF THE SQUARE IS UNDER ATTACK!!!!! I AM A LAZY FUCK xoxo :3
        for (int i : pathSquares) {
            if (board.isSquareUnderAttack(kingX, i, this.color)) return false;
        }
        */

        return true;
    }
    
}
