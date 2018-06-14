package evg.codefights.core;

public class ChessTavern {

    public static void main(String[] args) {

    }

    boolean bishopAndPawn(String bishop, String pawn) {
        int x1 = bishop.charAt(0) -'a';
        int y1 = bishop.charAt(1) -'1';
        int x2 = pawn.charAt(0) -'a';
        int y2 = pawn.charAt(1) -'1';


        return Math.abs(x1 - x2) == Math.abs(y2 - y1);
    }

    int chessKnightMoves(String cell) {
        int col = cell.charAt(0) - 'a';
        int row = cell.charAt(1) - '1';
        int res = 0;
        return isValid(col - 1, row - 2) +
                isValid(col - 2, row - 1) +
                isValid(col + 1, row + 2) +
                isValid(col + 2, row + 1) +
                isValid(col + 1, row - 2) +
                isValid(col + 2, row - 1) +
                isValid(col - 1, row + 2) +
                isValid(col - 2, row + 1);
    }

    int isValid(int col, int row) {
        if (col >= 0 && col <= 7 && row >= 0 && row <= 7) {
            return 1;
        }
        return 0;
    }
}
