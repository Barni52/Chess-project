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
        int maxDepth = 4;
        //System.out.println(PositionEvaluater.searchMoves(mainBoard, maxDepth));
        PositionEvaluater.printBestMove(mainBoard, maxDepth);
        
    }

    /*
     * TODO
     * 
     * Currently the algo doesnt consider the length of the checkmate: m3 == m8! Need fix 
     * Very slow (alpa-beta pruning?)
     * Eval is really shit, needs lots of update!
     * 
     * 
     * 
     * 
     */
}
