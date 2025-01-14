import board.Board;
import board.BoardTest;
import move.Move;

public class Main {
    public static void main(String[] args) {
        Board mainBoard = new Board();

        //mainBoard.play();

        mainBoard.printBoard();
        System.out.println(mainBoard.getSimpleRelativeValue());
    }
}
