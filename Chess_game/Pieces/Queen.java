package Pieces;

public class Queen extends Piece{
    public Queen(boolean color) {
        super(color);
    }

    public String toString() {
        return "[Q" + (color ? "W" : "B") + "]";
    }
}
