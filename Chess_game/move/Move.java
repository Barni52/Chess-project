package move;

import numberToChar.numberToChar;

public class Move {
    private int fromX;
    private int fromY;

    private int toX;
    private int toY;

    private boolean possibleEnPassant;

    private boolean isCastling = false;
    
    public Move(int fromX, int fromY, int toX, int toY, boolean possibleEnPassant) {
        this.fromX = fromX;
        this.fromY = fromY;
        this.toX = toX;
        this.toY = toY;
        this.possibleEnPassant = possibleEnPassant;
    }

    public Move(int fromX, int fromY, int toX, int toY, boolean possibleEnPassant, boolean isCastling) {
        this.fromX = fromX;
        this.fromY = fromY;
        this.toX = toX;
        this.toY = toY;
        this.possibleEnPassant = possibleEnPassant;
        this.isCastling = isCastling;
    }

    public int getFromX() {
        return fromX;
    }
    public int getFromY() {
        return fromY;
    }
    public int getToX() {
        return toX;
    }
    public int getToY() {
        return toY;
    }
    public boolean isPossibleEnPassant() {
        return possibleEnPassant;
    }

    public String toString() {
        if(isCastling){
            return numberToChar.convert(fromY) + (8 - fromX) + " toCA " + numberToChar.convert(toY) + (8 - toX);
        }
        return numberToChar.convert(fromY) + (8 - fromX) + " to " + numberToChar.convert(toY) + (8 - toX);
    }

    
}
