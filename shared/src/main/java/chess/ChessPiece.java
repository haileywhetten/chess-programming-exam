package chess;

import java.util.Collection;
import java.util.HashSet;
import java.util.Objects;

/**
 * Represents a single chess piece
 * <p>
 * Note: You can add to this class, but you may not alter
 * signature of the existing methods.
 */
public class ChessPiece {

    private final ChessGame.TeamColor pieceColor;
    private final PieceType type;

    public ChessPiece(ChessGame.TeamColor pieceColor, ChessPiece.PieceType type) {
        this.pieceColor = pieceColor;
        this.type = type;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        ChessPiece that = (ChessPiece) o;
        return pieceColor == that.pieceColor && type == that.type;
    }

    @Override
    public int hashCode() {
        return Objects.hash(pieceColor, type);
    }

    /**
     * The various different chess piece options
     */
    public enum PieceType {
        KING,
        QUEEN,
        BISHOP,
        KNIGHT,
        ROOK,
        PAWN
    }

    /**
     * @return Which team this chess piece belongs to
     */
    public ChessGame.TeamColor getTeamColor() {
        return pieceColor;
    }

    /**
     * @return which type of chess piece this piece is
     */
    public PieceType getPieceType() {
        return type;
    }

    /**
     * Calculates all the positions a chess piece can move to
     * Does not take into account moves that are illegal due to leaving the king in
     * danger
     *
     * @return Collection of valid moves
     */
    public Collection<ChessMove> pieceMoves(ChessBoard board, ChessPosition myPosition) {
        if(type == PieceType.BISHOP) {
            return bishopMoves(board, myPosition);
        }
        else if (type == PieceType.KING) {
            return kingMoves(board, myPosition);
        }
        else if (type == PieceType.KNIGHT) {
            return knightMoves(board, myPosition);
        }
        else if (type == PieceType.PAWN) {
            return pawnMoves(board, myPosition);
        }
        else if (type == PieceType.QUEEN) {
            return queenMoves(board, myPosition);
        }
        else if (type == PieceType.ROOK) {
            return rookMoves(board, myPosition);
        }
        return null;
    }


    public Collection<ChessMove> bishopMoves(ChessBoard board, ChessPosition myPosition) {
        var moves = new HashSet<ChessMove>();
        boolean validMove = true;
        int currRow = myPosition.getRow();
        int currCol = myPosition.getColumn();

        while(validMove) {
            currRow++;
            currCol++;
            var newPosition = new ChessPosition(currRow, currCol);
            validMove = isPositionValid(board, newPosition);
            if(validMove) {
                var newMove = new ChessMove(myPosition, newPosition, null);
                moves.add(newMove);
            }
            if(validMove && board.getPiece(newPosition) != null) {
                validMove = false;
            }
        }
        validMove = true;
        currRow = myPosition.getRow();
        currCol = myPosition.getColumn();

        while(validMove) {
            currRow++;
            currCol--;
            var newPosition = new ChessPosition(currRow, currCol);
            validMove = isPositionValid(board, newPosition);
            if(validMove) {
                var newMove = new ChessMove(myPosition, newPosition, null);
                moves.add(newMove);
            }
            if(validMove && board.getPiece(newPosition) != null) {
                validMove = false;
            }
        }
        validMove = true;
        currRow = myPosition.getRow();
        currCol = myPosition.getColumn();

        while(validMove) {
            currRow--;
            currCol++;
            var newPosition = new ChessPosition(currRow, currCol);
            validMove = isPositionValid(board, newPosition);
            if(validMove) {
                var newMove = new ChessMove(myPosition, newPosition, null);
                moves.add(newMove);
            }
            if(validMove && board.getPiece(newPosition) != null) {
                validMove = false;
            }
        }
        validMove = true;
        currRow = myPosition.getRow();
        currCol = myPosition.getColumn();

        while(validMove) {
            currRow--;
            currCol--;
            var newPosition = new ChessPosition(currRow, currCol);
            validMove = isPositionValid(board, newPosition);
            if(validMove) {
                var newMove = new ChessMove(myPosition, newPosition, null);
                moves.add(newMove);
            }
            if(validMove && board.getPiece(newPosition) != null) {
                validMove = false;
            }
        }


        return moves;
    }

