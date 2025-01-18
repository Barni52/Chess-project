import java.util.HashMap;

import ChessAI.PositionSearcher;
import board.Board;
import board.BoardTest;
import move.Move;

public class Main {
    public static void main(String[] args) {
        Board mainBoard = new Board();

        //mainBoard.play();

        mainBoard.printBoard();

        mainBoard.play();
        //System.out.println(mainBoard.getSimpleRelativeValue());
        int maxDepth = 6;

        long startTime = System.currentTimeMillis();

        HashMap<Move, Double> bestMoves = PositionSearcher.searchMoves(mainBoard, maxDepth);

        long finishTime = System.currentTimeMillis();
        System.out.println("That took: " + ((double)(finishTime - startTime)  / 1000) + " s");

        System.out.println(bestMoves);
        PositionSearcher.printBestMove(PositionSearcher.getBestMove(bestMoves, mainBoard.getColorToMove()));

        System.out.println("Checked " + String.format("%,d", PositionSearcher.leavesChecked) + " nodes!");
        

    }

    /*
     * TODO
     * 
     * Currently the algo doesnt consider the length of the checkmate: m3 == m8! Need fix // FIXED (Kinda, depth not obvious, but higher values = shorter mate)
     * Very slow (alpa-beta pruning?) // Implemented
     * Eval is really shit, needs lots of update!
     * Promotions (half done)
     * 
     * 
     * 
     */
}
