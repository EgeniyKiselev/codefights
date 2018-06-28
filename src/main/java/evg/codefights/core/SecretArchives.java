package evg.codefights.core;

import java.util.regex.*;

public class SecretArchives {

    public static void main(String[] args) {
//        System.out.println(new SecretArchives().htmlTable("<table><tr><td>1</td><td>TWO</td></tr><tr><td>three</td><td>FoUr4</td></tr></table>", 1, 2));
        System.out.println(new SecretArchives().chessNotation("rnbqkbnr/pppppppp/8/8/4P3/8/PPPP1PPP/RNBQKBNR"));
        System.out.println(new SecretArchives().chessNotation1("rnbqkbnr/pppppppp/8/8/4P3/8/PPPP1PPP/RNBQKBNR"));
    }

    String[] lrc2subRip(String[] lrcLyrics, String songLength) {
        Pattern pattern = Pattern.compile("^\\[(\\d{2})\\:(\\d{2})\\.(\\d{2})\\]\\s*(.*)$");
        Pattern songLen = Pattern.compile("^(\\d{2})\\:(\\d{2})\\:(\\d{2})$");
        Matcher matcher = songLen.matcher(songLength);
        matcher.find();
        int HH = Integer.parseInt(matcher.group(1));
        int MM = Integer.parseInt(matcher.group(2));
        int SS = Integer.parseInt(matcher.group(3));
        int xxx = 0;
        String[] res = new String[lrcLyrics.length * 3 + lrcLyrics.length - 1];
        for (int i = lrcLyrics.length - 1; i >= 0; i--) {
            Matcher mat = pattern.matcher(lrcLyrics[i]);
            mat.find();
            int m = Integer.parseInt(mat.group(1));
            int s = Integer.parseInt(mat.group(2));
            int x = Integer.parseInt(mat.group(3)) * 10;
            int h = 0;
            if (m > 59) {
                h = 1;
                m = m % 60;
            }
            String str = mat.group(4);

            res[i * 4] = Integer.toString(i + 1);
            res[i * 4 + 1] = String.format("%02d:%02d:%02d,%03d --> %02d:%02d:%02d,%03d", h, m, s, x, HH, MM, SS, xxx);
            res[i * 4 + 2] = str;
            if (i != lrcLyrics.length - 1) {
                res[i * 4 + 3] = "";
            }
            HH = h;
            MM = m;
            SS = s;
            xxx = x;
        }
        return res;
    }


    String htmlTable(String table, int row, int column) {
        int curRow = -1;
        int curCol = -1;
        int index = -1;
        while (curRow != row && (index = table.indexOf("<tr>", index + 1)) != -1) {
            curRow++;
        }
        if (index == -1) {
            return "No such cell";
        }
        int endIndex = table.indexOf("</tr>", index);
        index--;
        while (curCol != column && (index = table.indexOf("<td>", index + 1)) != -1) {
            curCol++;
        }
        if (index == -1 || index > endIndex) {
            return "No such cell";
        }
        int beginIndex = index + 4;
        return table.substring(beginIndex, table.indexOf("</", index));
    }

    String chessNotation(String notation) {
        char[][] board = new char[8][8];
        int i = 0;
        int j = 0;
        for (int k = 0; k < notation.length(); k++) {
            char ch = notation.charAt(k);
            if (ch == '/') {
                i++;
                j = 0;
                continue;
            }
            if (Character.isDigit(ch)) {
                j += ch - '0';
                continue;
            }
            board[i][j++] = ch;
        }
        StringBuilder sb = new StringBuilder();
        for (int col = 0; col < board.length; col++) {
            if (col != 0) {
                sb.append('/');
            }
            int n = 0;
            for (int row = board[col].length - 1; row >= 0; row--) {
                char ch = board[row][col];
                if (ch == 0) {
                    n++;
                } else {
                    if (n != 0) {
                        sb.append(n);
                        n = 0;
                    }
                    sb.append(ch);
                }
            }
            if (n != 0) {
                sb.append(n);
            }
        }
        return sb.toString();
    }
}