    public Collection<ChessMove> kingMoves(ChessBoard board, ChessPosition myPosition) {
        var moves = new HashSet<ChessMove>();
        boolean validMove = true;
        int currRow = myPosition.getRow();
        int currCol = myPosition.getColumn();

        var newPosition1 = new ChessPosition(currRow + 1, currCol);
        validMove = isPositionValid(board, newPosition1);
        if(validMove) {
            var newMove = new ChessMove(myPosition, newPosition1, null);
            moves.add(newMove);
        }
        var newPosition2 = new ChessPosition(currRow - 1, currCol);
        validMove = isPositionValid(board, newPosition2);
        if(validMove) {
            var newMove = new ChessMove(myPosition, newPosition2, null);
            moves.add(newMove);
        }
        var newPosition3 = new ChessPosition(currRow, currCol + 1);
        validMove = isPositionValid(board, newPosition3);
        if(validMove) {
            var newMove = new ChessMove(myPosition, newPosition3, null);
            moves.add(newMove);
        }
        var newPosition4 = new ChessPosition(currRow, currCol - 1);
        validMove = isPositionValid(board, newPosition4);
        if(validMove) {
            var newMove = new ChessMove(myPosition, newPosition4, null);
            moves.add(newMove);
        }
        var newPosition5 = new ChessPosition(currRow + 1, currCol + 1);
        validMove = isPositionValid(board, newPosition5);
        if(validMove) {
            var newMove = new ChessMove(myPosition, newPosition5, null);
            moves.add(newMove);
        }
        var newPosition6 = new ChessPosition(currRow - 1, currCol + 1);
        validMove = isPositionValid(board, newPosition6);
        if(validMove) {
            var newMove = new ChessMove(myPosition, newPosition6, null);
            moves.add(newMove);
        }
        var newPosition7 = new ChessPosition(currRow + 1, currCol - 1);
        validMove = isPositionValid(board, newPosition7);
        if(validMove) {
            var newMove = new ChessMove(myPosition, newPosition7, null);
            moves.add(newMove);
        }
        var newPosition8 = new ChessPosition(currRow - 1, currCol - 1);
        validMove = isPositionValid(board, newPosition8);
        if(validMove) {
            var newMove = new ChessMove(myPosition, newPosition8, null);
            moves.add(newMove);
        }

        return moves;
    }

    public Collection<ChessMove> knightMoves(ChessBoard board, ChessPosition myPosition) {
        var moves = new HashSet<ChessMove>();
        boolean validMove = true;
        int currRow = myPosition.getRow();
        int currCol = myPosition.getColumn();

        var newPosition1 = new ChessPosition(currRow + 1, currCol + 2);
        validMove = isPositionValid(board, newPosition1);
        if(validMove) {
            var newMove = new ChessMove(myPosition, newPosition1, null);
            moves.add(newMove);
        }
        var newPosition2 = new ChessPosition(currRow - 1, currCol + 2);
        validMove = isPositionValid(board, newPosition2);
        if(validMove) {
            var newMove = new ChessMove(myPosition, newPosition2, null);
            moves.add(newMove);
        }
        var newPosition3 = new ChessPosition(currRow + 2, currCol + 1);
        validMove = isPositionValid(board, newPosition3);
        if(validMove) {
            var newMove = new ChessMove(myPosition, newPosition3, null);
            moves.add(newMove);
        }
        var newPosition4 = new ChessPosition(currRow + 2, currCol - 1);
        validMove = isPositionValid(board, newPosition4);
        if(validMove) {
            var newMove = new ChessMove(myPosition, newPosition4, null);
            moves.add(newMove);
        }
        var newPosition5 = new ChessPosition(currRow + 1, currCol - 2);
        validMove = isPositionValid(board, newPosition5);
        if(validMove) {
            var newMove = new ChessMove(myPosition, newPosition5, null);
            moves.add(newMove);
        }
        var newPosition6 = new ChessPosition(currRow - 1, currCol - 2);
        validMove = isPositionValid(board, newPosition6);
        if(validMove) {
            var newMove = new ChessMove(myPosition, newPosition6, null);
            moves.add(newMove);
        }
        var newPosition7 = new ChessPosition(currRow - 2, currCol + 1);
        validMove = isPositionValid(board, newPosition7);
        if(validMove) {
            var newMove = new ChessMove(myPosition, newPosition7, null);
            moves.add(newMove);
        }
        var newPosition8 = new ChessPosition(currRow - 2, currCol - 1);
        validMove = isPositionValid(board, newPosition8);
        if(validMove) {
            var newMove = new ChessMove(myPosition, newPosition8, null);
            moves.add(newMove);
        }
        return moves;
    }

