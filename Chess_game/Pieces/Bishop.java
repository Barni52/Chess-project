package Pieces;

public class Bishop extends Piece{
    public Bishop(boolean color) {
        super(color);
    }

    public String toString() {
        return "[B" + (color ? "W" : "B") + "]";
    }

    
}
