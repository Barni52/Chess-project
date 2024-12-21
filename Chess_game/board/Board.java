package board;

import java.util.ArrayList;

import move.Move;
import pieces.Bishop;
import pieces.King;
import pieces.Knight;
import pieces.Pawn;
import pieces.Piece;
import pieces.Queen;
import pieces.Rook;
import pieces.noPiece;


public class Board {
    // DEFS
    final static private boolean BLACK = false;
    final static private boolean WHITE = true;
    //

    public Piece[][] chessBoard;
    private int blackValue = 39;
    private int whiteValue = 39;

    public Board(Piece[][] chessBoard) {
        this.chessBoard = chessBoard;
    }
    
    public Board() {
        chessBoard = new Piece[8][8];

        chessBoard[0][0] = new Rook(BLACK);
        chessBoard[0][1] = new Knight(BLACK);
        chessBoard[0][2] = new Bishop(BLACK);
        chessBoard[0][3] = new Queen(BLACK);
        chessBoard[0][4] = new King(BLACK);
        chessBoard[0][5] = new Bishop(BLACK);
        chessBoard[0][6] = new Knight(BLACK);
        chessBoard[0][7] = new Rook(BLACK);
        for (int i = 0; i < 8; i++) {
            chessBoard[1][i] = new Pawn(BLACK);
        }

        // Place white pieces
        chessBoard[7][0] = new Rook(WHITE);
        chessBoard[7][1] = new Knight(WHITE);
        chessBoard[7][2] = new Bishop(WHITE);
        chessBoard[7][3] = new Queen(WHITE);
        chessBoard[7][4] = new King(WHITE);
        chessBoard[7][5] = new Bishop(WHITE);
        chessBoard[7][6] = new Knight(WHITE);
        chessBoard[7][7] = new Rook(WHITE);
        for (int i = 0; i < 8; i++) {
            chessBoard[6][i] = new Pawn(WHITE);
        }

        // Remaining squares are null
        for (int i = 2; i < 6; i++) {
            for (int j = 0; j < 8; j++) {
                chessBoard[i][j] = new noPiece(false);
            }
        }

        // TEST
            chessBoard[6][0] = new noPiece(false);
        // TEST
    }

    public void printBoard(){
        for(int i = 0; i < chessBoard.length; i++){
            for(int k = 0; k < chessBoard[i].length; k++){
                System.out.print(chessBoard[i][k]);
            }
            System.out.println();
        }
    }

    public ArrayList<Move> getPossibleMoves(){
        ArrayList<Move> possibleMoves = new ArrayList<>();
        for(int i = 0; i < chessBoard.length; i++){
            for(int y = 0; y < chessBoard[i].length; y++){
                if(!(chessBoard[i][y] instanceof noPiece)){
                    possibleMoves.addAll(chessBoard[i][y].move(this, i, y));
                }
            }
        }
        return possibleMoves;
    }
}