    public Collection<ChessMove> pawnMoves(ChessBoard board, ChessPosition myPosition) {
        var moves = new HashSet<ChessMove>();
        boolean validMove = true;
        int currRow = myPosition.getRow();
        int currCol = myPosition.getColumn();
        int direction = 0;
        if(pieceColor == ChessGame.TeamColor.WHITE) {
            direction = 1;
        }
        else{
            direction = -1;
        }
        var newPosition1 = new ChessPosition(currRow + direction, currCol);
        validMove = isPositionValid(board, newPosition1);
        if(board.getPiece(newPosition1) != null) {
            validMove = false;
        }
        if(validMove && (newPosition1.getRow() != 1 && newPosition1.getRow() != 8)) {
            var newMove = new ChessMove(myPosition, newPosition1, null);
            moves.add(newMove);
        }
        if(currRow == 2 || currRow == 7) {
            var newPosition2 = new ChessPosition(currRow + 2*direction, currCol);
            if(isPositionValid(board, newPosition1) && isPositionValid(board, newPosition2) && board.getPiece(newPosition1) == null && board.getPiece(newPosition2) == null ){
                var newMove = new ChessMove(myPosition, newPosition2, null);
                moves.add(newMove);
            }
        }
        boolean enemyPresent = false;
        var diagonal1 = new ChessPosition(currRow + direction, currCol + 1);
        validMove = isPositionValid(board, diagonal1);
        if(validMove) {
            if(board.getPiece(diagonal1) != null && board.getPiece(diagonal1).getPieceType() != type) {
                enemyPresent = true;
            }
        }
        if(validMove && enemyPresent && (diagonal1.getRow() != 1 && diagonal1.getRow() != 8)) {
            var newMove = new ChessMove(myPosition, diagonal1, null);
            moves.add(newMove);
        }
        enemyPresent = false;
        var diagonal2 = new ChessPosition(currRow + direction, currCol - 1);
        validMove = isPositionValid(board, diagonal2);
        if(validMove) {
            if(board.getPiece(diagonal2) != null && board.getPiece(diagonal2).getPieceType() != type) {
                enemyPresent = true;
            }
        }
        if(validMove && enemyPresent && (diagonal2.getRow() != 1 && diagonal2.getRow() != 8)) {
            var newMove = new ChessMove(myPosition, diagonal2, null);
            moves.add(newMove);
        }
        enemyPresent = false;
        if(myPosition.getRow() + direction == 1 || myPosition.getRow() + direction == 8) {
            var newPosition3 = new ChessPosition(currRow + direction, currCol);
            validMove = isPositionValid(board, newPosition3);
            if(board.getPiece(newPosition3) != null) {
                validMove = false;
            }
            if(validMove) {
                var newMove1 = new ChessMove(myPosition, newPosition3, PieceType.BISHOP);
                moves.add(newMove1);
                var newMove2 = new ChessMove(myPosition, newPosition3, PieceType.KNIGHT);
                moves.add(newMove2);
                var newMove3 = new ChessMove(myPosition, newPosition3, PieceType.ROOK);
                moves.add(newMove3);
                var newMove4 = new ChessMove(myPosition, newPosition3, PieceType.QUEEN);
                moves.add(newMove4);
            }
            var diagonal3 = new ChessPosition(currRow + direction, currCol + 1);
            validMove = isPositionValid(board, diagonal3);
            if(validMove) {
                if(board.getPiece(diagonal3) != null && board.getPiece(diagonal3).getPieceType() != type) {
                    enemyPresent = true;
                }
            }
            if(validMove && enemyPresent) {
                var newMove1 = new ChessMove(myPosition, diagonal3, PieceType.BISHOP);
                moves.add(newMove1);
                var newMove2 = new ChessMove(myPosition, diagonal3, PieceType.KNIGHT);
                moves.add(newMove2);
                var newMove3 = new ChessMove(myPosition, diagonal3, PieceType.ROOK);
                moves.add(newMove3);
                var newMove4 = new ChessMove(myPosition, diagonal3, PieceType.QUEEN);
                moves.add(newMove4);
            }
            enemyPresent = false;
            var diagonal4 = new ChessPosition(currRow + direction, currCol - 1);
            validMove = isPositionValid(board, diagonal4);
            if(validMove) {
                if(board.getPiece(diagonal4) != null && board.getPiece(diagonal4).getPieceType() != type) {
                    enemyPresent = true;
                }
            }
            if(validMove && enemyPresent) {
                var newMove1 = new ChessMove(myPosition, diagonal4, PieceType.BISHOP);
                moves.add(newMove1);
                var newMove2 = new ChessMove(myPosition, diagonal4, PieceType.KNIGHT);
                moves.add(newMove2);
                var newMove3 = new ChessMove(myPosition, diagonal4, PieceType.ROOK);
                moves.add(newMove3);
                var newMove4 = new ChessMove(myPosition, diagonal4, PieceType.QUEEN);
                moves.add(newMove4);
            }

        }
        return moves;
    }

