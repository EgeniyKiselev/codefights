package evg.codefights.core;

public class ChessTavern {

    public static void main(String[] args) {

    }

    boolean bishopAndPawn(String bishop, String pawn) {
        int x1 = bishop.charAt(0) - 'a';
        int y1 = bishop.charAt(1) - '1';
        int x2 = pawn.charAt(0) - 'a';
        int y2 = pawn.charAt(1) - '1';


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

    String[] bishopDiagonal(String bishop1, String bishop2) {
        int x1 = bishop1.charAt(0) - 'a';
        int y1 = bishop1.charAt(1) - '1';
        int x2 = bishop2.charAt(0) - 'a';
        int y2 = bishop2.charAt(1) - '1';
        String[] result = new String[2];
        if (x1 + y1 == x2 + y2) {
            while (x1 > 0 && y1 < 7) {
                x1--;
                y1++;
            }
            while (x2 < 7 && y2 > 0) {
                x2++;
                y2--;
            }
            result[0] = new String(new char[]{(char) (x1 + 'a'), (char) (y1 + '1')});
            result[1] = new String(new char[]{(char) (x2 + 'a'), (char) (y2 + '1')});
            return result;
        } else if (x1 - y1 == x2 - y2) {
            while (x1 * y1 > 0) {
                x1--;
                y1--;
            }
            while (x2 < 7 && y2 < 7) {
                x2++;
                y2++;
            }
            result[0] = new String(new char[]{(char) (x1 + 'a'), (char) (y1 + '1')});
            result[1] = new String(new char[]{(char) (x2 + 'a'), (char) (y2 + '1')});
            return result;
        } else {
            if (bishop1.charAt(0) < bishop2.charAt(0)) {
                return new String[]{bishop1, bishop2};
            } else if (bishop1.charAt(0) > bishop2.charAt(0)) {
                return new String[]{bishop2, bishop1};
            } else {
                return bishop1.charAt(1) <= bishop2.charAt(1) ? new String[]{bishop1, bishop2} : new String[]{bishop2, bishop1};
            }
        }
    }

}
