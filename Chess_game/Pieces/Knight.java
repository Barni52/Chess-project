package Pieces;

public class Knight extends Piece{
    public Knight(boolean color) {
        super(color);
    }

    public String toString() {
        return "[N" + (color ? "W" : "B") + "]";
    }
}
