package com.cs414.blueberries;
import java.awt.*;

public class Pawn extends Piece{
    public Pawn(PieceColor pieceColor, Point location, Board board){
        super(pieceColor, location, PieceType.PAWN, board);
    }

    public Pawn(PieceColor pieceColor, Point location){
        super(pieceColor, location, PieceType.PAWN);
    }

    @Override
    public void updateMoves() {

    }
}
