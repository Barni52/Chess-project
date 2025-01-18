package ChessAI;

import java.nio.file.WatchEvent.Kind;
import java.util.ArrayList;
import java.util.HashMap;

import board.Board;
import move.Move;
import pieces.King;
import pieces.noPiece;

public class PositionEvaluator {

    private static final double attackMultiplier = 0.66;

    public static double getBoardValueOfPieces(boolean inputColor, Board board){
        double value = -1000;
        for(int i = 0; i < board.chessBoard.length; i++){
            for(int y = 0; y < board.chessBoard[i].length; y++){
                if(!(board.chessBoard[i][y] instanceof noPiece) && board.chessBoard[i][y].getColor() == inputColor){
                    value += board.chessBoard[i][y].getValue();
                }
            }
        }

        if(board.getColorToMove() == inputColor){
            value += hangingPiecesConsideration(inputColor, board);

        }

        return value;
    }

    public static double hangingPiecesConsideration(boolean inputColor, Board board){ // This function considers pieces that are hanging, making the deep, bad sacrifices worthless;
        double value = 0;
        ArrayList<Move> moves = board.getPossibleMoves(inputColor);
        for(Move move : moves){
            if(!(board.chessBoard[move.getToX()][move.getToY()] instanceof noPiece) && !(board.chessBoard[move.getToX()][move.getToY()] instanceof King)){
                double attackValue = board.chessBoard[move.getToX()][move.getToY()].getValue() - board.chessBoard[move.getFromX()][move.getFromY()].getValue();
                if(attackValue > 0){
                    value += attackValue * attackMultiplier;
                }
            }
        }
        
        return value;
    }

    public static double getSimpleRelativeValue(Board board){
        return getBoardValueOfPieces(Board.WHITE, board) - getBoardValueOfPieces(Board.BLACK, board);
    }
}
