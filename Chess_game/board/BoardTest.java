package board;

import java.util.ArrayList;

import move.Move;
import pieces.noPiece;
import pieces.Pawn;
import pieces.King;

public class BoardTest {
    public static ArrayList<Move> getPossibleMoves(Board testBoard){
        ArrayList<Move> possibleMoves = new ArrayList<>();
        for(int i = 0; i < testBoard.chessBoard.length; i++){
            for(int y = 0; y < testBoard.chessBoard[i].length; y++){
                if(!(testBoard.chessBoard[i][y] instanceof noPiece)){
                    if(testBoard.chessBoard[i][y] instanceof King){
                        possibleMoves.addAll(testBoard.chessBoard[i][y].move(testBoard, i, y));
                    }
                }
            }
        }
        return possibleMoves;
    }
}
