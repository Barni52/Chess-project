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
        int maxDepth = 7;

        long startTime = System.currentTimeMillis();

        HashMap<Move, Double> bestMoves = PositionEvaluater.searchMoves(mainBoard, maxDepth);

        long finishTime = System.currentTimeMillis();
        System.out.println("That took: " + ((double)(finishTime - startTime)  / 1000) + " s");

        System.out.println(bestMoves);
        PositionEvaluater.printBestMove(PositionEvaluater.getBestMove(bestMoves, mainBoard.getColorToMove()));

        System.out.println("Checked " + String.format("%,d", PositionEvaluater.leavesChecked) + " nodes!");
        

    }

    /*
     * TODO
     * 
     * Currently the algo doesnt consider the length of the checkmate: m3 == m8! Need fix // FIXED (Kinda depth not obvious, but higher values = shorter mate)
     * Very slow (alpa-beta pruning?)
     * Eval is really shit, needs lots of update!
     * Promotions (half done)
     * 
     * 
     * 
     */
}
