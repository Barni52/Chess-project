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

    private static int letterToNumber(String s){
        switch (s) {
            case "a":
                return 0;
            case "b":
                return 1;
            case "c":
                return 2;
            case "d":
                return 3;
            case "e":
                return 4;
            case "f":
                return 5;
            case "g":
                return 6;
            case "h":
                return 7;
            default:
                System.out.println("BAD INPUT IN THE CONVERSION (letter to number)");
                return -52;
        }
    }

    private static int stringNumberToLetter(String s){
        switch (s) {
            case "8":
                return 0;
            case "7":
                return 1;
            case "6":
                return 2;
            case "5":
                return 3;
            case "4":
                return 4;
            case "3":
                return 5;
            case "2":
                return 6;
            case "1":
                return 7;
            default:
                System.out.println("BAD INPUT IN THE CONVERSION (letter to number)");
                return -62;
        }
    }

    public String toString() {
        if(isCastling){
            return numberToChar.convert(fromY) + (8 - fromX) + " toCA " + numberToChar.convert(toY) + (8 - toX);
        }
        return numberToChar.convert(fromY) + (8 - fromX) + " to " + numberToChar.convert(toY) + (8 - toX);
    }

    public static Move fromString(String stringMove) {
        String[] splitString = stringMove.split(" ");

        int fromY = letterToNumber(splitString[0].substring(0, 1));
        int fromX = stringNumberToLetter(splitString[0].substring(1, 2));

        int toY = letterToNumber(splitString[2].substring(0, 1));
        int toX = stringNumberToLetter(splitString[2].substring(1, 2));

        return new Move(fromX, fromY, toX, toY, false);
    }



    
}
