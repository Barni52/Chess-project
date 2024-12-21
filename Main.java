import board.Board;
import move.Move;

public class Main {
    public static void main(String[] args) {
        Board mainBoard = new Board();
        mainBoard.printBoard();

        Move m1 = new Move(0, 7, 7, 7, false);
        System.out.println(m1);

        System.out.println(mainBoard.getPossibleMoves());
    }
}
