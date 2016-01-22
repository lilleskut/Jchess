package com.example.jens.jchess;


public class Piece {

    // class constants
    // Colors for pieces.
    public static final String BLACK = "Black";
    public static final String WHITE = "White";

    // Types for pieces.
    public static final String PAWN = "Pawn";
    public static final String KNIGHT = "Knight";
    public static final String BISHOP = "Bishop";
    public static final String ROOK = "Rook";
    public static final String QUEEN = "Queen";
    public static final String KING = "King";

    public static final String WhiteKing = "&#9812";
    public static final String WhiteQueen = "&#9813";
    public static final String WhiteRook = "&#9814";
    public static final String WhiteBishop = "&#9815";
    public static final String WhiteKnight = "&#9816";
    public static final String WhitePawn = "&#9817";
    public static final String BlackKing = "&#9818";
    public static final String BlackQueen = "&#9819";
    public static final String BlackRook = "&#9820";
    public static final String BlackBishop = "&#9821";
    public static final String BlackKnight = "&#9822";
    public static final String BlackPawn = "&#9823";

    private String color;
    private String type;


    // constructor
    public Piece() {
        this.color = "";
        this.type = "";
    }

    public Piece(String color, String type) {
        if (!(color.equals(BLACK) || color.equals(WHITE))
                || !(type.equals(KING) || type.equals(QUEEN)
                || type.equals(BISHOP) || type.equals(KNIGHT)
                || type.equals(ROOK) || type.equals(PAWN))) {
            throw new IllegalArgumentException();
        }

        this.color = color;
        this.type = type;
    }

    public String getString() {
        String pieceString = "";
        if( color.equals(WHITE) ) {
            switch(type) {
                case PAWN:
                    pieceString = WhitePawn;
                    break;
                case KNIGHT:
                    pieceString = WhiteKnight;
                    break;
                case BISHOP:
                    pieceString = WhiteBishop;
                    break;
                case ROOK:
                    pieceString = WhiteRook;
                    break;
                case QUEEN:
                    pieceString = WhiteQueen;
                    break;
                case KING:
                    pieceString = WhiteKing;
                    break;
            }
        } else if ( color.equals(BLACK) ) {
            switch(type) {
                case PAWN:
                    pieceString = BlackPawn;
                    break;
                case KNIGHT:
                    pieceString = BlackKnight;
                    break;
                case BISHOP:
                    pieceString = BlackBishop;
                    break;
                case ROOK:
                    pieceString = BlackRook;
                    break;
                case QUEEN:
                    pieceString = BlackQueen;
                    break;
                case KING:
                    pieceString = BlackKing;
                    break;
            }
        }
        return pieceString;
    }
}
