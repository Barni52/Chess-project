import java.util.HashMap;

import ChessAI.PositionEvaluater;
import board.Board;
import board.BoardTest;
import move.Move;

public class Main {
    public static void main(String[] args) {
        Board mainBoard = new Board();

        //mainBoard.play();

        mainBoard.printBoard();
        //System.out.println(mainBoard.getSimpleRelativeValue());
        int maxDepth = 5;
        HashMap<Move, Double> bestMoves = PositionEvaluater.searchMoves(mainBoard, maxDepth);
        System.out.println(bestMoves);
        PositionEvaluater.printBestMove(PositionEvaluater.getBestMove(bestMoves, mainBoard.getColorToMove()));
        
    }

    /*
     * TODO
     * 
     * Currently the algo doesnt consider the length of the checkmate: m3 == m8! Need fix 
     * Very slow (alpa-beta pruning?)
     * Eval is really shit, needs lots of update!
     * Promotions (half done)
     * 
     * 
     * 
     */
}
