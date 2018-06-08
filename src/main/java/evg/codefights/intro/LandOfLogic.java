package evg.codefights.intro;

import java.util.*;

public class LandOfLogic {

    String longestWord(String text) {
        return Arrays.stream(
                text.split("[^a-zA-Z]"))
                .max(Comparator.comparingInt(String::length))
                .get();
    }

    boolean validTime(String time) {
        String[] s = time.split(":");
        int hours = Integer.parseInt(s[0]);
        int minutes = Integer.parseInt(s[1]);
        return hours >= 0 && hours < 24 && minutes >= 0 && minutes < 60;
    }

    int sumUpNumbers(String inputString) {
        int sum = 0;
        int cur = 0;
        for (int i = 0; i < inputString.length(); i++) {
            char ch = inputString.charAt(i);
            if (Character.isDigit(ch)) {
                sum -= cur;
                cur = 10 * cur + (ch - '0');
                sum += cur;
            } else {
                cur = 0;
            }
        }
        return sum;
    }

    int differentSquares(int[][] matrix) {
        if (matrix.length <= 1) {
            return 0;
        }
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < matrix.length - 1; i++) {
            for (int j = 0; j < matrix[i].length - 1; j++) {
                set.add(calcHash(matrix, i, j));
            }
        }
        return set.size();
    }

    int calcHash(int[][] matrix, int i, int j) {
        int result = 1;
        for (int x = i; x <= i + 1; x++) {
            for (int y = j; y <= j + 1; y++) {
                result = 31 * result + matrix[x][y];
            }
        }

        return result;
    }

    int digitsProduct(int product) {
        if (product == 0) {
            return 10;
        }
        if (product < 10) {
            return product;
        }
        int res = 0;
        int t = 1;
        for (int i = 9; i >= 2; i--) {
            while (product % i == 0) {
                product /= i;
                res += t * i;
                t *= 10;
            }
        }
        return res == 0 || product > 9 ? -1 : res;
    }

    String[] fileNaming(String[] names) {
        Map<String, Integer> map = new HashMap<>();
        List<String> res = new ArrayList<>();
        for (String s : names) {
            int add = map.compute(s, (x, y) -> y == null ? 0 : y + 1);
            if (add == 0) {
                res.add(s);
            } else {
                String str;
                do {
                    str = s + '(' + add + ')';
                    if (map.containsKey(str)) {
                        add++;
                    }
                } while (map.containsKey(str));
                map.put(s, add);
                map.put(str, 0);
                res.add(str);
            }
        }
        return res.toArray(new String[0]);
    }

    String messageFromBinaryCode(String code) {
        String s = "";
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < code.length(); i += 8) {
            s = code.substring(i, i + 8);
            sb.append((char) Integer.parseInt(s, 2));
        }

        return sb.toString();
    }

    int[][] spiralNumbers(int n) {
        int[][] res = new int[n][n];
        int dir = 0;
        int row = 0;
        int col = 0;
        int cur = 1;
        boolean isFinish = false;
        while (!isFinish) {
            for (; row < n && col < n && row >= 0 && col >= 0; ) {
                if (res[row][col] != 0) {
                    break;
                }
                res[row][col] = cur++;
                if (cur > n * n) {
                    isFinish = true;
                    break;
                }
                if (dir == 0) col++;
                if (dir == 1) row++;
                if (dir == 2) col--;
                if (dir == 3) row--;

            }
            if (dir == 0) {
                col--;
                row++;
            }
            if (dir == 1) {
                row--;
                col--;
            }
            if (dir == 2) {
                col++;
                row--;
            }
            if (dir == 3) {
                row++;
                col++;
            }

            dir++;
            dir = dir % 4;

        }
        return res;
    }

    boolean sudoku(int[][] grid) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                int sum = 0;
                for (int x = i * 3; x < i * 3 + 3; x++) {
                    for (int y = j * 3; y < j * 3 + 3; y++) {
                        sum ^= grid[x][y];
                    }
                }
                if (sum != 1) {
                    return false;
                }
                sum = 0;
            }
        }
        int[] rows = new int[9];
        int[] cols = new int[9];
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                rows[i] ^= grid[j][i];
                cols[i] ^= grid[i][j];
            }
        }
        for (int i = 0; i < 9; i++) {
            if (rows[i] != 1 || cols[i] != 1) {
                return false;
            }
        }
        return true;
    }
}
