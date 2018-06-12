package evg.codefights.core;

import java.util.*;

public class SortingOutpost {

    public static void main(String[] args) {
        SortingOutpost so = new SortingOutpost();
        System.out.println(Arrays.toString(so.sortByLength(new String[]{"abc",
                "",
                "aaa",
                "a",
                "zz"})));
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
}
