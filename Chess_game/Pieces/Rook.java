package Pieces;

public class Rook extends Piece{
    public Rook(boolean color) {
        super(color);
    }

    public String toString() {
        return "[R" + (color ? "W" : "B") + "]";
    }
}
