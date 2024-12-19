package Pieces;

public class Pawn extends Piece{
    private boolean moved = false;
    public Pawn(boolean color) {
        super(color);
    }

    public String toString() {
        return "[P" + (color ? "W" : "B") + "]";
    }
}
