package evg.codefights.intro;

import java.util.*;
import java.util.regex.*;

public class IslandOfKnowledge {

    public static void main(String[] args) {

    }

    boolean areEquallyStrong(int yourLeft, int yourRight, int friendsLeft, int friendsRight) {
        return Math.max(yourLeft, yourRight) == Math.max(friendsLeft, friendsRight)
                && Math.min(yourLeft, yourRight) == Math.min(friendsLeft, friendsRight);
    }

    int arrayMaximalAdjacentDifference(int[] inputArray) {
        int res = 0;
        for (int i = 1; i < inputArray.length; i++) {
            int dif = Math.abs(inputArray[i] - inputArray[i - 1]);
            res = Math.max(res, dif);
        }
        return res;
    }

    boolean isIPv4Address(String inputString) {
        Pattern p = Pattern.compile("^(\\d+)\\.(\\d+)\\.(\\d+)\\.(\\d+)$");
        Matcher m = p.matcher(inputString);
        if (m.find()) {
            for(int i = 1; i <= m.groupCount(); i++) {
                if (m.group(i).length() > 3) {
                    return false;
                }
                int v = Integer.parseInt(m.group(i));
                if (v < 0 || v > 255) {
                    return false;
                }
            }
        } else {
            return false;
        }
        return true;
    }

    int avoidObstacles(int[] inputArray) {
        Arrays.sort(inputArray);
        int longestInterval = 0;
        int currentInterval = 1;
        Set<Integer> set = new HashSet<>();
        set.add(inputArray[0]);
        for(int i = 1; i < inputArray.length; i++) {
            set.add(inputArray[i]);
            if (inputArray[i - 1] + 1 == inputArray[i]) {
                currentInterval++;
            } else {
                longestInterval = Math.max(longestInterval, currentInterval);
                currentInterval = 1;
            }
        }
        longestInterval = Math.max(longestInterval, currentInterval);
        while (longestInterval <= inputArray[inputArray.length -1]) {
            boolean isFound = true;
            for(int i = 0; i <= inputArray[inputArray.length -1]; i += longestInterval) {
                if (set.contains(i)) {
                    isFound = false;
                    break;
                }
            }
            if (isFound) {
                return longestInterval;
            }
            longestInterval++;
        }
        return longestInterval;
    }

    int[][] boxBlur(int[][] image) {
        int resRow = image.length - 2;
        int resCol = image[0].length - 2;
        int[][] res = new int[resRow][resCol];
        for(int i = 0; i < resRow; i++) {
            for (int j = 0; j < resCol; j++)  {
                int sum = 0;
                for(int r = i; r < i + 3; r++) {
                    for(int c = j; c < j + 3; c++) {
                        sum += image[r][c];
                    }
                }
                res[i][j] = sum / 9;
            }
        }
        return res;
    }

    int[][] minesweeper(boolean[][] matrix) {
        if (matrix == null || matrix.length == 0) {
            return new int[0][0];
        }
        int n = matrix.length;
        int m = matrix[0].length;

        int[][] res = new int[n][m];
        for(int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j]) {
                    int top = Math.max(0, i - 1);
                    int bottom = Math.min(n - 1, i + 1);
                    int left = Math.max(0, j - 1);
                    int right = Math.min(m - 1, j + 1);
                    for(int r = top; r <= bottom; r++) {
                        for(int c = left; c <= right; c++) {
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

}
