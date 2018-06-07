package evg.codefights.core;

import java.util.*;
import java.util.regex.*;

public class WellOfIntegration {

    int houseNumbersSum(int[] inputArray) {
        int sum = 0;
        for (int i : inputArray) {
            if (i == 0) {
                break;
            }
            sum += i;
        }
        return sum;
    }

    String[] allLongestStrings(String[] inputArray) {
        int max = 0;
        int count = 0;
        for (String s : inputArray) {
            if (s.length() == max) {
                count++;
            } else if (s.length() > max) {
                max = s.length();
                count = 1;
            }
        }
        String[] res = new String[count];
        int i = 0;
        for (String s : inputArray) {
            if (max == s.length()) {
                res[i++] = s;
            }
        }
        return res;
    }

    int[] houseOfCats(int legs) {
        List<Integer> list = new ArrayList<>();
        int p = 0;
        while (legs >= 0) {
            int cats = 0;
            if (legs % 4 == 2) {
                cats = 1;
            } else {
                cats = 0;
            }
            list.add(p + cats);
            legs -= 4;
            p += 2;
        }
        int[] res = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            res[i] = list.get(i);
        }
        return res;
    }

    boolean alphabetSubsequence(String s) {
        Set<Character> set = new HashSet<>();
        char last = s.charAt(0);
        set.add(s.charAt(0));
        for (int i = 1; i < s.length(); i++) {
            set.add(s.charAt(i));
            if (last >= s.charAt(i)) {
                return false;
            }
            last = s.charAt(i);
        }
        return s.length() == set.size();
    }

    int minimalNumberOfCoins(int[] coins, int price) {
        int res = 0;
        for (int i = coins.length - 1; i >= 0; i--) {
            res += price / coins[i];
            price %= coins[i];
        }
        return res;
    }

    String[] addBorder(String[] picture) {
        String[] res = new String[picture.length + 2];
        int len = picture[0].length();

        for (int i = 1; i < res.length - 1; i++) {
            res[i] = "*" + picture[i - 1] + "*";
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < len + 2; i++) {
            sb.append('*');
        }
        res[0] = sb.toString();
        res[res.length - 1] = res[0];
        return res;
    }

    int[] switchLights(int[] a) {
        for (int i = 0; i < a.length; i++) {
            if (a[i] == 0) {
                continue;
            }
            for (int j = 0; j <= i; j++) {
                a[j] = a[j] == 0 ? 1 : 0;
            }
        }
        return a;
    }

    int timedReading(int maxLength, String text) {
        int res = 0;
        for (String s : text.split("\\W")) {
            if (s.isEmpty() || s.length() > maxLength) {
                continue;
            }
            res++;
        }
        return res;
    }

    int electionsWinners(int[] votes, int k) {
        int max = Arrays.stream(votes).max().getAsInt();
        int result = (int) Arrays.stream(votes).filter(i -> i + k > max).count();
        if (result == 0) {
            int maxNum = (int) Arrays.stream(votes).filter(i -> i == max).count();
            if (maxNum > 1) {
                result = 0;
            } else {
                result = maxNum;
            }
        }
        return result;
    }

    String integerToStringOfFixedWidth(int number, int width) {
        String zero = "00000";
        String s = Integer.toString(number);
        if (s.length() >= width) {
            return s.substring(s.length() - width);
        } else {
            int ss = width - s.length();
            return zero.substring(0, ss) + s;
        }
    }

    boolean areSimilar(int[] a, int[] b) {
        int left = -1;
        int right = -1;

        for (int i = 0; i < a.length; i++) {
            if (a[i] != b[i]) {
                if (left != -1 && right != -1) {
                    return false;
                }
                if (left == -1) {
                    left = i;
                    continue;
                }
                if (right == -1) {
                    if (a[left] == b[i] && a[i] == b[left]) {
                        right = i;
                    } else {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    boolean adaNumber(String line) {
        line = line.replaceAll("_", "");
        Pattern pattern = Pattern.compile("^((\\d{1,2})\\#([0-9_a-fA-F]+)\\#)$|^([0-9_]+)$");
        Matcher matcher = pattern.matcher(line);
        if (matcher.find()) {
            if (matcher.group(4) == null) {
                int base = Integer.parseInt(matcher.group(2));
                if (base < 2 || base > 16) {
                    return false;
                }
                String number = matcher.group(3).toLowerCase();
                for (int i = 0; i < number.length(); i++) {
                    int n = 0;
                    char ch = number.charAt(i);
                    if (ch == '_') {
                        continue;
                    } else if (Character.isDigit(ch)) {
                        n = ch - '0';
                    } else {
                        n = ch - 'a' + 10;
                    }
                    if (n >= base) {
                        return false;
                    }
                }

            } else {
                String s = matcher.group(4);
                return !s.replaceAll("_", "").isEmpty();
            }
        } else {
            return false;
        }
        return true;
    }

    int threeSplit(int[] a) {
        int res = 0;
        int sum1 = 0;
        for (int i = 0; i < a.length - 2; i++) {
            sum1 += a[i];
            int sum2 = 0;
            for (int j = i + 1; j < a.length - 1; j++) {
                sum2 += a[j];
                if (sum1 != sum2) {
                    continue;
                }
                int sum3 = 0;
                for (int k = j + 1; k < a.length; k++) {
                    sum3 += a[k];
                }
                if (sum2 == sum3) {
                    res++;
                }
            }
        }
        return res;
    }


}
