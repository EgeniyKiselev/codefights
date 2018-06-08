package evg.codefights.intro;

public class RainbowOfClarity {

    boolean isDigit(char symbol) {
        return Character.isDigit(symbol);
    }

    String lineEncoding(String s) {
        StringBuilder sb = new StringBuilder();
        int cur = 1;
        char last = s.charAt(0);
        for(int i = 1; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (last == ch) {
                cur++;
            } else {
                if (cur > 1) {
                    sb.append(cur).append(last);
                } else {
                    sb.append(last);
                }
                cur = 1;
                last = ch;
            }
        }
        if (cur > 1) {
            sb.append(cur).append(last);
        } else {
            sb.append(last);
        }
        return sb.toString();
    }

    int chessKnight(String cell) {
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

    int deleteDigit(int n) {
        int r = n;
        int last = -1;
        int pos = 0;
        int p = 0;
        int res = 0;
        while (r != 0) {
            int l = r % 10;
            r /= 10;
            if (last > l) {
                pos = p;
            }
            last = l;
            p++;
        }
        p = 0;
        r = n;
        int k = 1;
        while (r != 0) {
            int l = r % 10;
            r /= 10;
            if (p++ == pos) {
                continue;
            }
            res += k * l;
            k *= 10;
        }
        return res;
    }
}
