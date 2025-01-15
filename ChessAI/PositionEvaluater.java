package ChessAI;

import java.util.ArrayList;
import java.util.HashMap;

import board.Board;
import move.Move;

public class PositionEvaluater {

    public static HashMap<Move, Double> getBestMove(Board board, int maxDepth){
        HashMap<Move, Double> moveValues = searchMoves(board, maxDepth);
        HashMap<Move, Double> bestMoveAndValue = new HashMap<>();
        double bestCase = board.getColorToMove() ? -2002 : 2002;
        Move bestMove = new Move(0, 0, 0, 0, false); // This is a place holder to make the jdk happy, if this case ever happens it's cooked. (It's printed as a8 to a8)
        for(Move keyMove : moveValues.keySet()){
            if(board.getColorToMove() == Board.WHITE){
                if(moveValues.get(keyMove) > bestCase){
                    bestCase = moveValues.get(keyMove);
                    bestMove = keyMove;
                }
            } else{
                if(moveValues.get(keyMove) < bestCase){
                    bestCase = moveValues.get(keyMove);
                    bestMove = keyMove;
                }
            }
        }
        bestMoveAndValue.put(bestMove, bestCase);
        return bestMoveAndValue;
    }

    public static HashMap<Move, Double> getBestMove(HashMap<Move, Double> moveValues, boolean colorToMove){
        HashMap<Move, Double> bestMoveAndValue = new HashMap<>();
        double bestCase = colorToMove ? -2002 : 2002;
        Move bestMove = new Move(0, 0, 0, 0, false); // This is a place holder to make the jdk happy, if this case ever happens it's cooked. (It's printed as a8 to a8)
        for(Move keyMove : moveValues.keySet()){
            if(colorToMove == Board.WHITE){
                if(moveValues.get(keyMove) > bestCase){
                    bestCase = moveValues.get(keyMove);
                    bestMove = keyMove;
                }
            } else{
                if(moveValues.get(keyMove) < bestCase){
                    bestCase = moveValues.get(keyMove);
                    bestMove = keyMove;
                }
            }
        }
        bestMoveAndValue.put(bestMove, bestCase);
        return bestMoveAndValue;
    }

    public static void printBestMove(Board board, int maxDepth){
        HashMap<Move, Double> bestMoveToBePrinted = getBestMove(board, maxDepth);

        for(Move keyMove : bestMoveToBePrinted.keySet()){
            System.out.println("Top move: " + keyMove + " with an eval of: " + bestMoveToBePrinted.get(keyMove));
        }

    }

    public static void printBestMove(HashMap<Move, Double> bestMoveToBePrinted){
        for(Move keyMove : bestMoveToBePrinted.keySet()){
            System.out.println("Top move: " + keyMove + " with an eval of: " + bestMoveToBePrinted.get(keyMove));
        }

    }

    public static HashMap<Move, Double> searchMoves(Board board, int maxDepth){
        HashMap<Move, Double> moveValues = new HashMap<>();
        ArrayList<Move> tempList = board.getPossibleMoves(board.getColorToMove());
        
        for(Move m : tempList){
            moveValues.put(m, 0.0);
        }
        //System.out.println(moveValues);

        for(Move moveKey : moveValues.keySet()){
            Board boardCopy = board.clone();
            boardCopy.executeMove(moveKey);
            boolean currentColorToMove = boardCopy.getColorToMove();
            moveValues.put(moveKey, search(boardCopy, 1, maxDepth, currentColorToMove));
        }


        return moveValues;
    }

    private static double search(Board board, int currentDepth, int maxDepth, boolean currentColorToMove){
        if(!board.isThereKingOnBoard(Board.WHITE)){
            return -1000 + currentDepth;
        } else if (!board.isThereKingOnBoard(Board.BLACK)){
            return 1000 - currentDepth;
        }
        
        if(currentDepth == maxDepth){
            return board.getSimpleRelativeValue();
        }
        
        if(currentColorToMove){
            double max = -2000;
            ArrayList<Move> tempList = board.getPossibleMoves(board.getColorToMove());
            for(Move m : tempList){
                Board tempBoard = board.clone();
                tempBoard.executeMove(m);
                double thisMoveValue = search(tempBoard, currentDepth + 1, maxDepth, tempBoard.getColorToMove());
                if(thisMoveValue > max) max = thisMoveValue;
            }
            return max;
        } else{
            double min = 2000;
            ArrayList<Move> tempList = board.getPossibleMoves(board.getColorToMove());
            for(Move m : tempList){
                Board tempBoard = board.clone();
                tempBoard.executeMove(m);
                double thisMoveValue = search(tempBoard, currentDepth + 1, maxDepth, tempBoard.getColorToMove());
                if(thisMoveValue <= min) min = thisMoveValue;
            }

            return min;
        }
    } 
}
