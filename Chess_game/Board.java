import java.net.Socket;

import Pieces.Bishop;
import Pieces.King;
import Pieces.Knight;
import Pieces.Pawn;
import Pieces.Piece;
import Pieces.Queen;
import Pieces.Rook;
import Pieces.noPiece;

public class Board {
    // DEFS
    final private boolean BLACK = false;
    final private boolean WHITE = true;

    //
    private Piece[][] chessBoard;
    private int blackValue = 0;
    private int whiteValue = 0;

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
    }

    public void printBoard(){
        for(int i = 0; i < chessBoard.length; i++){
            for(int k = 0; k < chessBoard[i].length; k++){
                System.out.print(chessBoard[i][k]);
            }
            System.out.println();
        }
    }
}
