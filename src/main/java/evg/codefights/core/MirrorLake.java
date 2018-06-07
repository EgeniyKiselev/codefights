package evg.codefights.core;

import java.util.*;

public class MirrorLake {

    int stringsConstruction(String a, String b) {
        int[] achars = new int[256];
        int[] bchars = new int[256];
        Set<Character> set = new HashSet<>();
        for (int i = 0; i < a.length(); i++) {
            achars[a.charAt(i)]++;
        }
        for (int i = 0; i < b.length(); i++) {
            bchars[b.charAt(i)]++;
        }
        int res = Integer.MAX_VALUE;
        for (int i = 0; i < achars.length; i++) {
            if (achars[i] == 0) {
                continue;
            }
            if (achars[i] > bchars[i]) {
                return 0;
            }
            res = Math.min(res, bchars[i] / achars[i]);
        }
        return res;
    }

    boolean isSubstitutionCipher(String string1, String string2) {
        Map<Character, Character> map1 = new HashMap<>();
        Map<Character, Character> map2 = new HashMap<>();
        for (int i = 0; i < string1.length(); i++) {
            map1.putIfAbsent(string1.charAt(i), string2.charAt(i));
            map2.putIfAbsent(string2.charAt(i), string1.charAt(i));
            if (string2.charAt(i) != map1.get(string1.charAt(i)) || string1.charAt(i) != map2.get(string2.charAt(i))) {
                return false;
            }
        }
        return true;
    }

    int createAnagram(String s, String t) {
        int[] chars = new int[128];
        for (int i = 0; i < s.length(); i++) {
            chars[s.charAt(i)]++;
            chars[t.charAt(i)]--;
        }
        int res = 0;
        for (int i : chars) {
            res += Math.abs(i);
        }
        return res / 2;
    }

    int constructSquare(String s) {
        int[] chars = new int[26];
        for (int i = 0; i < s.length(); i++) {
            chars[s.charAt(i) - 'a']++;
        }
        Arrays.sort(chars);
        int len = s.length();
        int start = (int) Math.pow(10, len - 1);
        int res = -1;
        for (int i = (int) Math.sqrt(start); i * i < start * 10; i++) {
            int n = i * i;
            int[] tmp = new int[26];
            while (n != 0) {
                tmp[n % 10]++;
                n /= 10;
            }
            Arrays.sort(tmp);
            if (Arrays.equals(chars, tmp)) {
                res = i * i;
            }

        }
        return res;
    }

    int numbersGrouping(int[] a) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i : a) {
            int groupId = (i - 1) / 10000;
            map.compute(groupId, (k, v) -> v == null ? 1 : v + 1);
        }
        int result = map.size();
        result += map.values().stream().mapToInt(i -> i).sum();
        return result;
    }

    int differentSquares(int[][] matrix) {
        Set<String> set = new HashSet<>();
        for (int i = 0; i < matrix.length - 1; i++) {
            for (int j = 0; j < matrix[i].length - 1; j++) {
                int[] arr = new int[]{matrix[i][j], matrix[i][j + 1], matrix[i + 1][j], matrix[i + 1][j + 1]};
                set.add(Arrays.toString(arr));
            }
        }
        return set.size();
    }

    int mostFrequentDigitSum(int n) {
        int[] digists = new int[54];
        while (n != 0) {
            int x = n;
            int sum = 0;
            while (x != 0) {
                sum += x % 10;
                x /= 10;
            }
            digists[sum]++;
            n -= sum;
        }
        int max = 0;
        int indx = 0;
        for (int i = 0; i < digists.length; i++) {
            if (digists[i] >= max) {
                max = digists[i];
                indx = i;
            }
        }
        return indx;
    }

    int numberOfClans(int[] divisors, int k) {
        Set<Integer> clans = new HashSet<>();
        for (int i = 2; i <= k; i++) {
            boolean isAdd = true;
            for (Integer clan : clans) {
                if (isFriend(divisors, clan, i)) {
                    isAdd = false;
                    break;
                }
            }
            if (isAdd) {
                clans.add(i);
            }
        }

        return clans.size();
    }

    private boolean isFriend(int[] divisors, int a, int b) {
        for (int divisor : divisors) {
            if (!(a % divisor == 0 && b % divisor == 0) && !(a % divisor != 0 && b % divisor != 0)) {
                return false;
            }
        }
        return true;
    }
}