    public Collection<ChessMove> queenMoves(ChessBoard board, ChessPosition myPosition) {
        var moves = new HashSet<ChessMove>();
        var bishopMoves = bishopMoves(board, myPosition);
        var rookMoves = rookMoves(board, myPosition);
        moves.addAll(bishopMoves);
        moves.addAll(rookMoves);
        return moves;
    }

    public Collection<ChessMove> rookMoves(ChessBoard board, ChessPosition myPosition) {
        var moves = new HashSet<ChessMove>();
        boolean validMove = true;
        int currRow = myPosition.getRow();
        int currCol = myPosition.getColumn();

        while(validMove) {
            currRow++;
            var newPosition = new ChessPosition(currRow, currCol);
            validMove = isPositionValid(board, newPosition);
            if(validMove) {
                var newMove = new ChessMove(myPosition, newPosition, null);
                moves.add(newMove);
            }
            if(validMove && board.getPiece(newPosition) != null) {
                validMove = false;
            }
        }
        validMove = true;
        currRow = myPosition.getRow();
        currCol = myPosition.getColumn();

        while(validMove) {
            currCol--;
            var newPosition = new ChessPosition(currRow, currCol);
            validMove = isPositionValid(board, newPosition);
            if(validMove) {
                var newMove = new ChessMove(myPosition, newPosition, null);
                moves.add(newMove);
            }
            if(validMove && board.getPiece(newPosition) != null) {
                validMove = false;
            }
        }
        validMove = true;
        currRow = myPosition.getRow();
        currCol = myPosition.getColumn();

        while(validMove) {
            currRow--;
            var newPosition = new ChessPosition(currRow, currCol);
            validMove = isPositionValid(board, newPosition);
            if(validMove) {
                var newMove = new ChessMove(myPosition, newPosition, null);
                moves.add(newMove);
            }
            if(validMove && board.getPiece(newPosition) != null) {
                validMove = false;
            }
        }
        validMove = true;
        currRow = myPosition.getRow();
        currCol = myPosition.getColumn();

        while(validMove) {
            currCol++;
            var newPosition = new ChessPosition(currRow, currCol);
            validMove = isPositionValid(board, newPosition);
            if(validMove) {
                var newMove = new ChessMove(myPosition, newPosition, null);
                moves.add(newMove);
            }
            if(validMove && board.getPiece(newPosition) != null) {
                validMove = false;
            }
        }
        return moves;
    }

    public boolean isPositionValid(ChessBoard board, ChessPosition myPosition) {
        if(myPosition.getRow() < 1 || myPosition.getRow() > 8 || myPosition.getColumn()< 1 || myPosition.getColumn() > 8) {
            return false;
        }
        else if(board.getPiece(myPosition) != null && board.getPiece(myPosition).getTeamColor() == pieceColor) {
            return false;
        }
        else {return true;}
    }

}
