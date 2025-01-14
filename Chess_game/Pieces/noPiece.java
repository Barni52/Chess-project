package pieces;

import java.util.ArrayList;

import board.Board;
import move.Move;

public class noPiece extends Piece{
    private static noPiece singleNoPiece = null;

    private noPiece(boolean color) {
        super(color);
    }

    public String toString() {
        return "[  ]";
    }

    public  ArrayList<Move> move(Board board, int x, int y){
        ArrayList<Move> possibleMoves = new ArrayList<>();


        return possibleMoves;
    };

    public static noPiece getNoPieceInstance()
    {
        if (singleNoPiece == null)
            singleNoPiece = new noPiece(false);
 
        return singleNoPiece;
    }
}
