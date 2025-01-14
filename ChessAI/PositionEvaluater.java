package ChessAI;

import java.util.ArrayList;
import java.util.HashMap;

import board.Board;
import move.Move;

public class PositionEvaluater {

    public static HashMap<Move, Double> searchBestMove(Board board, int maxDepth){
        HashMap<Move, Double> moveValues = new HashMap<>();
        ArrayList<Move> tempList = board.getPossibleMoves(board.getColorToMove());
        boolean currentColorToMove = board.getColorToMove();

        for(Move m : tempList){
            moveValues.put(m, 0.0);
        }

        for(Move moveKey : moveValues.keySet()){
            Board boardCopy = board;
            boardCopy.executeMove(moveKey);
            moveValues.put(moveKey, search(board, 0, maxDepth, currentColorToMove));
        }


        return moveValues;
    }

    private static double search(Board board, int currentDepth, int maxDepth, boolean currentColorToMove){
        
        if(currentDepth == maxDepth){
            return board.getSimpleRelativeValue();
        }

        if(currentColorToMove){
            double max = -1100;

            ArrayList<Move> tempList = board.getPossibleMoves(board.getColorToMove());
            for(Move m : tempList){
                Board tempBoard = board.clone();
                tempBoard.executeMove(m);
                double thisMoveValue = search(tempBoard, currentDepth + 1, maxDepth, tempBoard.getColorToMove());
                if(thisMoveValue > max) max = thisMoveValue;
            }
        }
        if(!currentColorToMove){
            double min = 1100;

            ArrayList<Move> tempList = board.getPossibleMoves(board.getColorToMove());
            for(Move m : tempList){
                Board tempBoard = board.clone();
                tempBoard.executeMove(m);
                double thisMoveValue = search(tempBoard, currentDepth + 1, maxDepth, tempBoard.getColorToMove());
                if(thisMoveValue < min) min = thisMoveValue;
            }
        }

        return 0;
    } 
}
