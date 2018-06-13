package evg.codefights.core;

import java.util.*;

public class SortingOutpost {

    public static void main(String[] args) {
        SortingOutpost so = new SortingOutpost();
        System.out.println(so.boxesPacking(new int[]{1, 3, 2}, new int[]{1, 3, 2}, new int[]{1, 3, 2}));
        System.out.println(so.boxesPacking(new int[]{3, 1, 2}, new int[]{3, 1, 2}, new int[]{3, 2, 1}));
        System.out.println(so.boxesPacking(new int[]{1, 1}, new int[]{1, 1}, new int[]{1, 1}));
    }

    int[] shuffledArray(int[] shuffled) {
        int sum = Arrays.stream(shuffled).sum();
        int indx = 0;
        for (int i = 0; i < shuffled.length; i++) {
            if (sum - shuffled[i] == shuffled[i]) {
                indx = i;
                break;
            }
        }
        int[] res = new int[shuffled.length - 1];
        int i = 0;
        for (int j = 0; j < shuffled.length; j++) {
            if (j == indx) {
                continue;
            }
            res[i++] = shuffled[j];
        }
        Arrays.sort(res);
        return res;
    }

    int[] sortByHeight(int[] a) {
        int[] b = new int[a.length];
        System.arraycopy(a, 0, b, 0, a.length);
        Arrays.sort(b);
        int j = 0;
        for (int i = 0; i < a.length; i++) {
            if (a[i] == -1) {
                continue;
            }
            while (j < b.length && b[j] == -1) {
                j++;
            }
            a[i] = b[j++];
        }
        return a;
    }

    String[] sortByLength(String[] inputArray) {
        Arrays.sort(inputArray, Comparator.comparingInt(String::length));
        return inputArray;
    }

    boolean boxesPacking(int[] length, int[] width, int[] height) {
        int len = length.length;
        int[][] boxes = new int[len][3];
        for (int i = 0; i < len; i++) {
            boxes[i][0] = length[i];
            boxes[i][1] = width[i];
            boxes[i][2] = height[i];
            Arrays.sort(boxes[i]);
        }
        for (int i = 0; i < len - 1; i++) {
            for (int j = i + 1; j < len; j++) {
                if (!(boxes[i][0] > boxes[j][0] && boxes[i][1] > boxes[j][1] && boxes[i][2] > boxes[j][2])
                        && !(boxes[i][0] < boxes[j][0] && boxes[i][1] < boxes[j][1] && boxes[i][2] < boxes[j][2])) {
                    return false;
                }
            }
        }
        return true;
    }
}
