package Pieces;

public class King extends Piece{

    public King(boolean color) {
        super(color);
    }

    public String toString() {
        return "[K" + (color ? "W" : "B") + "]";
    }
}
