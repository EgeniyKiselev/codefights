package evg.codefights.core;

import java.util.Arrays;

public class WaterfallOfIntegration {

    //for tests
    public static void main(String[] args) {
//        WaterfallOfIntegration w = new WaterfallOfIntegration();
//        int row = 50; int col = 100;
//        System.out.println("row=" + row + " col=" + col);
//        for(int i = 0; i < 296; i++) {
//            System.out.println(w.getIndexRow(row, col, i) + ", " + w.getIndexCol(row, col, i) + " = " + i);
//        }
//
//        Arrays.stream(new WaterfallOfIntegration().contoursShifting(new int[][]{
//                {1, 2, 3, 4},
//                {5, 6, 7, 8},
//                {9, 10, 11, 12},
//                {13, 14, 15, 16},
//                {17, 18, 19, 20}
//        })).forEach(i -> System.out.println(Arrays.toString(i)));

//        Arrays.stream(new WaterfallOfIntegration().contoursShifting(new int[][]{
//                {238, 239, 240, 241, 242, 243, 244, 245}
//        })).forEach(i -> System.out.println(Arrays.toString(i)));
//        Arrays.stream(new WaterfallOfIntegration().contoursShifting(new int[][]{
//                {238},
//                {239},
//                {240},
//                {241},
//                {242},
//                {243},
//                {244},
//                {245}
//        })).forEach(i -> System.out.println(Arrays.toString(i)));


//        System.out.println(new WaterfallOfIntegration().getIndexCol(4, 3, 0));
//        System.out.println(new WaterfallOfIntegration().getIndexCol(4, 3, 3));
//        System.out.println(new WaterfallOfIntegration().getIndexCol(4, 3, 6));
//        System.out.println(new WaterfallOfIntegration().getIndexCol(4, 3, 7));
//        System.out.println(new WaterfallOfIntegration().getIndexCol(4, 3, 8));
//        System.out.println(new WaterfallOfIntegration().getIndexCol(4, 3, 10));
//        System.out.println(new WaterfallOfIntegration().getIndexCol(4, 3, 11));
//        System.out.println(new WaterfallOfIntegration().getIndexCol(4, 3, 13));
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

    int[][] contoursShifting(int[][] matrix) {
        int row = matrix.length;
        int col = matrix[0].length;
        System.out.println(row + " " + col);
        for (int i = 0; i < (row + 1) / 2 && i < (col + 1) / 2; i++) {
            int c = col - i * 2;
            int r = row - i * 2;
            int total;
            if (c == 1 || r == 1) {
                total = Math.max(c, r) - 1;
            } else {
                total = (r - 1) * 2 + (c - 1) * 2 - 1;
            }
            System.out.println(total);
            if (i % 2 == 0) { // clockwise
                int tmp = matrix[getIndexRow(r, c, total) + i][getIndexCol(r, c, total) + i];
                for (int j = total; j > 0; j--) {
                    matrix[getIndexRow(r, c, j) + i][getIndexCol(r, c, j) + i] = matrix[getIndexRow(r, c, j - 1) + i][getIndexCol(r, c, j - 1) + i];
                }
                matrix[getIndexRow(r, c, 0) + i][getIndexCol(r, c, 0) + i] = tmp;
            } else {
                int tmp = matrix[getIndexRow(r, c, 0) + i][getIndexCol(r, c, 0) + i];
                for (int j = 0; j < total; j++) {
                    matrix[getIndexRow(r, c, j) + i][getIndexCol(r, c, j) + i] = matrix[getIndexRow(r, c, j + 1) + i][getIndexCol(r, c, j + 1) + i];
                }
                matrix[getIndexRow(r, c, total) + i][getIndexCol(r, c, total) + i] = tmp;
            }
        }
        return matrix;
    }

    int getIndexRow(int row, int col, int num) {
        if (num - col < 0) { //top
            return 0;
        } else if (num - col - row + 1 < 0) { //right col
            return num - col + 1;
        } else if (num - col * 2 - row + 2 < 0) { //bottom
            return row - 1;
        } else {
            return (row - 2) - (num - col - (row - 1) - (col - 1));
        }
    }

    int getIndexCol(int row, int col, int num) {
        if (num - col < 0) { //top
            return num;
        } else if (num - col - row + 1 < 0) { //right col
            return col - 1;
        } else if (num - col * 2 - row + 2 < 0) { //bottom
            return col - 2 - (num - col - row + 1);
        } else {
            return 0;
        }
    }
}
