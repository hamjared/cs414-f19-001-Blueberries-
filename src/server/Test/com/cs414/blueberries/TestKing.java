package com.cs414.blueberries;

import org.junit.Test;

import java.awt.*;
import java.util.HashSet;
import static org.junit.Assert.*;

public class TestKing {

    @Test
    public void testWhiteKingStart(){
        Board board = new Board(100);
        King king = new King(PieceColor.WHITE, new Point(3,5), board);
        board.placePiece(king);
        king.updateMoves();

        HashSet<Point> expected = new HashSet<>();
        expected.add(new Point(2,5));
        expected.add(new Point(4,5));
        expected.add(new Point(3,6));
        expected.add(new Point(2,6));
        expected.add(new Point(4,6));

        HashSet<Point> actual = king.getPossibleMoves();
        assertTrue(actual.containsAll(expected));
        assertEquals(expected.size(),actual.size());
    }

    @Test
    public void testBlackKingStart(){
        Board board = new Board(100);
        King king = new King(PieceColor.BLACK, new Point(3,1), board);
        board.placePiece(king);
        king.updateMoves();

        HashSet<Point> expected = new HashSet<>();
        expected.add(new Point(2,1));
        expected.add(new Point(4,1));
        expected.add(new Point(3,0));
        expected.add(new Point(2,0));
        expected.add(new Point(4,0));

        HashSet<Point> actual = king.getPossibleMoves();
        assertTrue(actual.containsAll(expected));
        assertEquals(expected.size(),actual.size());
    }

    @Test
    public void testKingBlock(){
        Board board = new Board(100);
        King king = new King(PieceColor.WHITE, new Point(3,5), board);
        board.placePiece(king);
        Pawn pawn1 = new Pawn(PieceColor.WHITE, new Point(4,5), board);
        Pawn pawn2 = new Pawn(PieceColor.WHITE, new Point(4,6), board);
        Pawn pawn3 = new Pawn(PieceColor.WHITE, new Point(3,6), board);

        board.placePiece(pawn1);
        board.placePiece(pawn2);
        board.placePiece(pawn3);

        king.updateMoves();

        HashSet<Point> expected = new HashSet<>();
        expected.add(new Point(2,5));
        expected.add(new Point(2,6));

        HashSet<Point> actual = king.getPossibleMoves();
        assertTrue(actual.containsAll(expected));
        assertEquals(expected.size(),actual.size());
    }


    @Test
    public void testKingCapture(){
        Board board = new Board(100);
        King king = new King(PieceColor.WHITE, new Point(3,5), board);
        board.placePiece(king);
        Pawn pawn1 = new Pawn(PieceColor.BLACK, new Point(4,5), board);
        Pawn pawn2 = new Pawn(PieceColor.BLACK, new Point(4,6), board);

        board.placePiece(pawn1);
        board.placePiece(pawn2);

        king.updateMoves();

        HashSet<Point> expected = new HashSet<>();
        expected.add(new Point(2,5));
        expected.add(new Point(2,6));
        expected.add(new Point(3,6));
        expected.add(new Point(4,5));
        expected.add(new Point(4,6));

        HashSet<Point> actual = king.getPossibleMoves();
        assertTrue(actual.containsAll(expected));
        assertEquals(expected.size(),actual.size());
    }
}