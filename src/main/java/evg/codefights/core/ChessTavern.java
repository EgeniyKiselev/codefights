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
}
