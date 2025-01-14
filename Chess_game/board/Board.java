package board;

import java.util.ArrayList;
import java.util.Scanner;

import move.Move;
import pieces.Bishop;
import pieces.King;
import pieces.Knight;
import pieces.Pawn;
import pieces.Piece;
import pieces.Queen;
import pieces.Rook;
import pieces.noPiece;


public class Board {
    // DEFS
    final static public boolean BLACK = false;
    final static public boolean WHITE = true;
    //

    public Piece[][] chessBoard;

    private boolean colorToMove = WHITE; // Which color is next to move (at the start white)

    public boolean getColorToMove() {
        return colorToMove;
    }

    public Board(Piece[][] chessBoard) {
        this.chessBoard = chessBoard;
    }
    
    public Board() {
        chessBoard = new Piece[8][8];

        chessBoard[0][0] = new Rook(BLACK);
        chessBoard[0][1] = new Knight(BLACK);
        chessBoard[0][2] = new Bishop(BLACK);
        chessBoard[0][3] = new Queen(BLACK);
        chessBoard[0][4] = new King(BLACK);
        chessBoard[0][5] = new Bishop(BLACK);
        chessBoard[0][6] = new Knight(BLACK);
        chessBoard[0][7] = new Rook(BLACK);
        for (int i = 0; i < 8; i++) {
            chessBoard[1][i] = new Pawn(BLACK);
        }

        // Place white pieces
        chessBoard[7][0] = new Rook(WHITE);
        chessBoard[7][1] = new Knight(WHITE);
        chessBoard[7][2] = new Bishop(WHITE);
        chessBoard[7][3] = new Queen(WHITE);
        chessBoard[7][4] = new King(WHITE);
        chessBoard[7][5] = new Bishop(WHITE);
        chessBoard[7][6] = new Knight(WHITE);
        chessBoard[7][7] = new Rook(WHITE);
        for (int i = 0; i < 8; i++) {
            chessBoard[6][i] = new Pawn(WHITE);
        }

        // Remaining squares are null
        for (int i = 2; i < 6; i++) {
            for (int j = 0; j < 8; j++) {
                chessBoard[i][j] = noPiece.getNoPieceInstance();
            }
        }

        // TEST
        positionTester();
        // TEST
    }

    public void positionTester(){
        for(int i = 0; i < chessBoard.length; i++){
            for(int y = 0; y < chessBoard[i].length; y++){
                chessBoard[i][y] = noPiece.getNoPieceInstance();
            }
        }
        chessBoard[4][4] = new King(WHITE);
        chessBoard[7][4] = new King(BLACK);
        //chessBoard[6][0] = new Queen(WHITE);

    }

    public double getBoardValueOfPieces(boolean inputColor){
        double value = -1000;
        for(int i = 0; i < chessBoard.length; i++){
            for(int y = 0; y < chessBoard[i].length; y++){
                if(!(chessBoard[i][y] instanceof noPiece) && chessBoard[i][y].getColor() == inputColor){
                    value += chessBoard[i][y].getValue();
                }
            }
        }
        return value;
    }

    public double getSimpleRelativeValue(){
        return getBoardValueOfPieces(WHITE) - getBoardValueOfPieces(BLACK);
    }

    public void printBoard(){
        for(int i = 0; i < chessBoard.length; i++){
            for(int k = 0; k < chessBoard[i].length; k++){
                System.out.print(chessBoard[i][k]);
            }
            System.out.println();
        }
    }

    private boolean isThereKingOnBoard(boolean inputColor){
        for(int i = 0; i < chessBoard.length; i++){
            for(int y = 0; y < chessBoard[i].length; y++){
                if(!(chessBoard[i][y] instanceof noPiece) && chessBoard[i][y].getColor() == inputColor && chessBoard[i][y] instanceof King){
                    return true;
                }
            }
        }
        return false;
    }

    public ArrayList<Move> getPossibleMoves(boolean inputColor){
        ArrayList<Move> possibleMoves = new ArrayList<>();
        for(int i = 0; i < chessBoard.length; i++){
            for(int y = 0; y < chessBoard[i].length; y++){
                if(!(chessBoard[i][y] instanceof noPiece) && chessBoard[i][y].getColor() == inputColor){
                    possibleMoves.addAll(chessBoard[i][y].move(this, i, y));
                }
            }
        }
        return possibleMoves;
    }

    public void executeMove(Move move){
        chessBoard[move.getToX()][move.getToY()] = chessBoard[move.getFromX()][move.getFromY()]; // Moves the piece from the starting square to the arrival square, replacing (capturing) the piece there.
        chessBoard[move.getFromX()][move.getFromY()] = noPiece.getNoPieceInstance();
        this.colorToMove = !this.colorToMove;
    }

    public void play(){
        System.out.println("heY");
        Scanner scanner = new Scanner(System.in);
        System.out.println("Type the move to make it, or type 'forfeit' to give up.");
        while(true){
            this.printBoard();
            System.out.println(this.getPossibleMoves(colorToMove));

            if(!isThereKingOnBoard(colorToMove)){
                System.out.println("Game over: " + (colorToMove ? "Black " : "White ") + "won!");
                break;
            }

            System.out.println((colorToMove ? "White " : "Black ") + "to move");
            String userStringMove = scanner.nextLine();
            
            if(userStringMove.equals("forfeit")){
                System.out.println("Game over: " + (colorToMove ? "Black " : "White ") + "won!");
                break;
            }

            boolean isValidMove = false;

            for(Move move : this.getPossibleMoves(colorToMove)){
                if(move.toString().equals(userStringMove)){
                    isValidMove = true;
                }
            }
            if(!isValidMove){
                System.out.println("Invalid move, try again!");
                continue;
            }
            Move userMove = Move.fromString(userStringMove);

            this.executeMove(userMove);

        }
        scanner.close();
    }

    public boolean isTheSameBoard(Board otherBoard){
        for(int i = 0; i < this.chessBoard.length; i++){
            for(int k = 0; k < this.chessBoard[i].length; k++){
                if(this.chessBoard[i][k] != otherBoard.chessBoard[i][k]){
                    return false;
                }
            }
        }
        return true;
    }

    public Board(Board other){
        this.colorToMove = other.colorToMove;
        this.chessBoard = new Piece[8][8];
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                this.chessBoard[i][j] = other.chessBoard[i][j];
            }
        }
    }

    public Board clone(){
        return new Board(this);
    }
}
