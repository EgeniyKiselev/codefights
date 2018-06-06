package evg.codefights.core;

import java.util.Arrays;

public class WaterfallOfIntegration {

    //for tests
    public static void main(String[] args) {
        Arrays.stream(new WaterfallOfIntegration().boxBlur(new int[][]{
                {7, 4, 0, 1},
                {5, 6, 2, 2},
                {6, 10, 7, 8},
                {1, 4, 2, 0}
        })).forEach(i -> System.out.println(Arrays.toString(i)));
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

    int[][] minesweeper(boolean[][] matrix) {
        if (matrix == null || matrix.length == 0) {
            return new int[0][0];
        }
        int n = matrix.length;
        int m = matrix[0].length;

        int[][] res = new int[n][m];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j]) {
                    int top = Math.max(0, i - 1);
                    int bottom = Math.min(n - 1, i + 1);
                    int left = Math.max(0, j - 1);
                    int right = Math.min(m - 1, j + 1);
                    for (int r = top; r <= bottom; r++) {
                        for (int c = left; c <= right; c++) {
                            if (r == i && c == j) {
                                continue;
                            }
                            res[r][c]++;
                        }
                    }
                }

            }
        }
        return res;
    }

    int[][] boxBlur(int[][] image) {
        int resRow = image.length - 2;
        int resCol = image[0].length - 2;
        int[][] res = new int[resRow][resCol];
        for (int i = 0; i < resRow; i++) {
            for (int j = 0; j < resCol; j++) {
                int sum = 0;
                for (int r = i; r < i + 3; r++) {
                    for (int c = j; c < j + 3; c++) {
                        sum += image[r][c];
                    }
                }
                res[i][j] = sum / 9;
            }
        }
        return res;
    }
}
