import ChessAI.PositionEvaluater;
import board.Board;
import board.BoardTest;
import move.Move;

public class Main {
    public static void main(String[] args) {
        Board mainBoard = new Board();

        //mainBoard.play();

        mainBoard.printBoard();
        mainBoard.getPossibleMoves(true);

        int maxDepth = 4;

        //System.out.println(PositionEvaluater.searchBestMove(mainBoard, maxDepth));
    }
}
